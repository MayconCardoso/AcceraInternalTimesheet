package br.com.accera.data.user;

import javax.inject.Inject;

import br.com.accera.callback.DataCompleteResponse;
import br.com.accera.data.user.datasource.local.UserLocalDataSource;

/**
 * Created by LuisAlmeida on 28/05/18.
 */

public class UserRepositoryImpl implements UserRepository {

    private UserLocalDataSource mUserLocalDataSource;

    @Inject
    public UserRepositoryImpl(UserLocalDataSource mUserLocalDataSource) {
        this.mUserLocalDataSource = mUserLocalDataSource;
    }

    @Override
    public void saveUser(UserDto user, DataCompleteResponse response) {
        mUserLocalDataSource.saveUser(user,response);
    }
}
