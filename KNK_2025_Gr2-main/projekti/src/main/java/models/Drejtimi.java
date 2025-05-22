package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Drejtimi {
    private int id;
    private String emri;
    private int shkollaId;
    private int paraleljaId;

    public Drejtimi(int id, String emri, int shkollaId, int paraleljaId) {
        this.id = id;
        this.emri = emri;
        this.shkollaId = shkollaId;
        this.paraleljaId = paraleljaId;
    }

    public Drejtimi(String emri, int shkollaId, int paraleljaId) {
        this.emri = emri;
        this.shkollaId = shkollaId;
        this.paraleljaId = paraleljaId;
    }

    public static Drejtimi fromResultSet(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String emri = result.getString("emri");
        int shkollaId = result.getInt("shkolla_id");
        int paraleljaId = result.getInt("paralelja_id");

        return new Drejtimi(id, emri, shkollaId, paraleljaId);
    }

    public int getId() {
        return id;
    }

    public String getEmri() {
        return emri;
    }

    public int getShkollaId() {
        return shkollaId;
    }

    public int getParaleljaId() {
        return paraleljaId;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public void setShkollaId(int shkollaId) {
        this.shkollaId = shkollaId;
    }

    public void setParaleljaId(int paraleljaId) {
        this.paraleljaId = paraleljaId;
    }

    @Override
    public String toString() {
        return "Drejtimi {" +
                "ID = " + id +
                ", Emri = '" + emri + '\'' +
                ", Shkolla ID = " + shkollaId +
                ", Paralelja ID = " + paraleljaId +
                '}';
    }
    public Drejtimi(int id, String emri) {
        this.id = id;
        this.emri = emri;
    }

}
