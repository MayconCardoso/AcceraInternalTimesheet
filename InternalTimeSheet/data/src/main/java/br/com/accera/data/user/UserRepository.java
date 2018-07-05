package br.com.accera.data.user;

import br.com.accera.callback.DataCompleteResponse;
import br.com.accera.data.user.entity.UserDto;

/**
 * Created by LuisAlmeida on 28/05/18.
 */

public interface UserRepository {
    void saveUser (UserDto user, DataCompleteResponse response);
    UserDto getUser(Long id);
}
