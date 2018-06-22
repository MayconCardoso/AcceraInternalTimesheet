package br.com.accera.internaltimesheet.ui.main;

import br.com.accera.core.presentation.ui.baseview.BaseMvpContract;
import br.com.accera.internaltimesheet.User;

/**
 * Created by LuisAlmeida on 25/05/18.
 */

public interface MainContract {

    interface View extends BaseMvpContract.View{

        void cleanAllErrors();
        void setCardVisibility();
    }

    interface Presenter extends BaseMvpContract.Presenter<MainContract.View>{
        void receiveClick(User user);
    }
}
