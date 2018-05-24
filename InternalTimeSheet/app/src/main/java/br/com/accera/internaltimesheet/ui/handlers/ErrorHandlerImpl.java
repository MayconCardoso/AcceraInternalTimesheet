package br.com.accera.internaltimesheet.ui.handlers;

import javax.inject.Inject;

import br.com.accera.core.presentation.ui.handler.ErrorLoggerHandler;

/**
 * Created by fobalan on 24/05/18.
 */

public class ErrorHandlerImpl implements ErrorLoggerHandler {

    @Inject
    public ErrorHandlerImpl() {

    }

    @Override
    public String getTag() {
        return "Timesheet";
    }

    @Override
    public void printLocalAndIntegrateError(Throwable error) {

    }

    @Override
    public void printError(Throwable error) {

    }
}
