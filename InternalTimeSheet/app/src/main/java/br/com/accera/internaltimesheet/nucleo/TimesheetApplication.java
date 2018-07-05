package br.com.accera.internaltimesheet.nucleo;

import com.crashlytics.android.Crashlytics;

import br.com.accera.db.DbSessionHelper;
import br.com.accera.internaltimesheet.di.components.ApplicationComponent;
import br.com.accera.internaltimesheet.di.components.DaggerApplicationComponent;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import io.fabric.sdk.android.Fabric;

/**
 * @author MAYCON CARDOSO on 23/05/2018.
 */
public class TimesheetApplication extends DaggerApplication {
    //==============================================================================================
    // OBJETOS
    //==============================================================================================
    ApplicationComponent component = (ApplicationComponent) DaggerApplicationComponent.builder().create(this);
    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // LIFE CICLE
    //==============================================================================================
    @Override
    public void onCreate() {
        super.onCreate();

        Fabric.with(this, new Crashlytics());
        DbSessionHelper.init(this);
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return component;
    }
    //==============================================================================================
}
