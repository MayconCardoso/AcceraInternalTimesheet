package br.com.accera.core.presentation.flow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import br.com.accera.core.domain.behavior.ReleasableMemoryBehavior;
import io.reactivex.Single;


/**
 * The interface Flow navigator.
 *
 * @author MAYCON CARDOSO on 15/05/2018.
 */
public interface FlowNavigator extends ReleasableMemoryBehavior{

    /**
     * The type Navigation.
     */
    class Navigation {
        private FlowNavigatorDelegate delegate;
        private Class<? extends Activity> aClass;
        private int flags = 0;
        private Bundle bundle;

        /**
         * Instantiates a new Navigation.
         *
         * @param delegate the delegate
         * @param aClass   the a class
         * @param bundle   the bundle
         */
        public Navigation( FlowNavigatorDelegate delegate, Class<? extends Activity> aClass, Bundle bundle) {
            this.delegate = delegate;
            this.aClass = aClass;
            this.bundle = bundle;
        }

        /**
         * Instantiates a new Navigation.
         *
         * @param delegate the delegate
         * @param bundle   the bundle
         */
        public Navigation( FlowNavigatorDelegate delegate, Bundle bundle) {
            this.delegate = delegate;
            this.bundle = bundle;
        }

        /**
         * As new start navigation.
         *
         * @return the navigation
         */
        public Navigation asNewStart() {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK;
            return this;
        }

        /**
         * Go.
         */
        public void go() {
            delegate.startActivity(aClass, bundle, flags);
        }

        /**
         * Request single.
         *
         * @param <T>   the type parameter
         * @param clazz the clazz
         * @return the single
         */
        public <T> Single<T> request( Class<T> clazz) {
            return Single.create(emitter -> {
                delegate.startActivityForResult(aClass, bundle, emitter, flags);
            }).cast(clazz);
        }
    }
}
