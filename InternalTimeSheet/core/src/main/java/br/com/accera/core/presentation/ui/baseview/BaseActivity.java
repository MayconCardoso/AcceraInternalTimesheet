package br.com.accera.core.presentation.ui.baseview;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;

import javax.inject.Inject;

import br.com.accera.core.R;
import br.com.accera.core.presentation.flow.FlowNavigatorDelegate;
import br.com.accera.core.presentation.ui.helpers.alert.AlertHelper;
import br.com.accera.core.presentation.ui.helpers.resource.ResourceHelper;
import br.com.accera.core.presentation.ui.helpers.view.ViewHelper;
import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.SingleEmitter;

/**
 * The type Base activity.
 *
 * @param <VIEW>      the type parameter
 * @param <PRESENTER> the type parameter
 * @author MAYCON CARDOSO on 15/05/2018.
 */
public abstract class BaseActivity<VIEW extends BaseMvpContract.View, PRESENTER extends BaseMvpContract.Presenter<VIEW>> extends DaggerAppCompatActivity implements BaseMvpContract.View, FlowNavigatorDelegate {

    //==============================================================================================
    // OBJECTS
    //==============================================================================================
    /**
     * The M alert helper.
     */
    protected AlertHelper mAlertHelper;
    /**
     * The M resource helper.
     */
    protected ResourceHelper mResourceHelper;

    /**
     * The M view helper.
     */
    protected ViewHelper mViewHelper;
    /**
     * The M core presenter.
     */
    protected PRESENTER mCorePresenter;
    /**
     * The M core data binding.
     */
    protected ViewDataBinding mCoreDataBinding;

    /**
     * The M awaiting activity result.
     */
    protected SparseArray<SingleEmitter<Object>> mAwaitingActivityResult = new SparseArray<>();
    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // VIEWS
    //==============================================================================================
    /**
     * The M toolbar.
     */
    protected Toolbar mToolbar;
    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // LIFE CYCLE
    //==============================================================================================

    @CallSuper
    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        // Bug das imagens.
        AppCompatDelegate.setCompatVectorFromResourcesEnabled( true );

        super.onCreate( savedInstanceState );

        // Pega a view com databinding
        mCoreDataBinding = DataBindingUtil.setContentView( this, getInflateView() );

        // Cria toolbar
        assembleToolbar();

        // Chama para configurar o Databinding
        onDataBindingReady( mCoreDataBinding );
    }

    @CallSuper
    @Override
    protected void onStart() {
        super.onStart();
        mCorePresenter.attachView( getContractView() );
    }

    @CallSuper
    @Override
    protected void onStop() {
        mCorePresenter.detachView();
        super.onStop();
    }

    @CallSuper
    @Override
    protected void onDestroy() {
        mAwaitingActivityResult.clear();
        mAwaitingActivityResult = null;

        mCorePresenter.releaseMemory();
        mCorePresenter = null;

        mAlertHelper.releaseMemory();
        mAlertHelper = null;

        mResourceHelper.releaseMemory();
        mResourceHelper = null;

        mViewHelper.releaseMemory();
        mViewHelper = null;

        super.onDestroy();
    }

    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // ABSTRCTS
    //==============================================================================================

    /**
     * Gets contract view.
     *
     * @return the contract view
     */
    protected abstract VIEW getContractView();

    /**
     * Gets inflate mContractView.
     *
     * @return the inflate mContractView
     */
    protected abstract int getInflateView();


    /**
     * On data binding ready.
     *
     * @param coreDataBinding the core data binding
     */
    protected abstract void onDataBindingReady( ViewDataBinding coreDataBinding );
    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // INJETORES
    //==============================================================================================

    /**
     * Sets alert helper.
     *
     * @param alertHelper the alert helper
     */
    @Inject
    public void setAlertHelper( AlertHelper alertHelper ) {
        mAlertHelper = alertHelper;
    }

    /**
     * Sets resource helper.
     *
     * @param resourceHelper the resource helper
     */
    @Inject
    public void setResourceHelper( ResourceHelper resourceHelper ) {
        mResourceHelper = resourceHelper;
    }

    /**
     * Sets view helper.
     *
     * @param viewHelper the view helper
     */
    @Inject
    public void setViewHelper( ViewHelper viewHelper ) {
        mViewHelper = viewHelper;
    }

    /**
     * Sets core presenter.
     *
     * @param corePresenter the core presenter
     */
    @Inject
    public void setCorePresenter( PRESENTER corePresenter ) {
        mCorePresenter = corePresenter;
    }

    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // BASE CONTRACT
    //==============================================================================================
    @Override
    public AlertHelper getAlertHelper() {
        return mAlertHelper;
    }

    @Override
    public ResourceHelper getResourceHelper() {
        return mResourceHelper;
    }

    @Override
    public void showAlertDontHasInternet() {
        mAlertHelper.showErrorMessage(
                mResourceHelper.getString( R.string.attention ),
                mResourceHelper.getString( R.string.noInternetConnectionWarning )
        );
    }
    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // DEFAULT SETTINGS
    //==============================================================================================

    /**
     * Has toolbar boolean.
     *
     * @return the boolean
     */
    protected boolean hasToolbar() {
        return true;
    }

    /**
     * Is to display toolbar home as up enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isToDisplayToolbarHomeAsUpEnabled() {
        return true;
    }

    /**
     * Gets toolbar title.
     *
     * @return the toolbar title
     */
    protected String getToolbarTitle() {
        return null;
    }

    private void assembleToolbar() {
        // Nao é para mostrar
        if( !hasToolbar() ) {
            return;
        }

        // Pega da view
        mToolbar = mCoreDataBinding.getRoot().findViewById( mResourceHelper.getIdByName( "toolbar" ) );

        // Nao existe
        if( mToolbar == null ) {
            return;
        }

        // Seta no actionBar
        setSupportActionBar( mToolbar );

        // Pega action bar, pois internamente pode dar erro em algumas versoes do android
        ActionBar actionBar = getSupportActionBar();

        // Deu algum erro interno
        if( actionBar == null ) {
            return;
        }

        // Pega titulo
        String title = getToolbarTitle();
        actionBar.setDisplayShowTitleEnabled( title != null );
        actionBar.setTitle( title );
        actionBar.setDisplayHomeAsUpEnabled( isToDisplayToolbarHomeAsUpEnabled() );
    }

    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // NAVIGATORS
    //==============================================================================================
    @Override
    public void startActivity( Class<? extends Activity> activityClass, Bundle bundle, int flags ) {
        Intent intent = new Intent( this, activityClass );
        if( bundle != null ) {
            intent.putExtras( bundle );
        }
        if( flags != 0 ) {
            intent.setFlags( flags );
        }
        startActivity( intent );
        finish();
    }

    @Override
    public void startActivityForResult( Class<? extends Activity> activityClass, Bundle bundle, SingleEmitter<Object> emitter, int flags ) {
        int requestCode = (int) (Math.random() * Byte.MAX_VALUE);
        mAwaitingActivityResult.put( requestCode, emitter );
        Intent intent = new Intent( this, activityClass );
        if( bundle != null ) {
            intent.putExtras( bundle );
        }
        if( flags != 0 ) {
            intent.setFlags( flags );
        }
        startActivityForResult( intent, requestCode );
    }

    @Override
    protected void onActivityResult( int requestCode, int resultCode, Intent data ) {
        super.onActivityResult( requestCode, resultCode, data );
        SingleEmitter<Object> emitter = mAwaitingActivityResult.get( requestCode );
        if( emitter != null ) {
            if( resultCode == RESULT_OK ) {
                emitter.onSuccess( data );
            } else if( resultCode == RESULT_CANCELED ) {
                emitter.onError( new IllegalArgumentException( "Canceled action" ) );
            }
            mAwaitingActivityResult.remove( requestCode );
        }
    }
    //==============================================================================================
}
