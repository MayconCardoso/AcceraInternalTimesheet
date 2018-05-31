package br.com.accera.internaltimesheet;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by fobalan on 23/05/18.
 */

public class User extends BaseObservable {

    public String Nome;
     public String Diainit;
    public String Diaend;
    public String Intervaloinit;
    public String Intervaloend;

    public User() {

    }

    public User(String nome, String diainit, String diaend, String intervaloinit, String intervaloend) {
        Nome = nome;
        Diainit = diainit;
        Diaend = diaend;
        Intervaloinit = intervaloinit;
        Intervaloend = intervaloend;
    }

    @Bindable
    public String getNome() {
        return Nome;
    }

    @Bindable
    public void setNome(String nome) {
        Nome = nome;
        notifyPropertyChanged(BR.nome);
    }


    public String getDiainit() {
        return Diainit;
    }

    @Bindable
    public void setDiainit(String diainit) {
        Diainit = diainit;
        notifyPropertyChanged(BR.diainit);
    }

    public String getDiaend() {
        return Diaend;
    }

    @Bindable
    public void setDiaend(String diaend) {
        Diaend = diaend;
        notifyPropertyChanged(BR.diaend);
    }

    public String getIntervaloinit() {
        return Intervaloinit;
    }

    @Bindable
    public void setIntervaloinit(String intervaloinit) {
        Intervaloinit = intervaloinit;
        notifyPropertyChanged(BR.intervaloinit);
    }

    public String getIntervaloend() {
        return Intervaloend;
    }

    @Bindable
    public void setIntervaloend(String intervaloend) {
        Intervaloend = intervaloend;
        notifyPropertyChanged(BR.intervaloend);
    }
}
