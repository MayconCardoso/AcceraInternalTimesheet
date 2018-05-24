package br.com.accera.core.presentation.utilities;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

/**
 * The type Data bind resolver instance.
 *
 * @author MAYCON CARDOSO
 */
public class DataBindResolverInstance {
    /**
     * Retorna a instancia do databinding
     *
     * @param <T>          the type parameter
     * @param bindingClass the binding class
     * @param mBinding     the m binding
     * @return t t
     */
    public static  <T  extends ViewDataBinding> T  getBinding( @NonNull Class<T> bindingClass, @NonNull ViewDataBinding mBinding){
        if(bindingClass.isInstance( mBinding )){
            return (T) mBinding;
        }

        return null;
    }
}
