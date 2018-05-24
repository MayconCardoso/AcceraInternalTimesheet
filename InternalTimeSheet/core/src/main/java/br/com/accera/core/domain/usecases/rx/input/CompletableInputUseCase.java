package br.com.accera.core.domain.usecases.rx.input;

import br.com.accera.core.domain.usecases.rx.base.BaseRxInputUseCase;
import io.reactivex.Completable;

/**
 * The interface Completable use case.
 *
 * @param <InputObject> the type parameter
 * @author MAYCON CARDOSO on 15/05/2018.
 */
public interface CompletableInputUseCase<InputObject> extends BaseRxInputUseCase<InputObject, Completable> {
}
