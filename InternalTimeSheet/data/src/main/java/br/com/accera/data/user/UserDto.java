package br.com.accera.data.user;

/**
 * Created by LuisAlmeida on 28/05/18.
 */

public class UserDto {
    public String Nome;
    public String Diainit;
    public String Diaend;
    public String Intervaloinit;
    public String Intervaloend;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDiainit() {
        return Diainit;
    }

    public void setDiainit(String diainit) {
        Diainit = diainit;
    }

    public String getDiaend() {
        return Diaend;
    }

    public void setDiaend(String diaend) {
        Diaend = diaend;
    }

    public String getIntervaloinit() {
        return Intervaloinit;
    }

    public void setIntervaloinit(String intervaloinit) {
        Intervaloinit = intervaloinit;
    }

    public String getIntervaloend() {
        return Intervaloend;
    }

    public void setIntervaloend(String intervaloend) {
        Intervaloend = intervaloend;
    }
}
