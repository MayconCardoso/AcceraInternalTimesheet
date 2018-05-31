package br.com.accera.internaltimesheet.ui.dashboard.di;

import br.com.accera.core.presentation.di.scope.ViewScope;
import br.com.accera.core.presentation.ui.baseview.BaseActivity;
import br.com.accera.internaltimesheet.ui.dashboard.DashboardActivity;
import br.com.accera.internaltimesheet.ui.dashboard.DashboardContract;
import br.com.accera.internaltimesheet.ui.dashboard.DashboardPresenterImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * @author MAYCON CARDOSO on 24/05/2018.
 */
@Module
public abstract class DashboardModule {

    @ViewScope
    @Binds
    public abstract BaseActivity provideActivity(DashboardActivity presenter);

    @ViewScope
    @Binds
    public abstract DashboardContract.Presenter providePresenter(DashboardPresenterImpl presenter);
}
