package br.com.accera.core.domain.exceptions;

/**
 * @author MAYCON CARDOSO on 24/05/2018.
 */
public class IllegalUseCaseParamException extends IllegalArgumentException {

    public IllegalUseCaseParamException() {
        this( "The UseCase request param cannot be null!" );
    }

    public IllegalUseCaseParamException( String error ) {
        super( error );
    }
}
