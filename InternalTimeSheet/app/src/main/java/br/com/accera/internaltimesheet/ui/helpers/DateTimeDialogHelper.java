package br.com.accera.internaltimesheet.ui.helpers;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

/**
 * Created by Rafael Spitaliere on 08/06/18.
 */
public class DateTimeDialogHelper {

    public static DatePickerDialog DatePickerDialogDefault(int color, DatePickerDialog.OnDateSetListener onDateSetListener) {
        Calendar now = Calendar.getInstance();
        DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(
                onDateSetListener,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.setAccentColor(color);
        return datePickerDialog;
    }

    public static TimePickerDialog showTimePickerDialogDefault(int color, TimePickerDialog.OnTimeSetListener onTimeChangedListener) {
        Calendar now = Calendar.getInstance();
        TimePickerDialog timePickerDialog = TimePickerDialog.newInstance(
                onTimeChangedListener,
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND),
                true
        );
        timePickerDialog.setAccentColor(color);
        return timePickerDialog;
    }
}
