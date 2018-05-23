package br.com.accera.internaltimesheet.nucleo;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

/**
 * @author MAYCON CARDOSO on 23/05/2018.
 */
public class TimesheetApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        Fabric.with(this, new Crashlytics());
    }
}
