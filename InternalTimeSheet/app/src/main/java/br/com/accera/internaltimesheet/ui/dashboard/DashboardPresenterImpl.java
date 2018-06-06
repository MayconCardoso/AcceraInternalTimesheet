package br.com.accera.internaltimesheet.ui.dashboard;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import br.com.accera.core.presentation.ui.baseview.BasePresenterImpl;
import br.com.accera.core.presentation.utilities.DateUtilFormat;
import br.com.accera.core.presentation.utilities.LocaleUtil;
import br.com.accera.internaltimesheet.ui.base.BaseTimesheetPresenter;

/**
 * Created by fobalan on 24/05/18.
 */

public class DashboardPresenterImpl extends BaseTimesheetPresenter<DashboardContract.View> implements DashboardContract.Presenter {

    @Inject
    public DashboardPresenterImpl() {
    }

    @Override
    public void receiveClick() {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis( System.currentTimeMillis());
        String registeredhour = String.format( "%02d:%02d:%02d", calendar.get( Calendar.HOUR_OF_DAY ), calendar.get( Calendar.MINUTE ), calendar.get( Calendar.SECOND ) ); //HOUR_OF_DAY é a hora no formato de 24 horas.
    }

    @Override
    protected void onViewAttached() {
        super.onViewAttached();
        // Carrega a jornada

        mView.showSpecifcMessage(DateUtilFormat.getBrazilianFormatedString(Calendar.getInstance().getTime()));



    }
}
