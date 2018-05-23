package br.com.accera.internaltimesheet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.joaquimley.faboptions.FabOptions;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        Fabric.with(this, new Crashlytics());
        setContentView( R.layout.activity_dashboard );
    }
}
