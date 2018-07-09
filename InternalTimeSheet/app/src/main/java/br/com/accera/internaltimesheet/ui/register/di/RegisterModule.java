package br.com.accera.internaltimesheet.ui.register.di;

import br.com.accera.core.presentation.di.scope.ViewScope;
import br.com.accera.core.presentation.ui.baseview.BaseActivity;
import br.com.accera.internaltimesheet.ui.register.RegisterActivity;
import br.com.accera.internaltimesheet.ui.register.RegisterContract;
import br.com.accera.internaltimesheet.ui.register.RegisterPresenterImpl;
import dagger.Binds;
import dagger.Module;

/**
 * @author MAYCON CARDOSO on 24/05/2018.
 */
@Module
public abstract class RegisterModule {

    @ViewScope
    @Binds
    public abstract BaseActivity provideActivity(RegisterActivity presenter);

    @ViewScope
    @Binds
    public abstract RegisterContract.Presenter providePresenter(RegisterPresenterImpl presenter);
}
