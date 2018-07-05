package br.com.accera.internaltimesheet.di.modules;

import br.com.accera.core.presentation.di.scope.ViewScope;
import br.com.accera.internaltimesheet.ui.dashboard.DashboardActivity;
import br.com.accera.internaltimesheet.ui.dashboard.di.DashboardModule;
import br.com.accera.internaltimesheet.ui.login.LoginActivity;
import br.com.accera.internaltimesheet.ui.login.di.LoginModule;
import br.com.accera.internaltimesheet.ui.register.MainActivity;
import br.com.accera.internaltimesheet.ui.register.di.MainModule;
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
    @ContributesAndroidInjector(modules = {MainModule.class, UserModule.class, ViewModule.class})
    abstract MainActivity bindMainActivity();

    @ViewScope
    @ContributesAndroidInjector(modules = {LoginModule.class, ViewModule.class})
    abstract LoginActivity bindLoginActivity();
}
