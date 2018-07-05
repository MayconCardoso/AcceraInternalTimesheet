package br.com.accera.internaltimesheet.ui.register.di;

import br.com.accera.core.presentation.di.scope.ViewScope;
import br.com.accera.data.user.UserRepository;
import br.com.accera.data.user.UserRepositoryImpl;
import br.com.accera.data.user.datasource.local.UserLocalDataSource;
import br.com.accera.data.user.datasource.local.UserLocalDataSourceImpl;
import dagger.Binds;
import dagger.Module;

/**
 * Created by LuisAlmeida on 28/05/18.
 */

//Modulo responsável por fornecer as dependencias que nosso presenter nescessita.
@Module
public abstract class UserModule {

    @ViewScope
    @Binds
    public abstract UserLocalDataSource provideUserLocalDataSource(UserLocalDataSourceImpl dataSource);

    @ViewScope
    @Binds
    public abstract UserRepository provideUserRepository(UserRepositoryImpl userLocalDataSource);
}
