package br.com.accera.internaltimesheet.ui.login;

import android.text.TextUtils;

import javax.inject.Inject;

import br.com.accera.data.auth.AuthRepository;
import br.com.accera.data.auth.callback.AuthCompleteResponse;
import br.com.accera.internaltimesheet.R;
import br.com.accera.internaltimesheet.ui.base.BaseTimesheetPresenter;
import br.com.accera.internaltimesheet.ui.login.mapper.UserLoginMapper;
import br.com.accera.internaltimesheet.ui.login.model.UserLogin;

/**
 * Created by Rafael Spitaliere on 15/06/18.
 */
public class LoginPresenterImpl extends BaseTimesheetPresenter<LoginContract.View> implements LoginContract.Presenter {

    private static final String TAG = LoginPresenterImpl.class.getName();
    private AuthRepository mAuthRepository;

    @Inject
    public LoginPresenterImpl(AuthRepository authRepository) {
        this.mAuthRepository = authRepository;
    }

    @Override
    public void receiveClickLogin() {
        mFlowNavigator.goToMenu();
    }

    @Override
    public void receiveClickRegister(UserLogin userLogin) {
        mView.clearErrors();

        if (TextUtils.isEmpty(userLogin.user)){
            mView.setErrorOnField(R.id.login_email, mView.getResourceHelper().getString(R.string.email_error));
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(userLogin.user).matches()){
            mView.setErrorOnField(R.id.login_email, mView.getResourceHelper().getString(R.string.email_error2));
            return;
        }

        if (TextUtils.isEmpty(userLogin.password)){
            mView.setErrorOnField(R.id.login_password, mView.getResourceHelper().getString(R.string.password_error));
            return;
        }

        if (TextUtils.isEmpty(userLogin.password2)){
            mView.setErrorOnField(R.id.login_password_two, mView.getResourceHelper().getString(R.string.password_error));
            return;
        }

        if (!userLogin.password.equals(userLogin.password2)){
            mView.setErrorOnField(R.id.login_password_two, mView.getResourceHelper().getString(R.string.password_error2));
            return;
        }


        mView.showLoading();
        mAuthRepository.registerUser(new UserLoginMapper.ToUserLoginDto().transform(userLogin), new AuthCompleteResponse() {
            @Override
            public void OnSuccess() {
                mView.getAlertHelper().showSimpleMessage("Sucesso!");
                mView.hideLoad();
                mView.setLoginScreen();
            }

            @Override
            public void OnFailure(Exception exception) {
                mView.getAlertHelper().showErrorMessage(exception);
                mView.hideLoad();
            }
        });
    }
}
