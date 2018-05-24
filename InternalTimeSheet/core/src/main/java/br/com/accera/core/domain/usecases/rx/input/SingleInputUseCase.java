package br.com.accera.core.domain.usecases.rx.input;

import br.com.accera.core.domain.usecases.rx.base.BaseRxInputUseCase;
import io.reactivex.Single;


/**
 * The interface Single use case.
 *
 * @param <InputObject> the type parameter
 * @param <Response>    the type parameter
 * @author MAYCON CARDOSO on 15/05/2018.
 */
public interface SingleInputUseCase<InputObject, Response> extends BaseRxInputUseCase<InputObject, Single<Response>> {
}
