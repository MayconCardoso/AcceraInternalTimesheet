package br.com.accera.data.auth.entity;

/**
 * Created by Rafael Spitaliere on 09/07/18.
 */
public class UserLoginDto {

    private String user;
    private String password;

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
}
