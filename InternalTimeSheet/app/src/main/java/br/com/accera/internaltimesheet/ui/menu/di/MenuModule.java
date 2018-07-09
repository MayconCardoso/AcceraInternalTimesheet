package br.com.accera.internaltimesheet.ui.menu.di;

import br.com.accera.core.presentation.di.scope.ViewScope;
import br.com.accera.core.presentation.ui.baseview.BaseActivity;
import br.com.accera.internaltimesheet.ui.menu.MenuActivity;
import br.com.accera.internaltimesheet.ui.menu.MenuContract;
import br.com.accera.internaltimesheet.ui.menu.MenuPresenterImpl;
import dagger.Binds;
import dagger.Module;

/**
 * Created by Rafael Spitaliere on 07/08/2018.
 */

@Module
public abstract class MenuModule {

    @ViewScope
    @Binds
    public abstract BaseActivity provideActivity(MenuActivity presenter);

    @ViewScope
    @Binds
    public abstract MenuContract.Presenter providePresenter(MenuPresenterImpl presenter);

}
