package br.com.accera.internaltimesheet.ui.dashboard;

import java.util.Calendar;

import javax.inject.Inject;

import br.com.accera.core.presentation.utilities.DateUtil;
import br.com.accera.internaltimesheet.R;
import br.com.accera.internaltimesheet.ui.base.BaseTimesheetPresenter;

/**
 * Created by fobalan on 24/05/18.
 */

public class DashboardPresenterImpl extends BaseTimesheetPresenter<DashboardContract.View> implements DashboardContract.Presenter {

    @Inject
    public DashboardPresenterImpl() {
    }

    @Override
    public void receiveClick(Boolean time) {
        if (time){
            mView.setTimeIn(DateUtil.getHourMinuteSecondDashboard());
        } else {
            mView.setTimeOut(DateUtil.getHourMinuteSecondDashboard());
            setTimeDiff();
        }
    }

    @Override
    public void editTimeIn(int h, int m, int s) {
        mView.setTimeIn(DateUtil.concatHourMinuteSecond(h,m,s));
    }

    @Override
    public void editTimeOut(int h, int m, int s) {
        mView.setTimeOut(DateUtil.concatHourMinuteSecond(h,m,s));
        setTimeDiff();
    }

    private void setTimeDiff() {
        String timeDiff = getTimeDiff();
        mView.setTimeDiff(timeDiff, getColor(timeDiff));
    }

    private String getTimeDiff() {
        String hourOne = mView.getTextFromTextView(R.id.in_hour);
        String hourTwo = mView.getTextFromTextView(R.id.out_hour);
        return DateUtil.getTimeDifference(hourOne, hourTwo);
    }

    private int getColor(String time){
        if (DateUtil.calcHourMin(time)){
            return R.color.emerald;
        } else {
            return R.color.pomegranate;
        }
    }

    @Override
    protected void onViewAttached() {
        super.onViewAttached();
        // Carrega a jornada

        mView.showSpecifcMessage(DateUtil.getBrazilianFormatedString(Calendar.getInstance().getTime()));



    }
}
