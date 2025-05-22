package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Mesimi {
    private Lenda lenda;
    private Mesuesi profesori;
    private Klasa klasa;
    private Drejtimi drejtimi;

    public Mesimi(Lenda lenda, Mesuesi profesori, Klasa klasa, Drejtimi drejtimi) {
        this.lenda = lenda;
        this.profesori = profesori;
        this.klasa = klasa;
        this.drejtimi = drejtimi;
    }

    public static Mesimi fromResultSet(ResultSet result) throws SQLException {
        Lenda lenda = Lenda.fromResultSet(result);
        Mesuesi profesori = Mesuesi.fromResultSet(result);
        Klasa klasa = Klasa.fromResultSet(result);
        Drejtimi drejtimi = Drejtimi.fromResultSet(result);

        return new Mesimi(lenda, profesori, klasa, drejtimi);
    }

    public Lenda getLenda() {
        return lenda;
    }

    public Mesuesi getProfesori() {
        return profesori;
    }

    public Klasa getKlasa() {
        return klasa;
    }

    public Drejtimi getDrejtimi() {
        return drejtimi;
    }

    public void setLenda(Lenda lenda) {
        this.lenda = lenda;
    }

    public void setProfesori(Mesuesi profesori) {
        this.profesori = profesori;
    }

    public void setKlasa(Klasa klasa) {
        this.klasa = klasa;
    }

    public void setDrejtimi(Drejtimi drejtimi) {
        this.drejtimi = drejtimi;
    }

    @Override
    public String toString() {
        return "Mesimi {" +
                "Lenda = " + lenda +
                ", Profesori = " + profesori +
                ", Klasa = " + klasa +
                ", Drejtimi = " + drejtimi +
                '}';
    }
}
