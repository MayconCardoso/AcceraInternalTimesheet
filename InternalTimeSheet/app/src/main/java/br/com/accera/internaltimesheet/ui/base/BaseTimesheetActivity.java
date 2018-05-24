package br.com.accera.internaltimesheet.ui.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

import br.com.accera.core.presentation.ui.baseview.BaseActivity;
import br.com.accera.core.presentation.ui.baseview.BaseMvpContract;
import dagger.android.AndroidInjection;

/**
 * @author MAYCON CARDOSO on 24/05/2018.
 */
public abstract class BaseTimesheetActivity<VIEW extends BaseMvpContract.View, PRESENTER extends BaseMvpContract.Presenter<VIEW>> extends BaseActivity<VIEW, PRESENTER> {
    @Override
    @CallSuper
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        AndroidInjection.inject(this);
        super.onCreate( savedInstanceState );
    }
}
