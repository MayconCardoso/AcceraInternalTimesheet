package br.com.accera.data.auth;

import br.com.accera.data.auth.callback.AuthCompleteResponse;
import br.com.accera.data.auth.entity.UserLoginDto;
import br.com.accera.data.user.entity.UserDto;

/**
 * Created by Rafael Spitaliere on 09/07/18.
 */
public interface AuthRepository {

    void registerUser(UserLoginDto userLoginDto, AuthCompleteResponse authCompleteResponse);
}
