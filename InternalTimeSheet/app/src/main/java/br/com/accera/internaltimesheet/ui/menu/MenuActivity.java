package br.com.accera.internaltimesheet.ui.menu;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import br.com.accera.core.presentation.ui.baseview.BaseActivity;
import br.com.accera.core.presentation.utilities.DataBindResolverInstance;
import br.com.accera.internaltimesheet.R;
import br.com.accera.internaltimesheet.databinding.ActivityMenuBinding;
import br.com.accera.internaltimesheet.databinding.ActivityRegisterBinding;
import br.com.accera.internaltimesheet.di.modules.ActivityBuilder_BindMenuActivity;

/**
 * Created by Rafael Spitaliere on 07/08/2018.
 */

public class MenuActivity extends BaseActivity<MenuContract.View,MenuContract.Presenter> implements MenuContract.View {

    ActivityMenuBinding binding;

    @Override
    protected MenuContract.View getContractView() {
        return null;
    }

    @Override
    protected int getInflateView() {
        return R.layout.activity_menu;
    }

    @Override
    protected boolean hasToolbar() {
        return false;
    }

    @Override
    protected void onDataBindingReady(ViewDataBinding coreDataBinding) {
        binding = DataBindResolverInstance.getBinding(ActivityMenuBinding.class, coreDataBinding);

    }



}
