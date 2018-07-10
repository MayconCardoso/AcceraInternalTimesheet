package br.com.accera.internaltimesheet.di.modules;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import br.com.accera.core.presentation.di.scope.ApplicationScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Rafael Spitaliere on 08/07/18.
 */
@Module
public abstract class FirebaseModule {

    @Provides
    @ApplicationScope
    public static FirebaseAuth providesFirebaseAuth(){
        return FirebaseAuth.getInstance();
    }

    @Provides
    @ApplicationScope
    public static FirebaseDatabase providesFirebaseDatabase(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        return firebaseDatabase;
    }
}
