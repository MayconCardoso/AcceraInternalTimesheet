package br.com.accera.internaltimesheet.ui.main;

import br.com.accera.core.presentation.ui.baseview.BaseMvpContract;
import br.com.accera.internaltimesheet.ui.dashboard.DashboardContract;

/**
 * Created by LuisAlmeida on 25/05/18.
 */

public interface MainContract {

    interface View extends BaseMvpContract.View{

    }

    interface Presenter extends BaseMvpContract.Presenter<MainContract.View>{
        void receiveClick(String nome, String diainit, String jornadainit,  String diaend, String jornadaend);

    }
}
