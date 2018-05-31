package br.com.accera.internaltimesheet.di.modules;

import android.content.Context;
import android.net.ConnectivityManager;

import javax.inject.Named;

import br.com.accera.core.presentation.di.scope.ApplicationScope;
import br.com.accera.core.providers.network.NetworkInfoProvider;
import br.com.accera.core.providers.network.NetworkInfoProviderImpl;
import br.com.accera.internaltimesheet.nucleo.TimesheetApplication;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * @author MAYCON CARDOSO on 14/05/2018.
 */
@Module
public abstract class ApplicationModule {

    //==============================================================================================
    // PROVIDERES
    //==============================================================================================
    @Binds
    @ApplicationScope
    @Named("AppContext")
    public abstract Context context( TimesheetApplication application );


    @Provides
    @ApplicationScope
    public static ConnectivityManager providesConnectivityManager( @Named("AppContext") Context application ) {
        return (ConnectivityManager) application.getSystemService( Context.CONNECTIVITY_SERVICE );
    }

    @Binds
    @ApplicationScope
    public abstract NetworkInfoProvider providesNetworkInfoProvider( NetworkInfoProviderImpl networkInfoProvider );
    //==============================================================================================
}
