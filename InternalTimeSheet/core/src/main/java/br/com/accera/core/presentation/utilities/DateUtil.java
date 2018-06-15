package br.com.accera.core.presentation.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by fobalan on 25/05/18.
 */

public class DateUtil {
    public static String getBrazilianFormatedString(Date date){
        String dateformat = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' YYYY", LocaleUtil.getBrazilLocale()).format(date);
        dateformat = dateformat.substring(0,1).toUpperCase() + dateformat.substring(1);
        return dateformat;
    }

    public static String getTimeDifference(String startDate, String endDate){
        String s = "13/06/18 ";
        try {
            DateFormat formatter = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
            Date dateOne = formatter.parse(s+startDate);
            Date dateTwo = formatter.parse(s+endDate);

            //milliseconds
            long different =  dateTwo.getTime() - dateOne.getTime();

            long secondsInMilli = 1000;
            long minutesInMilli = secondsInMilli * 60;
            long hoursInMilli = minutesInMilli * 60;
            long daysInMilli = hoursInMilli * 24;

            long elapsedHours = different / hoursInMilli;
            different = different % hoursInMilli;

            long elapsedMinutes = different / minutesInMilli;
            different = different % minutesInMilli;

            long elapsedSeconds = different / secondsInMilli;

            return concatHourMinuteSecond((int)elapsedHours,(int)elapsedMinutes,(int)elapsedSeconds);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return startDate;
    }

    public static String getHourMinuteSecondDashboard(){
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis( System.currentTimeMillis());
        return String.format( "%02d:%02d:%02d", calendar.get( Calendar.HOUR_OF_DAY ), calendar.get( Calendar.MINUTE ), calendar.get( Calendar.SECOND ) );
    }

    public static String addZero(int i){
        if (i < 0){
            return i*-1+"";
        }
        if (i < 10){
            return "0" + i;
        }
        return i+"";
    }

    public static String addZeroHour(int i){
        if (i < 10 && i >= 0){
            return "0" + i;
        }
        if (i < 0 && i >= -10){
            return "-0"+ i*-1;
        }
        return i+"";
    }


    public static String concatHourMinuteSecond(int h, int m, int s){
        return addZeroHour(h) + ":" + addZero(m) + ":" + addZero(s);
    }

    public static String concatDayMonthYear(int d, int m, int y){
        return addZero(d) + "/" + addZero(m+1) + "/" + addZero(y);
    }

    public static Boolean calcHourMin(String time){
        String[] split = time.split(":");
        int hour = 0;
        int minute = 0;

        try {
            hour = Integer.parseInt(split[0]);
            minute = Integer.parseInt(split[1]);
        } catch (NumberFormatException ignored){

        }

        if (hour == 8){
            return minute >= 48;
        } else return hour > 8;
    }
}
