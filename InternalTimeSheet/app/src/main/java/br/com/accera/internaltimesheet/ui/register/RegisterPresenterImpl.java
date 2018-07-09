package br.com.accera.internaltimesheet.ui.register;

import android.text.TextUtils;

import javax.inject.Inject;

import br.com.accera.data.user.UserRepository;
import br.com.accera.data.user.entity.UserDto;
import br.com.accera.internaltimesheet.R;
import br.com.accera.internaltimesheet.ui.base.BaseTimesheetPresenter;
import br.com.accera.internaltimesheet.ui.register.mapper.UserMapper;

/**
 * Created by LuisAlmeida on 25/05/18.
 */

public class RegisterPresenterImpl extends BaseTimesheetPresenter<RegisterContract.View> implements RegisterContract.Presenter{

    private UserRepository userRepository;

    @Inject
    public RegisterPresenterImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void firstStep(User user){
        mView.cleanAllErrors();
        getUser();

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
        mView.showSecondCard();
    }

    @Override
    public void secondStep(User user) {
        mView.cleanAllErrors();

        if (TextUtils.isEmpty(user.user)){
            mView.setErrorOnField(R.id.email, "Insira um e-mail válido!");
            return;
        }
        if (TextUtils.isEmpty(user.pass) && TextUtils.isEmpty(user.pass2)){
            mView.setErrorOnField(R.id.password, "Senha inválida");
            mView.setErrorOnField(R.id.password_two, "Senha inválida");
            return;
        }

        UserDto userDto = new UserMapper.ToUserDto().transform(user);

        mView.getAlertHelper().showLoading("Salvando usuario");
        userRepository.saveUser(userDto, () -> {
            mView.getAlertHelper().hideLoading();
            mFlowNavigator.goToLogin();
        });
    }

    @Override
    public User getUser() {
        UserDto user = userRepository.getUser(1L);
        if (user != null){
            return new UserMapper.FromUserDto().transform(user);
        }
        return new User();
    }

}
