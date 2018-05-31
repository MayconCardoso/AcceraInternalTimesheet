package br.com.accera.internaltimesheet.ui.main;

import android.text.TextUtils;
import android.util.Log;

import javax.inject.Inject;

import br.com.accera.core.presentation.ui.baseview.BasePresenterImpl;
import br.com.accera.internaltimesheet.R;

/**
 * Created by LuisAlmeida on 25/05/18.
 */

public class MainPresenterImpl extends BasePresenterImpl<MainContract.View> implements MainContract.Presenter{

    @Inject
    public MainPresenterImpl() {
    }

    public void receiveClick(String nome, String diainit, String jornadainit,  String diaend, String jornadaend){
        if (TextUtils.isEmpty(nome)){
            mView.getAlertHelper().showErrorMessage(R.string.no_name);
        }
    }
}
