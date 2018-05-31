package br.com.accera.internaltimesheet.di.components;

import br.com.accera.core.presentation.di.scope.ApplicationScope;
import br.com.accera.internaltimesheet.di.modules.ActivityBuilder;
import br.com.accera.internaltimesheet.di.modules.ApplicationModule;
import br.com.accera.internaltimesheet.nucleo.TimesheetApplication;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@ApplicationScope
@Component(
        modules = {
                ApplicationModule.class,
                AndroidSupportInjectionModule.class,
                ActivityBuilder.class
        } )
public interface ApplicationComponent extends AndroidInjector<TimesheetApplication> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<TimesheetApplication> {
    }
}
