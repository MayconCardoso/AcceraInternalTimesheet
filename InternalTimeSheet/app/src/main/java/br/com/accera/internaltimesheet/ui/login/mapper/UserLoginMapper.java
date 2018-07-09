package br.com.accera.internaltimesheet.ui.login.mapper;

import br.com.accera.core.domain.mappers.Mapper;
import br.com.accera.data.auth.entity.UserLoginDto;
import br.com.accera.data.user.entity.UserDto;
import br.com.accera.internaltimesheet.ui.login.model.UserLogin;
import br.com.accera.internaltimesheet.ui.register.User;

/**
 * Created by Rafael Spitaliere on 05/07/18.
 */
public class UserLoginMapper {

    public static class ToUserLoginDto implements Mapper<UserLogin, UserLoginDto> {

        @Override
        public UserLoginDto transform(UserLogin t) {
            UserLoginDto userLoginDto = new UserLoginDto();
            userLoginDto.setUser(t.getUser());
            userLoginDto.setPassword(t.getPassword());

            return userLoginDto;
        }
    }

    public static class FromUserLoginDto implements Mapper<UserLoginDto, UserLogin>{

        @Override
        public UserLogin transform(UserLoginDto t) {
            UserLogin userLogin = new UserLogin();
            userLogin.setUser(t.getUser());
            userLogin.setPassword(t.getPassword());
            return userLogin;
        }
    }
}
