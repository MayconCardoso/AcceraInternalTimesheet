package br.com.accera.internaltimesheet.ui.register.mapper;

import br.com.accera.core.domain.mappers.Mapper;
import br.com.accera.data.user.entity.UserDto;
import br.com.accera.internaltimesheet.ui.register.User;

/**
 * Created by Rafael Spitaliere on 05/07/18.
 */
public class UserMapper {

    public static class ToUserDto implements Mapper<User, UserDto> {
        @Override
        public UserDto transform(User t) {
            UserDto userDto = new UserDto();
            userDto.setEndInterval(t.getEndInterval());
            userDto.setEndJourney(t.getEndJourney());
            userDto.setName(t.getName());
            userDto.setStartInterval(t.getStartInterval());
            userDto.setStartJourney(t.getStartJourney());
            userDto.setUser(t.getUser());
            userDto.setPassword(t.getPass());
            userDto.setPassword2(t.getPass2());

            return userDto;
        }
    }

    public static class FromUserDto implements Mapper<UserDto, User>{
        @Override
        public User transform(UserDto t) {
            User user = new User();
            user.setEndInterval(t.getEndInterval());
            user.setEndJourney(t.getEndJourney());
            user.setName(t.getName());
            user.setStartInterval(t.getStartInterval());
            user.setStartJourney(t.getStartJourney());
            user.setUser(t.getUser());
            user.setPass(t.getPassword());
            user.setPass2(t.getPassword2());
            return user;
        }
    }
}
