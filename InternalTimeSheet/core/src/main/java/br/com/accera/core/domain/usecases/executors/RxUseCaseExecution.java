package br.com.accera.core.domain.usecases.executors;

import br.com.accera.core.domain.exceptions.IllegalUseCaseParamException;
import br.com.accera.core.domain.usecases.rx.input.CompletableInputUseCase;
import br.com.accera.core.domain.usecases.rx.input.FlowableInputUseCase;
import br.com.accera.core.domain.usecases.rx.input.MaybeInputUseCase;
import br.com.accera.core.domain.usecases.rx.input.ObservableInputUseCase;
import br.com.accera.core.domain.usecases.rx.input.SingleInputUseCase;
import br.com.accera.core.domain.usecases.rx.noninput.CompletableUseCase;
import br.com.accera.core.domain.usecases.rx.noninput.FlowableUseCase;
import br.com.accera.core.domain.usecases.rx.noninput.MaybeUseCase;
import br.com.accera.core.domain.usecases.rx.noninput.ObservableUseCase;
import br.com.accera.core.domain.usecases.rx.noninput.SingleUseCase;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * The type Use case execution.
 *
 * @author MAYCON CARDOSO on 15/05/2018.
 */
public class RxUseCaseExecution {
    /**
     * The type With request param.
     */
    public static class WithRequestParam {

        /**
         * Execute single.
         *
         * @param <Input>    the type parameter
         * @param <Response> the type parameter
         * @param useCase    the use case
         * @param request    the request
         * @return the single
         */
        public static <Input, Response> Single<Response> execute( SingleInputUseCase<Input, Response> useCase, Input request ) {
            return useCase.run( request ).subscribeOn( Schedulers.io() ).observeOn( AndroidSchedulers.mainThread() );
        }

        /**
         * Execute single.
         *
         * @param <Input>    the type parameter
         * @param <Response> the type parameter
         * @param useCase    the use case
         * @param request    the request
         * @param disposable the disposable
         * @return the single
         */
        public static <Input, Response> Single<Response> execute( SingleInputUseCase<Input, Response> useCase, Input request, CompositeDisposable disposable ) {
            return execute( useCase, request ).doOnSubscribe( disposable::add );
        }

        /**
         * Execute observable.
         *
         * @param <Input>    the type parameter
         * @param <Response> the type parameter
         * @param useCase    the use case
         * @param request    the request
         * @return the observable
         */
        public static <Input, Response> Observable<Response> execute( ObservableInputUseCase<Input, Response> useCase, Input request ) {
            return useCase.run( request ).subscribeOn( Schedulers.io() ).observeOn( AndroidSchedulers.mainThread() );
        }

        /**
         * Execute observable.
         *
         * @param <Input>    the type parameter
         * @param <Response> the type parameter
         * @param useCase    the use case
         * @param request    the request
         * @param disposable the disposable
         * @return the observable
         */
        public static <Input, Response> Observable<Response> execute( ObservableInputUseCase<Input, Response> useCase, Input request, CompositeDisposable disposable ) {
            return execute( useCase, request ).doOnSubscribe( disposable::add );
        }

        /**
         * Execute maybe.
         *
         * @param <Input>    the type parameter
         * @param <Response> the type parameter
         * @param useCase    the use case
         * @param request    the request
         * @return the maybe
         */
        public static <Input, Response> Maybe<Response> execute( MaybeInputUseCase<Input, Response> useCase, Input request ) {
            return useCase.run( request ).subscribeOn( Schedulers.io() ).observeOn( AndroidSchedulers.mainThread() );
        }

        /**
         * Execute maybe.
         *
         * @param <Input>    the type parameter
         * @param <Response> the type parameter
         * @param useCase    the use case
         * @param request    the request
         * @param disposable the disposable
         * @return the maybe
         */
        public static <Input, Response> Maybe<Response> execute( MaybeInputUseCase<Input, Response> useCase, Input request, CompositeDisposable disposable ) {
            return execute( useCase, request ).doOnSubscribe( disposable::add );
        }

        /**
         * Execute completable.
         *
         * @param <Input> the type parameter
         * @param useCase the use case
         * @param request the request
         * @return the completable
         */
        public static <Input> Completable execute( CompletableInputUseCase<Input> useCase, Input request ) {
            return useCase.run( request ).subscribeOn( Schedulers.io() ).observeOn( AndroidSchedulers.mainThread() );
        }

        /**
         * Execute completable.
         *
         * @param <Input>    the type parameter
         * @param useCase    the use case
         * @param request    the request
         * @param disposable the disposable
         * @return the completable
         */
        public static <Input> Completable execute( CompletableInputUseCase<Input> useCase, Input request, CompositeDisposable disposable ) {
            return execute( useCase, request ).doOnSubscribe( disposable::add );
        }

        /**
         * Execute flowable.
         *
         * @param <Input>    the type parameter
         * @param <Response> the type parameter
         * @param useCase    the use case
         * @param request    the request
         * @return the flowable
         */
        public static <Input, Response> Flowable<Response> execute( FlowableInputUseCase<Input, Response> useCase, Input request ) {
            return useCase.run( request ).subscribeOn( Schedulers.io() ).observeOn( AndroidSchedulers.mainThread() );
        }


        /**
         * Execute completable.
         *
         * @param useCase the use case
         * @return the completable
         */
        public static Completable execute( CompletableUseCase useCase ) {
            return useCase.run().subscribeOn( Schedulers.io() ).observeOn( AndroidSchedulers.mainThread() );
        }

        /**
         * Execute completable.
         *
         * @param useCase    the use case
         * @param disposable the disposable
         * @return the completable
         */
        public static Completable execute( CompletableUseCase useCase, CompositeDisposable disposable ) {
            return execute( useCase ).doOnSubscribe( disposable::add );
        }
    }


    /**
     * The type Non request param.
     */
    public static class NonRequestParam {
        /**
         * Execute single.
         *
         * @param <Response> the type parameter
         * @param useCase    the use case
         * @return the single
         */
        public static <Response> Single<Response> execute( SingleUseCase<Response> useCase ) {
            return useCase.run().subscribeOn( Schedulers.io() ).observeOn( AndroidSchedulers.mainThread() );
        }

        /**
         * Execute single.
         *
         * @param <Response> the type parameter
         * @param useCase    the use case
         * @param disposable the disposable
         * @return the single
         */
        public static <Response> Single<Response> execute( SingleUseCase<Response> useCase, CompositeDisposable disposable ) {
            return execute( useCase ).doOnSubscribe( disposable::add );
        }

        /**
         * Execute observable.
         *
         * @param <Response> the type parameter
         * @param useCase    the use case
         * @return the observable
         */
        public static <Response> Observable<Response> execute( ObservableUseCase<Response> useCase ) {
            return useCase.run().subscribeOn( Schedulers.io() ).observeOn( AndroidSchedulers.mainThread() );
        }

        /**
         * Execute observable.
         *
         * @param <Response> the type parameter
         * @param useCase    the use case
         * @param disposable the disposable
         * @return the observable
         */
        public static <Response> Observable<Response> execute( ObservableUseCase<Response> useCase, CompositeDisposable disposable ) {
            return execute( useCase ).doOnSubscribe( disposable::add );
        }

        /**
         * Execute flowable.
         *
         * @param <Response> the type parameter
         * @param useCase    the use case
         * @return the flowable
         */
        public static <Response> Flowable<Response> execute( FlowableUseCase<Response> useCase ) {
            return useCase.run().subscribeOn( Schedulers.io() ).observeOn( AndroidSchedulers.mainThread() );
        }

        /**
         * Execute maybe.
         *
         * @param <Response> the type parameter
         * @param useCase    the use case
         * @return the maybe
         */
        public static <Response> Maybe<Response> execute( MaybeUseCase<Response> useCase ) {
            return useCase.run().subscribeOn( Schedulers.io() ).observeOn( AndroidSchedulers.mainThread() );
        }

        /**
         * Execute maybe.
         *
         * @param <Response> the type parameter
         * @param useCase    the use case
         * @param disposable the disposable
         * @return the maybe
         */
        public static <Response> Maybe<Response> execute( MaybeUseCase<Response> useCase, CompositeDisposable disposable ) {
            return execute( useCase ).doOnSubscribe( disposable::add );
        }

        /**
         * Execute completable.
         *
         * @param useCase the use case
         * @return the completable
         */
        public static Completable execute( CompletableUseCase useCase ) {
            return useCase.run().subscribeOn( Schedulers.io() ).observeOn( AndroidSchedulers.mainThread() );
        }

        /**
         * Execute completable.
         *
         * @param useCase    the use case
         * @param disposable the disposable
         * @return the completable
         */
        public static Completable execute( CompletableUseCase useCase, CompositeDisposable disposable ) {
            return execute( useCase ).doOnSubscribe( disposable::add );
        }
    }

    /**
     * The type Checker.
     */
    public static class Checker {
        /**
         * Check request.
         *
         * @param request the request
         */
        public static void checkRequest( Object request ) {
            if( request == null ) {
                throw new IllegalUseCaseParamException();
            }
        }
    }
}
