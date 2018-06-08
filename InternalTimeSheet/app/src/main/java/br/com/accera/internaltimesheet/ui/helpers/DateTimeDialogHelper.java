package br.com.accera.internaltimesheet.ui.helpers;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

/**
 * Created by Rafael Spitaliere on 08/06/18.
 */
public class DateTimeDialogHelper {

    public static DatePickerDialog DatePickerDialogDefault(DatePickerDialog.OnDateSetListener onDateSetListener) {
        Calendar now = Calendar.getInstance();
        return DatePickerDialog.newInstance(
                onDateSetListener,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );

    }

    public static TimePickerDialog showTimePickerDialogDefault(TimePickerDialog.OnTimeSetListener onTimeChangedListener) {
        Calendar now = Calendar.getInstance();
        return TimePickerDialog.newInstance(
                onTimeChangedListener,
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND),
                true
        );
    }
}
