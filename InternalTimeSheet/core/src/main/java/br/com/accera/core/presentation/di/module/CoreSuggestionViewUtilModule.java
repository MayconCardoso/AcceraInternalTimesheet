package br.com.accera.core.presentation.di.module;

import br.com.accera.core.presentation.di.scope.ViewScope;
import br.com.accera.core.presentation.flow.FlowNavigatorDelegate;
import br.com.accera.core.presentation.ui.baseview.BaseActivity;
import br.com.accera.core.presentation.ui.helpers.alert.AlertHelper;
import br.com.accera.core.presentation.ui.helpers.alert.NativeAlertHelperImpl;
import br.com.accera.core.presentation.ui.helpers.resource.ResourceHelper;
import br.com.accera.core.presentation.ui.helpers.resource.ResourceHelperImpl;
import br.com.accera.core.presentation.ui.helpers.view.ViewHelper;
import br.com.accera.core.presentation.ui.helpers.view.ViewHelperImpl;
import dagger.Module;
import dagger.Provides;

/**
 * @author MAYCON CARDOSO on 14/05/2018.
 */
@Module
public class CoreSuggestionViewUtilModule {
    //==============================================================================================
    // OBJETOS
    //==============================================================================================
    private BaseActivity mBaseActivity;

    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // CONSTRUTORES
    //==============================================================================================
    public CoreSuggestionViewUtilModule( BaseActivity baseActivity ) {
        mBaseActivity = baseActivity;
    }

    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // PROVIDERS
    //==============================================================================================
    @Provides
    @ViewScope
    public BaseActivity provideBaseActivity() {
        return mBaseActivity;
    }

    @Provides
    @ViewScope
    public FlowNavigatorDelegate provideNavigatorDelegate() {
        return mBaseActivity;
    }

    @Provides
    @ViewScope
    public ResourceHelper provideResourceHelper( ResourceHelperImpl resourceHelper ) {
        return resourceHelper;
    }

    @Provides
    @ViewScope
    public AlertHelper provideAlertHelper( NativeAlertHelperImpl alertHelper ) {
        return alertHelper;
    }

    @Provides
    @ViewScope
    public ViewHelper provideViewHelper( ViewHelperImpl viewHelper ) {
        return viewHelper;
    }
    //==============================================================================================

}
