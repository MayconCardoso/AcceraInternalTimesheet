package br.com.accera.internaltimesheet.ui.login.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import br.com.accera.internaltimesheet.BR;

/**
 * Created by Rafael Spitaliere on 09/07/18.
 */
public class UserLogin extends BaseObservable {

    public String user;
    public String password;
    public String password2;

    public UserLogin() {

    }

    public String getUser() {
        return user;
    }

    @Bindable
    public void setUser(String user) {
        this.user = user;
        notifyPropertyChanged(BR.user);
    }

    public String getPassword() {
        return password;
    }

    @Bindable
    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public String getPassword2() {
        return password2;
    }

    @Bindable
    public void setPassword2(String password2) {
        this.password2 = password2;
        notifyPropertyChanged(BR.password2);
    }
}
