package br.com.accera.core.domain.usecases;


/**
 * The interface Use case.
 *
 * @param <Response> the type parameter
 * @author MAYCON CARDOSO on 23/05/2018.
 */
public interface UseCase<Response> {
    /**
     * Run t.
     *
     * @return the t
     */
    Response run();
}
