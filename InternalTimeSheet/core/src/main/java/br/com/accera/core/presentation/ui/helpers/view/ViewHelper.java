package br.com.accera.core.presentation.ui.helpers.view;

import android.view.View;

import br.com.accera.core.domain.behavior.ReleasableMemoryBehavior;

/**
 * The interface View helper.
 *
 * @author MAYCON CARDOSO on 15/05/2018.
 */
public interface ViewHelper extends ReleasableMemoryBehavior{
    /**
     * Visible.
     *
     * @param view    the view
     * @param visible the visible
     */
    void visible( View view, boolean visible );

    /**
     * Enable.
     *
     * @param view   the view
     * @param enable the enable
     */
    void enable( View view, boolean enable );

    /**
     * Close keyboard.
     */
    void closeKeyboard();

    /**
     * Is visible boolean.
     *
     * @param view the view
     * @return the boolean
     */
    boolean isVisible( View view );
}
