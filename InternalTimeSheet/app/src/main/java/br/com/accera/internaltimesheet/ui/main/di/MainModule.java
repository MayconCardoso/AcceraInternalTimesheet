package br.com.accera.internaltimesheet.ui.main.di;

import br.com.accera.core.presentation.di.scope.ViewScope;
import br.com.accera.core.presentation.ui.baseview.BaseActivity;
import br.com.accera.internaltimesheet.ui.dashboard.DashboardActivity;
import br.com.accera.internaltimesheet.ui.dashboard.DashboardContract;
import br.com.accera.internaltimesheet.ui.dashboard.DashboardPresenterImpl;
import br.com.accera.internaltimesheet.ui.main.MainActivity;
import br.com.accera.internaltimesheet.ui.main.MainContract;
import br.com.accera.internaltimesheet.ui.main.MainPresenterImpl;
import dagger.Binds;
import dagger.Module;

/**
 * @author MAYCON CARDOSO on 24/05/2018.
 */
@Module
public abstract class MainModule {

    @ViewScope
    @Binds
    public abstract BaseActivity provideActivity(MainActivity presenter);

    @ViewScope
    @Binds
    public abstract MainContract.Presenter providePresenter(MainPresenterImpl presenter);
}
