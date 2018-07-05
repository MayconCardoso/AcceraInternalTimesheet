package br.com.accera.data.user.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by LuisAlmeida on 28/05/18.
 */
@Entity
public class UserDto {
    @Id(autoincrement = true)
    public Long id;

    @NotNull
    public String name;
    public String startJourney;
    public String endJourney;
    public String startInterval;
    public String endInterval;
    public String user;
    public String password;
    public String password2;

    @Generated(hash = 2114774804)
    public UserDto(Long id, @NotNull String name, String startJourney,
            String endJourney, String startInterval, String endInterval,
            String user, String password, String password2) {
        this.id = id;
        this.name = name;
        this.startJourney = startJourney;
        this.endJourney = endJourney;
        this.startInterval = startInterval;
        this.endInterval = endInterval;
        this.user = user;
        this.password = password;
        this.password2 = password2;
    }

    @Generated(hash = 1812313716)
    public UserDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartJourney() {
        return startJourney;
    }

    public void setStartJourney(String startJourney) {
        this.startJourney = startJourney;
    }

    public String getEndJourney() {
        return endJourney;
    }

    public void setEndJourney(String endJourney) {
        this.endJourney = endJourney;
    }

    public String getStartInterval() {
        return startInterval;
    }

    public void setStartInterval(String startInterval) {
        this.startInterval = startInterval;
    }

    public String getEndInterval() {
        return endInterval;
    }

    public void setEndInterval(String endInterval) {
        this.endInterval = endInterval;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
