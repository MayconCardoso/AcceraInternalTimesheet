package br.com.accera.internaltimesheet.ui.login.di;

import br.com.accera.core.presentation.di.scope.ViewScope;
import br.com.accera.core.presentation.ui.baseview.BaseActivity;
import br.com.accera.data.auth.AuthRepository;
import br.com.accera.data.auth.AuthRepositoryImpl;
import br.com.accera.data.auth.datasource.AuthFirebaseDataSourceImpl;
import br.com.accera.data.auth.datasource.AuthRemoteDataSource;
import br.com.accera.internaltimesheet.ui.login.LoginActivity;
import br.com.accera.internaltimesheet.ui.login.LoginContract;
import br.com.accera.internaltimesheet.ui.login.LoginPresenterImpl;
import dagger.Binds;
import dagger.Module;

/**
 * @author Rafael Spitaliere on 15/06/2018.
 */
@Module
public abstract class LoginModule {

    @ViewScope
    @Binds
    public abstract BaseActivity provideActivity(LoginActivity presenter);

    @ViewScope
    @Binds
    public abstract LoginContract.Presenter providePresenter(LoginPresenterImpl presenter);

    @ViewScope
    @Binds
    public abstract AuthRemoteDataSource providesAuthRemoteDataSource(AuthFirebaseDataSourceImpl authFirebaseDataSource);

    @ViewScope
    @Binds
    public abstract AuthRepository providesAuthRepository(AuthRepositoryImpl authRepository);
}
