package br.com.accera.core.presentation.ui.handler;

/**
 * The type Error handler.
 *
 * @author MAYCON CARDOSO on 19/05/2018.
 */
public interface ErrorLoggerHandler {

    /**
     * Gets tag.
     *
     * @return the tag
     */
    String getTag();

    /**
     * Print local and integrate error.
     *
     * @param error the error
     */
    void printLocalAndIntegrateError(Throwable error);

    /**
     * Print error.
     *
     * @param error the error
     */
    void printError(Throwable error);
}
