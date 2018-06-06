package br.com.accera.internaltimesheet.ui.base;

import br.com.accera.core.presentation.ui.baseview.BaseMvpContract;
import br.com.accera.core.presentation.ui.baseview.BasePresenterImpl;
import br.com.accera.internaltimesheet.ui.flow.TimesheetFlowNavigator;

/**
 * Created by LuisAlmeida on 05/06/18.
 */

public class BaseTimesheetPresenter<VIEW extends BaseMvpContract.View> extends BasePresenterImpl<VIEW, TimesheetFlowNavigator> {

}
