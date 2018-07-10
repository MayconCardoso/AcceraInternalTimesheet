package br.com.accera.data.user.dao;

import org.greenrobot.greendao.test.AbstractDaoTestLongPk;

import br.com.accera.data.user.entity.UserDto;
import br.com.accera.data.user.dao.UserDtoDao;

public class UserDtoTest extends AbstractDaoTestLongPk<UserDtoDao, UserDto> {

    public UserDtoTest() {
        super(UserDtoDao.class);
    }

    @Override
    protected UserDto createEntity(Long key) {
        UserDto entity = new UserDto();
        entity.setId(key);
        entity.setName();
        return entity;
    }

}
