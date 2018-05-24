package br.com.accera.core.presentation.ui.helpers.alert;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import javax.inject.Inject;

import br.com.accera.core.R;
import br.com.accera.core.presentation.ui.baseview.BaseActivity;
import br.com.accera.core.presentation.ui.helpers.base.BaseUiHelper;
import br.com.accera.core.presentation.ui.helpers.resource.ResourceHelper;
import br.com.accera.core.presentation.utilities.ViewUtil;


/**
 * The type Alert helper.
 *
 * @author MAYCON CARDOSO on 15/05/2018.
 */
public class NativeAlertHelperImpl extends BaseUiHelper implements AlertHelper {
    //==============================================================================================
    // OBJECTS
    //==============================================================================================
    private ProgressDialog mProgressDialog;
    private ResourceHelper mResourceHelper;
    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // CONSTRUCTORS
    //==============================================================================================

    /**
     * Instantiates a new Alert helper.
     *
     * @param activity       the activity
     * @param resourceHelper the resource helper
     */
    @Inject
    public NativeAlertHelperImpl( BaseActivity activity, ResourceHelper resourceHelper ) {
        super( activity );
        mResourceHelper = resourceHelper;
    }

    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // METHODS
    //==============================================================================================
    @Override
    public void showSimpleMessage( String message ) {
        new Builder( this )
                .setMessage( message )
                .show();
    }

    @Override
    public void showTitleMessage( String title, String message ) {
        new Builder( this )
                .setTitle( title )
                .setMessage( message )
                .show();
    }

    @Override
    public void showErrorMessage( String title, String error ) {
        showTitleMessage( title, error );
    }

    @Override
    public void showErrorMessage( String error ) {
        showSimpleMessage( error );
    }

    @Override
    public void showErrorMessage( Throwable throwable ) {
        showErrorMessage( throwable.getLocalizedMessage() );
    }

    @Override
    public void showLoading( String message ) {
        hideLoading();

        mProgressDialog = new ProgressDialog( mActivity );
        mProgressDialog.setMessage( message );
        mProgressDialog.setIndeterminate( true );
        mProgressDialog.setCanceledOnTouchOutside( false );
        mProgressDialog.show();
    }

    @Override
    public void showLoading( int message ) {
        showLoading( mResourceHelper.getString( message ) );
    }

    @Override
    public void hideLoading() {
        if( !isProgressShowed() ) {
            return;
        }

        mProgressDialog.dismiss();
        mProgressDialog = null;
    }

    @Override
    public void hideKeyboard() {
        ViewUtil.hideKeyboard( mActivity );
    }

    @Override
    public void showBuilder( Builder builder ) {
        // Alert do android
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder( mActivity );
        alertBuilder.setCancelable( builder.mCancelable );
        alertBuilder.setPositiveButton(
                builder.mPositiveButton != null ? builder.mPositiveButton : mResourceHelper.getString( R.string.okUpperCase ),
                createHandlerFromContract( builder.mPositiveHandler )
        );

        // Composite
        if( builder.mTitle != null ) alertBuilder.setTitle( builder.mTitle );
        if( builder.mMessage != null ) alertBuilder.setMessage( builder.mMessage );
        if( builder.mNegativeButton != null )
            alertBuilder.setNegativeButton( builder.mNegativeButton, createHandlerFromContract( builder.mNegativeHandler ) );
        if( builder.mNeutralButton != null )
            alertBuilder.setNeutralButton( builder.mNeutralButton, createHandlerFromContract( builder.mNegativeHandler ) );

        // Mostra
        alertBuilder.show();
    }

    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // PRIVATES
    //==============================================================================================
    private boolean isProgressShowed() {
        return mProgressDialog != null && mProgressDialog.isShowing();
    }

    private DialogInterface.OnClickListener createHandlerFromContract( SimpleClickHandler mClickHandler ) {
        if( mClickHandler == null ) {
            return null;
        }

        // De-para com o listener do android
        return ( dialog, which ) -> mClickHandler.onClick();
    }
}
