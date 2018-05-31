package br.com.accera.core.domain.usecases.rx.base;


import br.com.accera.core.domain.behavior.ReleasableMemoryBehavior;
import br.com.accera.core.domain.usecases.UseCase;

/**
 * The interface Base rx use case.
 *
 * @param <Response> the type parameter
 * @author MAYCON CARDOSO on 19/05/2018.
 */
public interface BaseRxUseCase<Response> extends UseCase<Response>, ReleasableMemoryBehavior {

}
