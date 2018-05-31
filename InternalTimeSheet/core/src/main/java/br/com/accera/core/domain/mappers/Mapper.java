package br.com.accera.core.domain.mappers;

import java.util.ArrayList;
import java.util.List;

/**
 * The interface Mapper.
 *
 * @param <Input>  the type parameter
 * @param <Output> the type parameter
 * @author MAYCON CARDOSO on 23/05/2018.
 */
public interface Mapper<Input, Output> {
    /**
     * Transform output.
     *
     * @param t the t
     * @return the output
     */
    Output transform( Input t );

    /**
     * The type List map.
     */
    final class ListMap {
        /**
         * Of mapper.
         *
         * @param <I>    the type parameter
         * @param <O>    the type parameter
         * @param mapper the mapper
         * @return the mapper
         */
        public static <I, O> Mapper<List<I>, List<O>> of( Mapper<I, O> mapper ) {
            return list -> {
                if( mapper == null || list == null ) return null;
                List<O> output = new ArrayList<>();
                for ( I i : list ) {
                    output.add( mapper.transform( i ) );
                }
                return output;
            };
        }
    }
}