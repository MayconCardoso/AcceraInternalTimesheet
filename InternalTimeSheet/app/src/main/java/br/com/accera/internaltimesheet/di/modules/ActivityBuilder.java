package br.com.accera.internaltimesheet.di.modules;

import br.com.accera.core.presentation.di.scope.ViewScope;
import br.com.accera.internaltimesheet.ui.dashboard.DashboardActivity;
import br.com.accera.internaltimesheet.ui.dashboard.di.DashboardModule;
import br.com.accera.internaltimesheet.ui.login.LoginActivity;
import br.com.accera.internaltimesheet.ui.login.di.LoginModule;
import br.com.accera.internaltimesheet.ui.menu.MenuActivity;
import br.com.accera.internaltimesheet.ui.menu.di.MenuModule;
import br.com.accera.internaltimesheet.ui.register.RegisterActivity;
import br.com.accera.internaltimesheet.ui.register.di.RegisterModule;
import br.com.accera.internaltimesheet.ui.register.di.UserModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author MAYCON CARDOSO on 24/05/2018.
 */
@Module
public abstract class ActivityBuilder {
    @ViewScope
    @ContributesAndroidInjector(modules = {DashboardModule.class, ViewModule.class})
    abstract DashboardActivity bindDashboardActivity();

    @ViewScope
    @ContributesAndroidInjector(modules = {RegisterModule.class, UserModule.class, ViewModule.class})
    abstract RegisterActivity bindMainActivity();

    @ViewScope
    @ContributesAndroidInjector(modules = {LoginModule.class, ViewModule.class})
    abstract LoginActivity bindLoginActivity();

    @ViewScope
    @ContributesAndroidInjector(modules = {MenuModule.class, ViewModule.class})
    abstract MenuActivity bindMenuActivity();

}
