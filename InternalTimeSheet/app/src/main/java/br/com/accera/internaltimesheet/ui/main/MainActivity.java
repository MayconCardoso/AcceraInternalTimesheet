package br.com.accera.internaltimesheet.ui.main;

import android.databinding.ViewDataBinding;
import android.os.Bundle;

import br.com.accera.core.presentation.ui.baseview.BaseActivity;
import br.com.accera.core.presentation.utilities.DataBindResolverInstance;
import br.com.accera.core.presentation.utilities.DateUtilFormat;
import br.com.accera.internaltimesheet.R;
import br.com.accera.internaltimesheet.User;
import br.com.accera.internaltimesheet.databinding.ActivityMainBinding;
import br.com.accera.internaltimesheet.ui.animation.PushDownAnimHelper;
import br.com.accera.internaltimesheet.ui.helpers.DateTimeDialogHelper;

public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter> implements MainContract.View {


    ActivityMainBinding binding;

    @Override
    protected boolean hasToolbar() {
        return false;
    }

    @Override
    protected MainContract.View getContractView() {
        return this;
    }

    @Override
    protected int getInflateView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void cleanAllErrors() {
        binding.name.setError(null);
        binding.startJourney.setError(null);
        binding.startInterval.setError(null);
        binding.endInterval.setError(null);
        binding.endJourney.setError(null);
    }

    @Override
    protected void onDataBindingReady(ViewDataBinding coreDataBinding) {
        int colorDialog = mResourceHelper.getColor(R.color.pumpkin);
        String datepickerdialog = "Datepickerdialog";
        String timepickerdialog = "Timepickerdialog";
        binding = DataBindResolverInstance.getBinding(ActivityMainBinding.class, coreDataBinding);
        binding.setCadastro(new User());
        User obj = new User();
        obj.setName(" ");

        PushDownAnimHelper.createDefault(binding.start, v ->
                mCorePresenter.receiveClick(new User(binding.getCadastro().name,
                binding.getCadastro().startJourney,
                binding.getCadastro().startInterval,
                binding.getCadastro().endInterval,
                binding.getCadastro().endJourney)));

        binding.startJourney.setOnClickListener(v -> DateTimeDialogHelper.DatePickerDialogDefault(colorDialog,
                (view, year, monthOfYear, dayOfMonth) -> binding.startJourney.setText(DateUtilFormat.concatDayMonthYear(dayOfMonth,monthOfYear,year)))
                .show(getFragmentManager(), datepickerdialog)
        );

        binding.endJourney.setOnClickListener(v -> DateTimeDialogHelper.DatePickerDialogDefault(colorDialog,
                (view, year, monthOfYear, dayOfMonth) -> binding.endJourney.setText(DateUtilFormat.concatDayMonthYear(dayOfMonth, monthOfYear, year)))
                .show(getFragmentManager(), datepickerdialog)
        );

        binding.endInterval.setOnClickListener(v -> DateTimeDialogHelper.showTimePickerDialogDefault(colorDialog,
                (view, hourOfDay, minute, second) -> binding.endInterval.setText(DateUtilFormat.concatHourMinuteSecond(hourOfDay,minute,0)))
                .show(getFragmentManager(), timepickerdialog)
        );

        binding.startInterval.setOnClickListener(v -> DateTimeDialogHelper.showTimePickerDialogDefault(colorDialog,
                (view, hourOfDay, minute, second) -> binding.startInterval.setText(DateUtilFormat.concatHourMinuteSecond(hourOfDay,minute,0)))
                .show(getFragmentManager(), timepickerdialog));

    }

}