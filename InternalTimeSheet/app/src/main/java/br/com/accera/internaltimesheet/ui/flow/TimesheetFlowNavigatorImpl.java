package br.com.accera.internaltimesheet.ui.flow;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.accera.core.presentation.flow.FlowNavigator;

/**
 * Created by fobalan on 24/05/18.
 */

public class TimesheetFlowNavigatorImpl implements TimesheetFlowNavigator {
    private Context mContext;

    @Inject
    public TimesheetFlowNavigatorImpl(@Named("ViewContext")Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void releaseMemory() {
        mContext = null;
    }
}
