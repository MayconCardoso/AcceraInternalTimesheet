package br.com.accera.data.auth.datasource;

import br.com.accera.data.auth.callback.AuthCompleteResponse;
import br.com.accera.data.auth.entity.UserLoginDto;

/**
 * Created by Rafael Spitaliere on 09/07/18.
 */
public interface AuthRemoteDataSource {

    void registerUser(UserLoginDto userLoginDto, AuthCompleteResponse authCompleteResponse);
}
