package br.com.accera.internaltimesheet.ui.login;

import android.databinding.ViewDataBinding;
import android.view.View;

import br.com.accera.core.presentation.ui.baseview.BaseActivity;
import br.com.accera.core.presentation.utilities.DataBindResolverInstance;
import br.com.accera.internaltimesheet.R;
import br.com.accera.internaltimesheet.databinding.ActivityLoginBinding;
import br.com.accera.internaltimesheet.ui.animation.PushDownAnimHelper;
import br.com.accera.internaltimesheet.ui.login.model.UserLogin;

public class LoginActivity extends BaseActivity<LoginContract.View, LoginContract.Presenter> implements LoginContract.View {

    ActivityLoginBinding loginBinding;

    @Override
    protected boolean hasToolbar() {
        return false;
    }

    @Override
    protected LoginContract.View getContractView() {
        return this;
    }

    @Override
    protected int getInflateView() {
        return R.layout.activity_login;
    }

    @Override
    protected void onDataBindingReady(ViewDataBinding coreDataBinding) {
        loginBinding = DataBindResolverInstance.getBinding(ActivityLoginBinding.class, coreDataBinding);
        loginBinding.setUserLogin(new UserLogin());

        PushDownAnimHelper.createDefault(loginBinding.loginStart, v -> mCorePresenter.receiveClickLogin());

        PushDownAnimHelper.createDefault(loginBinding.loginRegisterUser, v -> mCorePresenter.receiveClickRegister(loginBinding.getUserLogin()) );

        PushDownAnimHelper.createDefault(loginBinding.loginBack, v -> setLoginScreen()).setScale(0.99F);

        PushDownAnimHelper.createDefault(loginBinding.loginRegister, v -> setRegisterScreen()).setScale(0.99F);


    }

    @Override
    public void setLoginScreen() {
        loginBinding.loginRegisterButtonLayout.setVisibility(View.VISIBLE);
        loginBinding.loginStart.setVisibility(View.VISIBLE);
        loginBinding.loginRegisterUser.setVisibility(View.GONE);
        loginBinding.passTwoLayout.setVisibility(View.GONE);
        loginBinding.loginRegisterButtonLayoutBack.setVisibility(View.GONE);
    }

    @Override
    public void setRegisterScreen() {
        loginBinding.loginRegisterButtonLayout.setVisibility(View.GONE);
        loginBinding.loginStart.setVisibility(View.GONE);
        loginBinding.loginRegisterUser.setVisibility(View.VISIBLE);
        loginBinding.passTwoLayout.setVisibility(View.VISIBLE);
        loginBinding.loginRegisterButtonLayoutBack.setVisibility(View.VISIBLE);

    }

    @Override
    public void showLoading() {
        loginBinding.progressbarLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoad() {
        loginBinding.progressbarLogin.setVisibility(View.GONE);
    }

    @Override
    public void clearErrors() {
        loginBinding.loginEmail.setError(null);
        loginBinding.loginPassword.setError(null);
        loginBinding.loginPasswordTwo.setError(null);
    }
}
