package br.com.accera.data.user.datasource.local;

import javax.inject.Inject;

import br.com.accera.callback.DataCompleteResponse;
import br.com.accera.data.user.dao.UserDtoDao;
import br.com.accera.data.user.entity.UserDto;
import br.com.accera.db.DbSessionHelper;

/**
 * Created by LuisAlmeida on 28/05/18.
 */

public class UserLocalDataSourceImpl implements UserLocalDataSource{

    UserDtoDao mUserDtoDao;

    @Inject
    public UserLocalDataSourceImpl() {
        mUserDtoDao = DbSessionHelper.getDynamicSession().getUserDtoDao();
    }

    @Override
    public void saveUser(UserDto user, DataCompleteResponse response) {
        mUserDtoDao.save(user);
        response.onComplete();
    }

    @Override
    public UserDto getUser(Long id) {
        return mUserDtoDao.loadByRowId(id);
    }
}
