package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Notat {
    private int id;
    private Nxenesit nxenesi;
    private Lenda lenda;
    private Mesuesi mesuesi;
    private Drejtimi drejtimi;
    private Klasa klasa;
    private Paralelja paralelja;
    private int notaPare;
    private int notaDyte;

    public Notat(int id, Nxenesit nxenesi, Lenda lenda, Mesuesi mesuesi, Drejtimi drejtimi, Klasa klasa, Paralelja paralelja, int notaPare, int notaDyte) {
        this.id = id;
        this.nxenesi = nxenesi;
        this.lenda = lenda;
        this.mesuesi = mesuesi;
        this.drejtimi = drejtimi;
        this.klasa = klasa;
        this.paralelja = paralelja;
        this.notaPare = notaPare;
        this.notaDyte = notaDyte;
    }

    public Notat(Nxenesit nxenesi, Lenda lenda, Mesuesi mesuesi, Drejtimi drejtimi, Klasa klasa, Paralelja paralelja, int notaPare, int notaDyte) {
        this.nxenesi = nxenesi;
        this.lenda = lenda;
        this.mesuesi = mesuesi;
        this.drejtimi = drejtimi;
        this.klasa = klasa;
        this.paralelja = paralelja;
        this.notaPare = notaPare;
        this.notaDyte = notaDyte;
    }

    public static Notat fromResultSet(ResultSet result) throws SQLException {
        int id = result.getInt("id");

        // Krijimi i instancave për objektet referencë
        Nxenesit nxenesi = Nxenesit.fromResultSet(result);
        Lenda lenda = Lenda.fromResultSet(result);
        Mesuesi mesuesi = Mesuesi.fromResultSet(result);
        Drejtimi drejtimi = Drejtimi.fromResultSet(result);
        Klasa klasa = Klasa.fromResultSet(result);
        Paralelja paralelja = Paralelja.fromResultSet(result);

        int notaPare = result.getInt("nota_pare");
        int notaDyte = result.getInt("nota_dyte");

        return new Notat(id, nxenesi, lenda, mesuesi, drejtimi, klasa, paralelja, notaPare, notaDyte);
    }

    public int getId() {
        return id;
    }

    public Nxenesit getNxenesi() {
        return nxenesi;
    }

    public Lenda getLenda() {
        return lenda;
    }

    public Mesuesi getMesuesi() {
        return mesuesi;
    }

    public Drejtimi getDrejtimi() {
        return drejtimi;
    }

    public Klasa getKlasa() {
        return klasa;
    }

    public Paralelja getParalelja() {
        return paralelja;
    }

    public int getNotaPare() {
        return notaPare;
    }

    public int getNotaDyte() {
        return notaDyte;
    }

    public void setNotaPare(int notaPare) {
        this.notaPare = notaPare;
    }

    public void setNotaDyte(int notaDyte) {
        this.notaDyte = notaDyte;
    }

    @Override
    public String toString() {
        return "Notat {" +
                "ID = " + id +
                ", Nxenesi = " + nxenesi +
                ", Lenda = " + lenda +
                ", Mesuesi = " + mesuesi +
                ", Drejtimi = " + drejtimi +
                ", Klasa = " + klasa +
                ", Paralelja = " + paralelja +
                ", Nota Pare = " + notaPare +
                ", Nota Dyte = " + notaDyte +
                '}';
    }
}
