package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Lenda {
    private int id;
    private String emri;
    private Drejtimi drejtimi;
    private Perioda perioda;
    private Mesuesi mesuesi;

    public Lenda(int id, String emri, Drejtimi drejtimi, Perioda perioda, Mesuesi mesuesi) {
        this.id = id;
        this.emri = emri;
        this.drejtimi = drejtimi;
        this.perioda = perioda;
        this.mesuesi = mesuesi;
    }

    public Lenda(String emri, Drejtimi drejtimi, Perioda perioda, Mesuesi mesuesi) {
        this.emri = emri;
        this.drejtimi = drejtimi;
        this.perioda = perioda;
        this.mesuesi = mesuesi;
    }

    public static Lenda fromResultSet(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String emri = result.getString("emri");

        Drejtimi drejtimi = Drejtimi.fromResultSet(result);
        Perioda perioda = Perioda.fromResultSet(result);
        Mesuesi mesuesi = Mesuesi.fromResultSet(result);

        return new Lenda(id, emri, drejtimi, perioda, mesuesi);
    }

    public int getId() {
        return id;
    }

    public String getEmri() {
        return emri;
    }

    public Drejtimi getDrejtimi() {
        return drejtimi;
    }

    public Perioda getPerioda() {
        return perioda;
    }

    public Mesuesi getMesuesi() {
        return mesuesi;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public void setDrejtimi(Drejtimi drejtimi) {
        this.drejtimi = drejtimi;
    }

    public void setPerioda(Perioda perioda) {
        this.perioda = perioda;
    }

    public void setMesuesi(Mesuesi mesuesi) {
        this.mesuesi = mesuesi;
    }

    @Override
    public String toString() {
        return "Lenda {" +
                "ID = " + id +
                ", Emri = '" + emri + '\'' +
                ", Drejtimi = " + drejtimi +
                ", Perioda = " + perioda +
                ", Mesuesi = " + mesuesi +
                '}';
    }

    public int getIdLenda() {
        return id;
    }
}
