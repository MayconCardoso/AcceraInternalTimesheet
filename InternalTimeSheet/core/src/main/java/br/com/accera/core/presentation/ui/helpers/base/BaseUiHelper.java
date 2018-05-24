package br.com.accera.core.presentation.ui.helpers.base;

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
    protected BaseActivity mActivity;

    /**
     * Instantiates a new Base ui helper.
     *
     * @param mActivity the m activity
     */
    public BaseUiHelper( BaseActivity mActivity ) {
        this.mActivity = mActivity;
    }

    @Override
    public void releaseMemory() {
        mActivity = null;
    }
}
