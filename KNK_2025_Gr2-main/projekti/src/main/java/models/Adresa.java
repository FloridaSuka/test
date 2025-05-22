package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Adresa {
    private int id;
    private String qyteti;
    private String rruga;
    private String kodiPostar;

    public Adresa(int id, String qyteti, String rruga, String kodiPostar) {
        this.id = id;
        this.qyteti = qyteti;
        this.rruga = rruga;
        this.kodiPostar = kodiPostar;
    }

    public Adresa(String qyteti, String rruga, String kodiPostar) {
        this.qyteti = qyteti;
        this.rruga = rruga;
        this.kodiPostar = kodiPostar;
    }

    public static Adresa getInstance(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String qyteti = result.getString("qyteti");
        String rruga = result.getString("rruga");
        String kodiPostar = result.getString("kodi_postar");

        return new Adresa(id, qyteti, rruga, kodiPostar);
    }

    public int getId() {
        return id;
    }

    public String getQyteti() {
        return qyteti;
    }

    public String getRruga() {
        return rruga;
    }

    public String getKodiPostar() {
        return kodiPostar;
    }

    public void setQyteti(String qyteti) {
        this.qyteti = qyteti;
    }

    public void setRruga(String rruga) {
        this.rruga = rruga;
    }

    public void setKodiPostar(String kodiPostar) {
        this.kodiPostar = kodiPostar;
    }

    @Override
    public String toString() {
        return "Adresa {" +
                "ID = " + id +
                ", Qyteti = '" + qyteti + '\'' +
                ", Rruga = '" + rruga + '\'' +
                ", Kodi Postar = '" + kodiPostar + '\'' +
                '}';
    }
}
