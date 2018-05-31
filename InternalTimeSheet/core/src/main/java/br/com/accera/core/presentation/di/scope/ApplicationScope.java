package br.com.accera.core.presentation.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;
import javax.inject.Singleton;

/**
 * @author MAYCON CARDOSO on 24/05/2018.
 */
@Scope
@Singleton
@Retention( RetentionPolicy.RUNTIME)
public @interface ApplicationScope {
}
