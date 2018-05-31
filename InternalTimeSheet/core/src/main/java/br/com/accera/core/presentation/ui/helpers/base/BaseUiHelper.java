package br.com.accera.core.presentation.ui.helpers.base;

import android.content.Context;

import javax.inject.Named;

import br.com.accera.core.domain.behavior.ReleasableMemoryBehavior;
import br.com.accera.core.presentation.ui.baseview.BaseActivity;

/**
 * The type Base ui helper.
 *
 * @author MAYCON CARDOSO on 15/05/2018.
 */
public abstract class BaseUiHelper implements ReleasableMemoryBehavior {
    /**
     * The M activity.
     */
    protected Context mActivity;

    /**
     * Instantiates a new Base ui helper.
     *
     * @param mActivity the m activity
     */
    public BaseUiHelper(Context mActivity ) {
        this.mActivity = mActivity;
    }

    @Override
    public void releaseMemory() {
        mActivity = null;
    }
}
