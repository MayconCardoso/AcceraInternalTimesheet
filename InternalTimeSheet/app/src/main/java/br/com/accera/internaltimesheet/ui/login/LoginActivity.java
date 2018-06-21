package br.com.accera.internaltimesheet.ui.login;

import android.databinding.ViewDataBinding;

import br.com.accera.core.presentation.ui.baseview.BaseActivity;
import br.com.accera.core.presentation.utilities.DataBindResolverInstance;
import br.com.accera.internaltimesheet.R;
import br.com.accera.internaltimesheet.databinding.ActivityLoginBinding;
import br.com.accera.internaltimesheet.ui.animation.PushDownAnimHelper;

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

        PushDownAnimHelper.createDefault(loginBinding.loginStart, v -> mCorePresenter.receiveClickLogin());

        PushDownAnimHelper.createDefault(loginBinding.loginRegister, v -> mCorePresenter.receiveClickRegister());

    }
}
