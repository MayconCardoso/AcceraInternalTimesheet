package br.com.accera.core.presentation.ui.baseview;

import android.support.annotation.NonNull;

import br.com.accera.core.domain.usecases.UseCase;
import br.com.accera.core.presentation.ui.helpers.alert.AlertHelper;
import br.com.accera.core.presentation.ui.helpers.resource.ResourceHelper;

/**
 * The interface Base mvp contract.
 *
 * @author MAYCON CARDOSO on 15/05/2018.
 */
public interface BaseMvpContract {

    /**
     * The interface Base view.
     *
     * @author MAYCON CARDOSO on 15/05/2018.
     */
    interface View {
        /**
         * Gets alert helper.
         *
         * @return the alert helper
         */
        AlertHelper getAlertHelper();

        /**
         * Gets resource helper.
         *
         * @return the resource helper
         */
        ResourceHelper getResourceHelper();

        /**
         * Show alert dont has internet.
         */
        void showAlertDontHasInternet();

        /**
         * Sets error on field.
         *
         * @param id    the id
         * @param error the error
         */
        void setErrorOnField(int id, String error);
    }

    /**
     * The interface Base presenter.
     *
     * @param <VIEW> the type parameter
     * @author MAYCON CARDOSO on 15/05/2018.
     */
    interface Presenter<VIEW extends View> {
        /**
         * Add use case case.
         *
         * @param <CASE>  the type parameter
         * @param useCase the use case
         * @return the case
         */
        <CASE extends UseCase> CASE addUseCase( CASE useCase );

        /**
         * Attach view.
         *
         * @param view the view
         */
        void attachView( @NonNull VIEW view );

        /**
         * Detach view.
         */
        void detachView();

        /**
         * Release memory. Called after {@link #detachView()}. So pay attention to don't duplicate
         * code.
         */
        void releaseMemory();
    }
}
