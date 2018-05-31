package br.com.accera.internaltimesheet.di.modules;

import br.com.accera.core.presentation.di.module.CoreSuggestionViewUtilModule;
import br.com.accera.core.presentation.di.scope.ViewScope;
import br.com.accera.core.presentation.flow.FlowNavigator;
import br.com.accera.core.presentation.ui.handler.ErrorLoggerHandler;
import br.com.accera.internaltimesheet.ui.flow.TimesheetFlowNavigatorImpl;
import br.com.accera.internaltimesheet.ui.handlers.ErrorHandlerImpl;
import dagger.Binds;
import dagger.Module;

/**
 * Created by fobalan on 24/05/18.
 */
@Module
public abstract class ViewModule extends CoreSuggestionViewUtilModule{

    @Binds
    @ViewScope
    public abstract FlowNavigator providesFlowNavigator (TimesheetFlowNavigatorImpl flowNavigator);


    @Binds
    @ViewScope
    public abstract ErrorLoggerHandler providesErrorLoggerHandler (ErrorHandlerImpl errorHandler);


}
