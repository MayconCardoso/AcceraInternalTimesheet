package br.com.accera.internaltimesheet;

/**
 * Created by fobalan on 23/05/18.
 */

public class User {

    public String Nome;
    public String Diainit;
    public String Diaend;
    public String Intervaloinit;
    public String Intervaloend;

    public User(String nome, String diainit, String diaend, String intervaloinit,String intervaloend) {
        Nome = nome;
        Diainit = diainit;
        Diaend = diaend;
        Intervaloinit = intervaloinit;
        Intervaloend = intervaloend;
    }
}
