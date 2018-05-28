package br.com.accera.core.presentation.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by fobalan on 25/05/18.
 */

public class DateUtilFormat {
    public static String getBrazilianFormatedString(Date date){
        String dateformat = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' YYYY", LocaleUtil.getBrazilLocale()).format(date);
        dateformat = dateformat.substring(0,1).toUpperCase() + dateformat.substring(1);
        return dateformat;
    }
}
