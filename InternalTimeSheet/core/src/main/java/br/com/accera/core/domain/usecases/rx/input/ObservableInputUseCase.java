package br.com.accera.core.domain.usecases.rx.input;

import br.com.accera.core.domain.usecases.rx.base.BaseRxInputUseCase;
import io.reactivex.Observable;


/**
 * The interface Observable use case.
 *
 * @param <InputObject> the type parameter
 * @param <Response>    the type parameter
 * @author MAYCON CARDOSO on 15/05/2018.
 */
public interface ObservableInputUseCase<InputObject, Response> extends BaseRxInputUseCase<InputObject, Observable<Response>> {
}
