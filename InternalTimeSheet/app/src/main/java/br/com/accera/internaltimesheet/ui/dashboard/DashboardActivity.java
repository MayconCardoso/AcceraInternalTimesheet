package br.com.accera.internaltimesheet.ui.dashboard;

import android.databinding.ViewDataBinding;
import android.os.Handler;
import android.os.SystemClock;

import com.appolica.flubber.Flubber;

import javax.inject.Inject;

import br.com.accera.core.presentation.ui.baseview.BaseActivity;
import br.com.accera.core.presentation.utilities.DataBindResolverInstance;
import br.com.accera.core.presentation.utilities.DateUtil;
import br.com.accera.core.providers.network.NetworkInfoProvider;
import br.com.accera.internaltimesheet.R;
import br.com.accera.internaltimesheet.databinding.ActivityDashboardBinding;
import br.com.accera.internaltimesheet.ui.animation.FlubberAnimHelper;
import br.com.accera.internaltimesheet.ui.animation.PushDownAnimHelper;
import br.com.accera.internaltimesheet.ui.helpers.DateTimeDialogHelper;

public class DashboardActivity extends BaseActivity<DashboardContract.View, DashboardContract.Presenter> implements DashboardContract.View{
    private Handler mHandler = new Handler();
    private Runnable mRunnable;
    private boolean mRunnableStopped = false;
    ActivityDashboardBinding binding;
    private boolean timeControl = true;

    @Inject
    NetworkInfoProvider mAlertHelper;


    @Override
    public void onResume() {
        this.mRunnableStopped = false;
        this.startBedside();
        super.onResume();

    }

    @Override
    public void onStop() {
        super.onStop();
        this.mRunnableStopped = true;
    }

    @Override
    protected boolean hasToolbar() {
        return false;
    }

    @Override
    protected DashboardContract.View getContractView() {
        return this;
    }

    @Override
    protected int getInflateView() {
        return R.layout.activity_dashboard;
    }

    @Override
    protected void onDataBindingReady(ViewDataBinding coreDataBinding) {
        binding = DataBindResolverInstance.getBinding(ActivityDashboardBinding.class, coreDataBinding);
        int colorDialog = mResourceHelper.getColor(R.color.colorPrimaryDark);

//        PushDownAnimHelper.create(binding.outHour, v -> timeControl = false);
//        PushDownAnimHelper.create(binding.inHour, v -> timeControl = true);
        PushDownAnimHelper.createDefault(binding.imgClock, v -> mCorePresenter.receiveClick(timeControl));

        PushDownAnimHelper.createDefault(binding.inEdit, v -> DateTimeDialogHelper.showTimePickerDialogDefault(colorDialog,
                (view, hourOfDay, minute, second) -> mCorePresenter.editTimeIn(hourOfDay , minute, 0))
                .show(getFragmentManager(), "td"));

        PushDownAnimHelper.createDefault(binding.outEdit, v -> DateTimeDialogHelper.showTimePickerDialogDefault(colorDialog,
                (view, hourOfDay, minute, second) -> mCorePresenter.editTimeOut(hourOfDay , minute, 0))
                .show(getFragmentManager(), "td"));

    }

    @Override
    public void showSpecifcMessage(String message) {
        binding.dataCabecalho.setText(message);
    }

    @Override
    public void setTimeIn(String time) {
        FlubberAnimHelper.create(binding.inHour, 100, Flubber.AnimationPreset.POP);
        binding.inHour.setText(time);
        binding.inHour.setTextColor(mResourceHelper.getColor(R.color.colorPrimary));
        timeControl = false;
    }

    @Override
    public void setTimeOut(String time) {
        FlubberAnimHelper.create(binding.outHour, 100, Flubber.AnimationPreset.POP);
        binding.outHour.setText(time);
        binding.outHour.setTextColor(mResourceHelper.getColor(R.color.colorPrimary));
    }

    @Override
    public void setTimeDiff(String time, int color) {
        FlubberAnimHelper.create(binding.totalHours, 600, Flubber.AnimationPreset.MORPH);
        binding.totalHours.setText(time);
        binding.totalHours.setTextColor(mResourceHelper.getColor(color));
    }


        private void startBedside() {
        // Runnable é uma interface. Consegue fazer interface pq no java é uma classe anônima. Uma classe anonima não precisa explicitamente escrever Runnable
        this.mRunnable = () -> {

            if( mRunnableStopped ) return;

            binding.horaMolde.setText( DateUtil.getHourMinuteSecondDashboard() );
            long now = SystemClock.uptimeMillis();
            long next = SystemClock.uptimeMillis() + (1000 - (now % 1000)); //este calculo faz cair no milisegundo 0 do proximo segundo.
            mHandler.postAtTime( mRunnable, next );

        };
        this.mRunnable.run();
    }

}
