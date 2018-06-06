package br.com.accera.internaltimesheet.ui.main;

import android.text.TextUtils;

import javax.inject.Inject;

import br.com.accera.callback.DataCompleteResponse;
import br.com.accera.data.user.UserDto;
import br.com.accera.data.user.UserRepository;
import br.com.accera.internaltimesheet.R;
import br.com.accera.internaltimesheet.User;
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


    public void receiveClick(User user){
        mView.cleanAllErrors();

        if (TextUtils.isEmpty(user.name)){
            mView.setErrorOnField(R.id.name, mView.getResourceHelper().getString(R.string.no_name));
            return;
        }
        if (TextUtils.isEmpty(user.startJourney)){
            mView.setErrorOnField(R.id.start_journey, mView.getResourceHelper().getString(R.string.no_journey_init));
            return;
        }
        if (TextUtils.isEmpty(user.startInterval)){
            mView.setErrorOnField(R.id.start_interval, mView.getResourceHelper().getString(R.string.no_interval_init));
            return;
        }
        if (TextUtils.isEmpty(user.endInterval)){
            mView.setErrorOnField(R.id.end_interval, mView.getResourceHelper().getString(R.string.no_interval_end));
            return;
        }
        if (TextUtils.isEmpty(user.endJourney)){
            mView.setErrorOnField(R.id.end_journey, mView.getResourceHelper().getString(R.string.no_journey_end));
            return;
        }

        UserDto userDto = new UserDto();
        userDto.setName(user.name);
        userDto.setStartJourney(user.startJourney);
        userDto.setStartInterval(user.startInterval);
        userDto.setEndInterval(user.endInterval);
        userDto.setEndJourney(user.endJourney);

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
