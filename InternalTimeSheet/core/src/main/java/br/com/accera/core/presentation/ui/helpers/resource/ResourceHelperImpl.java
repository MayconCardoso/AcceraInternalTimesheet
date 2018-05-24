package br.com.accera.core.presentation.ui.helpers.resource;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.accera.core.presentation.ui.baseview.BaseActivity;
import br.com.accera.core.presentation.ui.helpers.base.BaseUiHelper;

/**
 * The type Resource helper.
 *
 * @author MAYCON CARDOSO on 15/05/2018.
 */
public class ResourceHelperImpl extends BaseUiHelper implements ResourceHelper {
    //==============================================================================================
    // CONSTANTES
    //==============================================================================================
    /**
     * The constant RESOURCE_COLOR.
     */
    public static final String RESOURCE_COLOR = "color";
    /**
     * The constant RESOURCE_STRING.
     */
    public static final String RESOURCE_STRING = "string";
    /**
     * The constant RESOURCE_ID.
     */
    public static final String RESOURCE_ID = "id";
    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // CONSTRUCTORES
    //==============================================================================================

    /**
     * Instantiates a new Resource helper.
     *
     * @param activity the activity
     */
    @Inject
    public ResourceHelperImpl( @Named("ViewContext") Context activity ) {
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
    public String getString( int resource ) {
        return mActivity.getString( resource );
    }

    @Override
    public int getColor( int color ) {
        return ContextCompat.getColor( mActivity, color );
    }

    @Override
    public int getIdByName( String resourceName ) {
        return getInternalIdFromResourceName( resourceName, RESOURCE_ID);
    }

    @Override
    public String getStringByResourceName( String resourceName ) {
        return getString( getInternalIdFromResourceName(
                resourceName, RESOURCE_STRING
        ) );
    }

    @Override
    public int getColorByResourceName( String resourceName ) {
        return getColor( getInternalIdFromResourceName(
                resourceName, RESOURCE_COLOR
        ) );
    }

    private int getInternalIdFromResourceName( String resourceName, String resourceSegment ) {
        int resId = mActivity.getResources().getIdentifier( resourceName, resourceSegment, mActivity.getPackageName() );
        if( resId <= 0 ) {
            throw new IllegalArgumentException( "Name not such" );
        }
        return resId;
    }
}
