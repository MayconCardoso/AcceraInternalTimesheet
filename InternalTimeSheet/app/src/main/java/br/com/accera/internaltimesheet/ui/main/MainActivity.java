package br.com.accera.internaltimesheet.ui.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.thekhaeng.pushdownanim.PushDownAnim;

import javax.inject.Inject;

import br.com.accera.core.presentation.ui.baseview.BaseActivity;
import br.com.accera.core.presentation.utilities.DataBindResolverInstance;
import br.com.accera.core.providers.network.NetworkInfoProvider;
import br.com.accera.internaltimesheet.R;
import br.com.accera.internaltimesheet.User;
import br.com.accera.internaltimesheet.databinding.ActivityDashboardBinding;
import br.com.accera.internaltimesheet.databinding.ActivityMainBinding;
import br.com.accera.internaltimesheet.ui.dashboard.DashboardActivity;
import br.com.accera.internaltimesheet.ui.dashboard.DashboardContract;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;

public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter> implements MainContract.View {


    ActivityMainBinding binding;

    @Override
    protected boolean hasToolbar() {
        return false;
    }


    @Override
    protected MainContract.View getContractView() {
        return this;
    }

    @Override
    protected int getInflateView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onDataBindingReady(ViewDataBinding coreDataBinding) {
        binding = DataBindResolverInstance.getBinding(ActivityMainBinding.class, coreDataBinding);
        binding.setCadastro(new User());
        User obj = new User();
        obj.setNome(" ");

        PushDownAnim.setPushDownAnimTo(binding.start)
                .setOnClickListener(view ->
                        mCorePresenter.receiveClick(binding.getCadastro().Nome, binding.getCadastro().Diainit, binding.getCadastro().Intervaloinit, binding.getCadastro().Intervaloend, binding.getCadastro().Diaend));
    }
}

