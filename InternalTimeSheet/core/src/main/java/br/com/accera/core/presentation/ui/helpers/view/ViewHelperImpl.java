package br.com.accera.core.presentation.ui.helpers.view;

import android.view.View;

import javax.inject.Inject;

import br.com.accera.core.presentation.ui.baseview.BaseActivity;
import br.com.accera.core.presentation.ui.helpers.base.BaseUiHelper;
import br.com.accera.core.presentation.utilities.ViewUtil;

/**
 * The type Resource helper.
 *
 * @author MAYCON CARDOSO on 15/05/2018.
 */
public class ViewHelperImpl extends BaseUiHelper implements ViewHelper {

    //==============================================================================================
    // CONSTRUCTORES
    //==============================================================================================

    /**
     * Instantiates a new View helper.
     *
     * @param activity the activity
     */
    @Inject
    public ViewHelperImpl( BaseActivity activity ) {
        super( activity );
    }

    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // IMPLEMENTATION
    //==============================================================================================
    @Override
    public void visible( View view, boolean visible ) {
        view.setVisibility( visible ? View.VISIBLE : View.GONE );
    }

    @Override
    public boolean isVisible( View view ) {
        return view.getVisibility() == View.VISIBLE;
    }

    @Override
    public void enable( View view, boolean enable ) {
        view.setEnabled( enable );
    }

    @Override
    public void closeKeyboard() {
        ViewUtil.hideKeyboard( mActivity );
    }
    //==============================================================================================
}
