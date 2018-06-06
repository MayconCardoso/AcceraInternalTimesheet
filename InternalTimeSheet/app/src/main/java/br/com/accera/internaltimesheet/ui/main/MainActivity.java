package br.com.accera.internaltimesheet.ui.main;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.view.View;

import com.thekhaeng.pushdownanim.PushDownAnim;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

import br.com.accera.core.presentation.ui.baseview.BaseActivity;
import br.com.accera.core.presentation.utilities.DataBindResolverInstance;
import br.com.accera.internaltimesheet.R;
import br.com.accera.internaltimesheet.User;
import br.com.accera.internaltimesheet.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter> implements MainContract.View, TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {


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

    boolean startInterval;
    boolean startJourney;


    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        String time = hourOfDay + "h" + minute + "m" + second;
        if (startInterval) {
            binding.startInterval.setText(time);
        } else {
            binding.endInterval.setText(time);
        }
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
        if (startJourney) {
            binding.startJourney.setText(date);
        } else {
            binding.endJourney.setText(date);
        }
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

        PushDownAnim.setPushDownAnimTo(binding.start)
                .setOnClickListener(view ->
                        mCorePresenter.receiveClick(new User(binding.getCadastro().name,
                                binding.getCadastro().startJourney,
                                binding.getCadastro().startInterval,
                                binding.getCadastro().endInterval,
                                binding.getCadastro().endJourney))
                );

        binding.startJourney.setOnClickListener(v -> {
            Calendar now = Calendar.getInstance();
            startJourney = true;
            DatePickerDialog dpd = DatePickerDialog.newInstance(
                    MainActivity.this,
                    now.get(Calendar.YEAR),
                    now.get(Calendar.MONTH),
                    now.get(Calendar.DAY_OF_MONTH)
            );
            dpd.setAccentColor("#d35400");
            dpd.show(getFragmentManager(), "Datepickerdialog");
        });

        binding.endJourney.setOnClickListener(v -> {
            Calendar now = Calendar.getInstance();
            startJourney = false;
            DatePickerDialog dpd = DatePickerDialog.newInstance(
                    MainActivity.this,
                    now.get(Calendar.YEAR),
                    now.get(Calendar.MONTH),
                    now.get(Calendar.DAY_OF_MONTH)
            );
            dpd.setAccentColor("#d35400");
            dpd.show(getFragmentManager(), "Datepickerdialog");
        });

        binding.endInterval.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startInterval = false;
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        MainActivity.this,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        true
                );
                tpd.setAccentColor("#d35400");
                tpd.show(getFragmentManager(), "Timepickerdialog");
            }
        });

        binding.startInterval.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                startInterval = true;
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        MainActivity.this,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        true
                );
                tpd.setAccentColor("#d35400");
                tpd.show(getFragmentManager(), "Timepickerdialog");
            }
        });
    }
}