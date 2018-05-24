package br.com.accera.core.domain.usecases;


/**
 * The interface Intput use case.
 *
 * @param <InputObject> the type parameter
 * @param <Response>    the type parameter
 * @author MAYCON CARDOSO on 23/05/2018.
 */
public interface InputUseCase<InputObject, Response> extends UseCase<Response>{
    /**
     * Run response.
     *
     * @param request the request
     * @return the response
     */
    Response run( InputObject request );
}
