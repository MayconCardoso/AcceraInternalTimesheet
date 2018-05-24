package br.com.accera.core.domain.usecases.rx.noninput;

import br.com.accera.core.domain.usecases.rx.base.BaseRxUseCase;
import io.reactivex.Flowable;


/**
 * The interface Flowable use case.
 *
 * @param <Response> the type parameter
 * @author MAYCON CARDOSO on 15/05/2018.
 */
public interface FlowableUseCase<Response> extends BaseRxUseCase<Flowable<Response>> {
}
