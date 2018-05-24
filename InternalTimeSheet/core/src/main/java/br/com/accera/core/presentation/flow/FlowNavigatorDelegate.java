package br.com.accera.core.presentation.flow;

import android.app.Activity;
import android.os.Bundle;

import io.reactivex.SingleEmitter;


/**
 * The interface Navigator delegate.
 */
public interface FlowNavigatorDelegate {
    /**
     * Start activity.
     *
     * @param activityClass the activity class
     * @param bundle        the bundle
     * @param flags         the flags
     */
    void startActivity( Class<? extends Activity> activityClass, Bundle bundle, int flags );

    /**
     * Start activity for result.
     *
     * @param activityClass the activity class
     * @param bundle        the bundle
     * @param emitter       the emitter
     * @param flags         the flags
     */
    void startActivityForResult( Class<? extends Activity> activityClass, Bundle bundle, SingleEmitter<Object> emitter, int flags );
}
