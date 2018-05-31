package br.com.accera.core.domain.usecases.rx.base;

import br.com.accera.core.domain.behavior.ReleasableMemoryBehavior;
import br.com.accera.core.domain.usecases.InputUseCase;

/**
 * The interface Base rx input use case.
 *
 * @param <Input>    the type parameter
 * @param <Response> the type parameter
 * @author MAYCON CARDOSO on 19/05/2018.
 */
public interface BaseRxInputUseCase<Input, Response> extends InputUseCase<Input, Response>, ReleasableMemoryBehavior {

}
