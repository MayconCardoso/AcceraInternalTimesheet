package br.com.accera.data.user;

/**
 * Created by LuisAlmeida on 28/05/18.
 */

public class UserDto {
    public String name;
    public String startJourney;
    public String endJourney;
    public String startInterval;
    public String endInterval;

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
}
