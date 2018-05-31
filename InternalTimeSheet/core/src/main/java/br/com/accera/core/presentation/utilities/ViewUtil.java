package br.com.accera.core.presentation.utilities;

import android.content.Context;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * The type View util.
 *
 * @author MAYCON CARDOSO
 */
public class ViewUtil {
    /**
     * Hide keyboard.
     *
     * @param context the context
     */
    public static void hideKeyboard(Context context){
        if( context == null) {
            return;
        }

        IBinder binder = getWindowToken(context);
        if(binder == null){
            return;
        }

        InputMethodManager imm = (InputMethodManager) context.getApplicationContext().getSystemService( Context.INPUT_METHOD_SERVICE );
        if(imm == null){
            return;
        }
        imm.hideSoftInputFromWindow( binder, 0 );
    }

    private static IBinder getWindowToken( @NonNull Context context) {
        if( context instanceof AppCompatActivity ) {
            View view = ((AppCompatActivity) context).getCurrentFocus();
            return view == null ? null : view.getWindowToken();
        }
        return null;
    }
}
