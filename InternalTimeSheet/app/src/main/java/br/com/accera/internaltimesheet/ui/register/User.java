package br.com.accera.internaltimesheet.ui.register;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import br.com.accera.internaltimesheet.BR;

/**
 * Created by fobalan on 23/05/18.
 */

public class User extends BaseObservable {

    public String name;
    public String startJourney;
    public String endJourney;
    public String startInterval;
    public String endInterval;
    public String user;
    public String pass;
    public String pass2;

    public User() {

    }

    public User(String name, String startJourney, String startInterval, String endInterval, String endJourney) {
        this.name = name;
        this.startJourney = startJourney;
        this.endJourney = endJourney;
        this.startInterval = startInterval;
        this.endInterval = endInterval;
    }

//    public User(String name, String startJourney, String endJourney, String startInterval, String endInterval, String user, String pass, String pass2) {
//        this.name = name;
//        this.startJourney = startJourney;
//        this.endJourney = endJourney;
//        this.startInterval = startInterval;
//        this.endInterval = endInterval;
//        this.user = user;
//        this.pass = pass;
//        this.pass2 = pass2;
//    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }


    public String getStartJourney() {
        return startJourney;
    }

    @Bindable
    public void setStartJourney(String startJourney) {
        this.startJourney = startJourney;
        notifyPropertyChanged(BR.startJourney);
    }

    public String getEndJourney() {
        return endJourney;
    }

    @Bindable
    public void setEndJourney(String endJourney) {
        this.endJourney = endJourney;
        notifyPropertyChanged(BR.endJourney);
    }

    public String getStartInterval() {
        return startInterval;
    }

    @Bindable
    public void setStartInterval(String startInterval) {
        this.startInterval = startInterval;
        notifyPropertyChanged(BR.startInterval);
    }

    public String getEndInterval() {
        return endInterval;
    }

    @Bindable
    public void setEndInterval(String endInterval) {
        this.endInterval = endInterval;
        notifyPropertyChanged(BR.endInterval);
    }

    public String getUser() {
        return user;
    }

    @Bindable
    public void setUser(String user) {
        this.user = user;
        notifyPropertyChanged(BR.user);
    }

    public String getPass() {
        return pass;
    }
    @Bindable
    public void setPass(String pass) {
        this.pass = pass;
        notifyPropertyChanged(BR.pass);
    }

    public String getPass2() {
        return pass2;
    }
    @Bindable
    public void setPass2(String pass2) {
        this.pass2 = pass2;
        notifyPropertyChanged(BR.pass2);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", startJourney='" + startJourney + '\'' +
                ", endJourney='" + endJourney + '\'' +
                ", startInterval='" + startInterval + '\'' +
                ", endInterval='" + endInterval + '\'' +
                ", user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                ", pass2='" + pass2 + '\'' +
                '}';
    }
}
