package br.com.accera.data.user.datasource.local;

import br.com.accera.callback.DataCompleteResponse;
import br.com.accera.data.user.UserDto;

/**
 * Created by LuisAlmeida on 28/05/18.
 */

public interface UserLocalDataSource {
    void saveUser (UserDto user, DataCompleteResponse response);
}
