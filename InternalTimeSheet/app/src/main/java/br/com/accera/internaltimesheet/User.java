package br.com.accera.internaltimesheet;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by fobalan on 23/05/18.
 */

public class User extends BaseObservable {

    public String name;
    public String startJourney;
    public String endJourney;
    public String startInterval;
    public String endInterval;

    public User() {

    }

    public User(String name, String startJourney, String startInterval, String endInterval, String endJourney) {
        this.name = name;
        this.startJourney = startJourney;
        this.endJourney = endJourney;
        this.startInterval = startInterval;
        this.endInterval = endInterval;
    }

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
}
