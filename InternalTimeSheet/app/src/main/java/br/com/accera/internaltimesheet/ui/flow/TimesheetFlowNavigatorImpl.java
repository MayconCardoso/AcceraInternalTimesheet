package br.com.accera.internaltimesheet.ui.flow;

import android.content.Context;
import android.content.Intent;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.accera.internaltimesheet.ui.dashboard.DashboardActivity;
import br.com.accera.internaltimesheet.ui.login.LoginActivity;
import br.com.accera.internaltimesheet.ui.menu.MenuActivity;
import br.com.accera.internaltimesheet.ui.register.RegisterActivity;

/**
 * Created by fobalan on 24/05/18.
 */

public class TimesheetFlowNavigatorImpl implements TimesheetFlowNavigator {
    private Context mContext;

    @Inject
    public TimesheetFlowNavigatorImpl(@Named("ViewContext")Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void goToMenu() {
        Intent intent = new Intent(mContext, MenuActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public void goToDashboard() {
        Intent intent = new Intent(mContext, DashboardActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public void goToRegister() {
        Intent intent = new Intent(mContext, RegisterActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public void goToLogin() {
        Intent intent = new Intent(mContext, LoginActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public void releaseMemory() {
        mContext = null;
    }


}
