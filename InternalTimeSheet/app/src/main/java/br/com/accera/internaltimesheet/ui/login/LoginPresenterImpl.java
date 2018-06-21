package br.com.accera.internaltimesheet.ui.login;

import javax.inject.Inject;

import br.com.accera.internaltimesheet.ui.base.BaseTimesheetPresenter;

/**
 * Created by Rafael Spitaliere on 15/06/18.
 */
public class LoginPresenterImpl extends BaseTimesheetPresenter<LoginContract.View> implements LoginContract.Presenter {

    @Inject
    public LoginPresenterImpl() {
    }

    @Override
    public void receiveClickLogin() {
        mFlowNavigator.goToDashboard();
    }

    @Override
    public void receiveClickRegister() {
        mFlowNavigator.goToRegister();
    }
}
