package br.com.accera.internaltimesheet.ui.login;

import br.com.accera.core.presentation.ui.baseview.BaseMvpContract;

/**
 * Created by Rafael Spitaliere on 15/06/18.
 */
public interface LoginContract {

    interface View extends BaseMvpContract.View{

    }

    interface Presenter extends BaseMvpContract.Presenter<LoginContract.View>{

        void receiveClickLogin();
        void receiveClickRegister();
    }
}
