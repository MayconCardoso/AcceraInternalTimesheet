package br.com.accera.core.presentation.di.module;

import android.content.Context;

import javax.inject.Named;

import br.com.accera.core.presentation.di.scope.ViewScope;
import br.com.accera.core.presentation.flow.FlowNavigatorDelegate;
import br.com.accera.core.presentation.ui.baseview.BaseActivity;
import br.com.accera.core.presentation.ui.helpers.alert.AlertHelper;
import br.com.accera.core.presentation.ui.helpers.alert.NativeAlertHelperImpl;
import br.com.accera.core.presentation.ui.helpers.resource.ResourceHelper;
import br.com.accera.core.presentation.ui.helpers.resource.ResourceHelperImpl;
import br.com.accera.core.presentation.ui.helpers.view.ViewHelper;
import br.com.accera.core.presentation.ui.helpers.view.ViewHelperImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * @author MAYCON CARDOSO on 14/05/2018.
 */
@Module
public abstract class CoreSuggestionViewUtilModule {

    //==============================================================================================
    // PROVIDERS
    //==============================================================================================
    @Binds
    @ViewScope
    @Named("ViewContext")
    public abstract Context provideBaseActivity(BaseActivity baseActivity);

    @Binds
    @ViewScope
    public abstract FlowNavigatorDelegate provideNavigatorDelegate(FlowNavigatorDelegate baseActivity) ;

    @Binds
    @ViewScope
    public abstract ResourceHelper provideResourceHelper( ResourceHelperImpl resourceHelper ) ;

    @Binds
    @ViewScope
    public abstract AlertHelper provideAlertHelper( NativeAlertHelperImpl alertHelper );

    @Binds
    @ViewScope
    public abstract  ViewHelper provideViewHelper( ViewHelperImpl viewHelper );
    //==============================================================================================

}
