package br.com.accera.internaltimesheet.ui.login;

import br.com.accera.core.presentation.ui.baseview.BaseMvpContract;
import br.com.accera.internaltimesheet.ui.login.model.UserLogin;

/**
 * Created by Rafael Spitaliere on 15/06/18.
 */
public interface LoginContract {

    interface View extends BaseMvpContract.View{

        void setLoginScreen();
        void setRegisterScreen();
        void showLoading();
        void hideLoad();
        void clearErrors();
    }

    interface Presenter extends BaseMvpContract.Presenter<LoginContract.View>{

        void receiveClickLogin();
        void receiveClickRegister(UserLogin userLogin);
    }
}
