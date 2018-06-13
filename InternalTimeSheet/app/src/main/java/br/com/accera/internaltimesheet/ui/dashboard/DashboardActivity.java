package br.com.accera.internaltimesheet.ui.dashboard;

import android.databinding.ViewDataBinding;
import android.os.Handler;
import android.os.SystemClock;

import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

import javax.inject.Inject;

import br.com.accera.core.presentation.ui.baseview.BaseActivity;
import br.com.accera.core.presentation.utilities.DataBindResolverInstance;
import br.com.accera.core.providers.network.NetworkInfoProvider;
import br.com.accera.internaltimesheet.R;
import br.com.accera.internaltimesheet.databinding.ActivityDashboardBinding;
import br.com.accera.internaltimesheet.ui.animation.PushDownAnimHelper;

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

        PushDownAnimHelper.createDefault(binding.outHour, v -> timeControl = false);
        PushDownAnimHelper.createDefault(binding.inHour, v -> timeControl = true);
        PushDownAnimHelper.createDefault(binding.imgClock, v -> mCorePresenter.receiveClick(timeControl));
        PushDownAnimHelper.createDefault(binding.inEdit, v -> showTimePickerDialog((view, hourOfDay, minute, second)
                -> mCorePresenter.editTimeIn(hourOfDay , minute, second)));
        PushDownAnimHelper.createDefault(binding.outEdit, v -> showTimePickerDialog((view, hourOfDay, minute, second)
                -> mCorePresenter.editTimeOut(hourOfDay , minute, second)) );

    }

    @Override
    public void showSpecifcMessage(String message) {
        binding.dataCabecalho.setText(message);
    }

    @Override
    public void setTimeIn(String time) {
        binding.inHour.setText(time);
        binding.inHour.setTextColor(mResourceHelper.getColor(R.color.colorPrimary));
        timeControl = false;
    }

    @Override
    public void setTimeOut(String time) {
        binding.outHour.setText(time);
        binding.outHour.setTextColor(mResourceHelper.getColor(R.color.colorPrimary));
    }

    @Override
    public void setTimeDiff(String time, int color) {
        binding.totalHours.setText(time);
        binding.totalHours.setTextColor(mResourceHelper.getColor(color));
    }


        private void startBedside() {
        final Calendar calendar = Calendar.getInstance(); //instanciou o calendario do android
        // Runnable é uma interface. Consegue fazer interface pq no java é uma classe anônima. Uma classe anonima não precisa explicitamente escrever Runnable
        this.mRunnable = new Runnable() {
            @Override
            public void run() {

                if( mRunnableStopped ) return;


                calendar.setTimeInMillis( System.currentTimeMillis() ); //pegou o equivalente da hora em millisegundos

                String hourMinutesFormat = String.format( "%02d:%02d:%02d", calendar.get( Calendar.HOUR_OF_DAY ), calendar.get( Calendar.MINUTE ), calendar.get( Calendar.SECOND ) ); //HOUR_OF_DAY é a hora no formato de 24 horas.

                //  mViewHolder.mTextHourMinute.setText(hourMinutesFormat);
                //  mViewHolder.mTextSeconds.setText(secondsFormat);

                binding.horaMolde.setText( hourMinutesFormat );

                long now = SystemClock.uptimeMillis();
                long next = now + (1000 - (now % 1000)); //este calculo faz cair no milisegundo 0 do proximo segundo.

                mHandler.postAtTime( mRunnable, next );
            }
        };
        this.mRunnable.run();
    }

    private void showTimePickerDialog(TimePickerDialog.OnTimeSetListener onTimeChangedListener) {
        Calendar now = Calendar.getInstance();
        TimePickerDialog tpd = TimePickerDialog.newInstance(
                onTimeChangedListener,
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND),
                true
        );
        tpd.setAccentColor(mResourceHelper.getColor(R.color.colorPrimaryDark));
        tpd.show(getFragmentManager(), "Timepickerdialog");
    }

}
