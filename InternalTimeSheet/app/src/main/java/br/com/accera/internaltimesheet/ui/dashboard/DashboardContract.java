package br.com.accera.internaltimesheet.ui.dashboard;

import br.com.accera.core.presentation.ui.baseview.BaseMvpContract;

/**
 * Created by fobalan on 24/05/18.
 */

public interface DashboardContract {

    interface View extends BaseMvpContract.View{
        void showSpecifcMessage(String message);
        void setTimeIn(String time);
        void setTimeOut(String time);
        void setTimeDiff(String time, int color);
    }

    interface Presenter extends BaseMvpContract.Presenter<View>{
        void receiveClick(Boolean time);
        void editTimeIn(int h, int m, int s);
        void editTimeOut(int h, int m, int s);
    }
}
