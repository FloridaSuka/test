package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Klasa {
    private int id;
    private int niveli;
    private Shkolla shkolla;
    private Paralelja paralelja;
    private Mesuesi mesuesi;
    private Drejtimi drejtimi;

    public Klasa(int id, int niveli, Shkolla shkolla, Paralelja paralelja, Mesuesi mesuesi, Drejtimi drejtimi) {
        this.id = id;
        this.niveli = niveli;
        this.shkolla = shkolla;
        this.paralelja = paralelja;
        this.mesuesi = mesuesi;
        this.drejtimi = drejtimi;
    }

    public Klasa(int niveli, Shkolla shkolla, Paralelja paralelja, Mesuesi mesuesi, Drejtimi drejtimi) {
        this.niveli = niveli;
        this.shkolla = shkolla;
        this.paralelja = paralelja;
        this.mesuesi = mesuesi;
        this.drejtimi = drejtimi;
    }

    public static Klasa fromResultSet(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        int niveli = result.getInt("niveli");

        // Marrim objektet referencë nga ResultSet
        Shkolla shkolla = Shkolla.fromResultSet(result);
        Paralelja paralelja = Paralelja.fromResultSet(result);
        Mesuesi mesuesi = Mesuesi.fromResultSet(result);
        Drejtimi drejtimi = Drejtimi.fromResultSet(result);

        return new Klasa(id, niveli, shkolla, paralelja, mesuesi, drejtimi);
    }

    public int getId() {
        return id;
    }

    public int getNiveli() {
        return niveli;
    }

    public Shkolla getShkolla() {
        return shkolla;
    }

    public Paralelja getParalelja() {
        return paralelja;
    }

    public Mesuesi getMesuesi() {
        return mesuesi;
    }

    public Drejtimi getDrejtimi() {
        return drejtimi;
    }

    public void setNiveli(int niveli) {
        this.niveli = niveli;
    }

    public void setShkolla(Shkolla shkolla) {
        this.shkolla = shkolla;
    }

    public void setParalelja(Paralelja paralelja) {
        this.paralelja = paralelja;
    }

    public void setMesuesi(Mesuesi mesuesi) {
        this.mesuesi = mesuesi;
    }

    public void setDrejtimi(Drejtimi drejtimi) {
        this.drejtimi = drejtimi;
    }

    @Override
    public String toString() {
        return "Klasa {" +
                "ID = " + id +
                ", Niveli = " + niveli +
                ", Shkolla = " + shkolla +
                ", Paralelja = " + paralelja +
                ", Mesuesi = " + mesuesi +
                ", Drejtimi = " + drejtimi +
                '}';
    }
    public String toReportLine() {
        return String.format("ID: %d | Niveli: %d | Shkolla: %s | Paralelja: %s | Mësuesi: %s %s | Drejtimi: %s",
                id,
                niveli,
                shkolla.getEmri(),
                paralelja.getEmri(),
                mesuesi.getEmri(),
                mesuesi.getMbiemri(),
                drejtimi.getEmri());
    }

}
