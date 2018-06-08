package br.com.accera.internaltimesheet.ui.main;

import android.databinding.ViewDataBinding;
import android.os.Bundle;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

import br.com.accera.core.presentation.ui.baseview.BaseActivity;
import br.com.accera.core.presentation.utilities.DataBindResolverInstance;
import br.com.accera.internaltimesheet.R;
import br.com.accera.internaltimesheet.User;
import br.com.accera.internaltimesheet.databinding.ActivityMainBinding;
import br.com.accera.internaltimesheet.ui.animation.PushDownAnimHelper;

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

        binding.startJourney.setOnClickListener(v -> {
            showDatePickerDialog((view, year, monthOfYear, dayOfMonth) -> {
                String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                binding.startJourney.setText(date);
            });
        });

        binding.endJourney.setOnClickListener(v -> {
            showDatePickerDialog((view, year, monthOfYear, dayOfMonth) -> {
                String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                binding.endJourney.setText(date);
            });
        });

        binding.endInterval.setOnClickListener(v -> {
            showTimePickerDialog((view, hourOfDay, minute, second) -> {
                String time = hourOfDay + "h" + minute + "m" + second;
                binding.endInterval.setText(time);
            });
        });

        binding.startInterval.setOnClickListener(v -> {
            showTimePickerDialog((view, hourOfDay, minute, second) -> {
                String time = hourOfDay + "h" + minute + "m" + second;
                binding.startInterval.setText(time);
            });
        });
    }

    private void showDatePickerDialog(DatePickerDialog.OnDateSetListener onDateSetListener) {
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                onDateSetListener,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.setAccentColor(mResourceHelper.getColor(R.color.pumpkin));
        dpd.show(getFragmentManager(), "Datepickerdialog");
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
        tpd.setAccentColor(mResourceHelper.getColor(R.color.pumpkin));
        tpd.show(getFragmentManager(), "Timepickerdialog");
    }
}