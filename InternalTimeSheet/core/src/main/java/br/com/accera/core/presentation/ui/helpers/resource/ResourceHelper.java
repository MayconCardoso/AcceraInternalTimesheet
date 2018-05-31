package br.com.accera.core.presentation.ui.helpers.resource;


import br.com.accera.core.domain.behavior.ReleasableMemoryBehavior;

/**
 * The interface Resource helper.
 *
 * @author MAYCON CARDOSO on 15/05/2018.
 */
public interface ResourceHelper extends ReleasableMemoryBehavior {
    /**
     * Gets string.
     *
     * @param resource the resource
     * @return the string
     */
    String getString( int resource );

    /**
     * Gets string by resource name.
     *
     * @param resource the resource
     * @return the string by resource name
     */
    String getStringByResourceName( String resource );

    /**
     * Gets color.
     *
     * @param color the color
     * @return the color
     */
    int getColor( int color );

    /**
     * Gets id by name.
     *
     * @param name the name
     * @return the id by name
     */
    int getIdByName(String name);

    /**
     * Gets color by resource name.
     *
     * @param resourceName the resource name
     * @return the color by resource name
     */
    int getColorByResourceName( String resourceName );
}
