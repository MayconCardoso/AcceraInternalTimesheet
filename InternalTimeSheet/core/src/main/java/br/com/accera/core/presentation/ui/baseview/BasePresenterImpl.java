package br.com.accera.core.presentation.ui.baseview;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.accera.core.domain.behavior.ReleasableMemoryBehavior;
import br.com.accera.core.domain.usecases.UseCase;
import br.com.accera.core.presentation.flow.FlowNavigator;
import br.com.accera.core.presentation.ui.handler.ErrorLoggerHandler;
import br.com.accera.core.providers.network.NetworkInfoProvider;
import io.reactivex.disposables.CompositeDisposable;

/**
 * The type Base presenter.
 *
 * @param <VIEW> the type parameter
 * @author MAYCON CARDOSO on 15/05/2018.
 */
public abstract class BasePresenterImpl<VIEW extends BaseMvpContract.View> implements BaseMvpContract.Presenter<VIEW> {
    //==============================================================================================
    // OBJETOS
    //==============================================================================================
    /**
     * The M user cases.
     */
    private List<UseCase> mUserCases = new ArrayList<>();

    /**
     * The M composite disposable.
     */
    protected CompositeDisposable mCompositeDisposable;
    /**
     * The M network info provider.
     */
    protected NetworkInfoProvider mNetworkInfoProvider;

    /**
     * The M flow navigator.
     */
    protected FlowNavigator mFlowNavigator;
    /**
     * The View.
     */
    protected VIEW mView;

    /**
     * The M error handler.
     */
    protected ErrorLoggerHandler mErrorHandler;

    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // CONTRACT
    //==============================================================================================
    @Override
    public <CASE extends UseCase> CASE addUseCase( CASE useCase ) {
        mUserCases.add( useCase );
        return useCase;
    }

    @Override
    public final void attachView( @NonNull VIEW view ) {
        this.mView = view;

        mCompositeDisposable = new CompositeDisposable();

        onViewAttached();
    }

    @Override
    public final void detachView() {
        // Cliente perform something
        onViewDetached();

        // Dispose RxJava
        mCompositeDisposable.dispose();
        mCompositeDisposable.clear();
        mCompositeDisposable = null;

        // Memory leak
        this.mView = null;
    }

    @Override
    @CallSuper
    public void releaseMemory() {
        // Release Flow
        if( mFlowNavigator != null ) {
            mFlowNavigator.releaseMemory();
        }
        mFlowNavigator = null;

        // Release UseCases
        releaseAllUseCases();

        // Release Network
        mNetworkInfoProvider = null;
    }

    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // INJECTORES
    //==============================================================================================

    /**
     * Sets network info provider.
     *
     * @param networkInfoProvider the network info provider
     */
    @Inject
    public void setNetworkInfoProvider( NetworkInfoProvider networkInfoProvider ) {
        mNetworkInfoProvider = networkInfoProvider;
    }

    /**
     * Sets flow navigator.
     *
     * @param flowNavigator the flow navigator
     */
    @Inject
    public void setFlowNavigator( FlowNavigator flowNavigator ) {
        mFlowNavigator = flowNavigator;
    }

    /**
     * Sets error handler.
     *
     * @param errorHandler the error handler
     */
    @Inject
    public void setErrorHandler( ErrorLoggerHandler errorHandler ) {
        mErrorHandler = errorHandler;
    }

    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // METHODS
    //==============================================================================================

    /**
     * On view attached.
     */
    protected void onViewAttached() {

    }

    /**
     * On view detached.
     */
    protected void onViewDetached() {

    }

    private void releaseAllUseCases() {
        // Libera os que são releaseble
        for ( UseCase useCase : mUserCases ) {
            // Não é releaseble
            if( !(useCase instanceof ReleasableMemoryBehavior) ) {
                continue;
            }

            // Libera memoria do useCase
            ((ReleasableMemoryBehavior) useCase).releaseMemory();
        }
        mUserCases.clear();
        mUserCases = null;
    }


    /**
     * Dont have internet signal boolean.
     *
     * @return the boolean
     */
    protected boolean dontHaveInternetSignal() {
        // Sem conexao
        if( !mNetworkInfoProvider.isConnected() ) {
            mView.showAlertDontHasInternet();
            return true;
        }

        return false;
    }
    //==============================================================================================

}
