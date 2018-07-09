package br.com.accera.internaltimesheet.ui.menu;

import br.com.accera.core.presentation.ui.baseview.BaseMvpContract;

/**
 * Created by Rafael Spitaliere on 07/08/2018.
 */

public interface MenuContract {

    interface View extends BaseMvpContract.View{

    }

    interface Presenter extends BaseMvpContract.Presenter<MenuContract.View>{

    }
}
