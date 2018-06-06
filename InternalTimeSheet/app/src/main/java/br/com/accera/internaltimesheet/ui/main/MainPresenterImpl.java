package br.com.accera.internaltimesheet.ui.main;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import javax.inject.Inject;

import br.com.accera.callback.DataCompleteResponse;
import br.com.accera.core.presentation.ui.baseview.BasePresenterImpl;
import br.com.accera.data.user.UserDto;
import br.com.accera.data.user.UserRepository;
import br.com.accera.internaltimesheet.R;
import br.com.accera.internaltimesheet.ui.base.BaseTimesheetPresenter;

/**
 * Created by LuisAlmeida on 25/05/18.
 */

public class MainPresenterImpl extends BaseTimesheetPresenter<MainContract.View> implements MainContract.Presenter{

    private UserRepository userRepository;

    @Inject
    public MainPresenterImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void receiveClick(String nome, String diainit, String jornadainit,  String diaend, String jornadaend){
        if (TextUtils.isEmpty(nome)){
            mView.getAlertHelper().showErrorMessage(R.string.no_name);
        }
        if (TextUtils.isEmpty(diainit)){
            mView.getAlertHelper().showErrorMessage(R.string.no_day_init);
        }
        if (TextUtils.isEmpty(diaend)){
            mView.getAlertHelper().showErrorMessage(R.string.no_dayend);
        }
        if (TextUtils.isEmpty(jornadainit)){
            mView.getAlertHelper().showErrorMessage(R.string.no_jornadainit);
        }
        if (TextUtils.isEmpty(jornadaend)){
            mView.getAlertHelper().showErrorMessage(R.string.no_jornadaend);
        }

        UserDto userDto = new UserDto();
        userDto.setNome(nome);
        userDto.setDiaend(diaend);
        userDto.setDiainit(diainit);
        userDto.setIntervaloend(jornadaend);
        userDto.setIntervaloinit(jornadainit);

        mView.getAlertHelper().showLoading("Salvando usuario");
        userRepository.saveUser(userDto, new DataCompleteResponse() {
            @Override
            public void onComplete() {
                mView.getAlertHelper().hideLoading();
                mFlowNavigator.goToDashboard();
            }
        });
    }
}
