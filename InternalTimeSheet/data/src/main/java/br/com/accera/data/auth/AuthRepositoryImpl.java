package br.com.accera.data.auth;

import javax.inject.Inject;

import br.com.accera.data.auth.callback.AuthCompleteResponse;
import br.com.accera.data.auth.datasource.AuthRemoteDataSource;
import br.com.accera.data.auth.entity.UserLoginDto;

/**
 * Created by Rafael Spitaliere on 09/07/18.
 */
public class AuthRepositoryImpl implements AuthRepository {

    AuthRemoteDataSource mAuthFirebaseDataSource;

    @Inject
    public AuthRepositoryImpl(AuthRemoteDataSource authRemoteDataSourceDataSource) {
        this.mAuthFirebaseDataSource = authRemoteDataSourceDataSource;
    }

    @Override
    public void registerUser(UserLoginDto userLoginDto, AuthCompleteResponse authCompleteResponse) {
        mAuthFirebaseDataSource.registerUser(userLoginDto, authCompleteResponse);
    }
}
