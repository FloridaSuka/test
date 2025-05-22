package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Paralelja {
    private int id;
    private String emri;

    public Paralelja(int id, String emri) {
        this.id = id;
        this.emri = emri;
    }

    public Paralelja(String emri) {
        this.emri = emri;
    }

    public static Paralelja fromResultSet(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String emri = result.getString("emri");
        return new Paralelja(id, emri);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    @Override
    public String toString() {
        return "Paralelja {" +
                "ID = " + id +
                ", Emri = '" + emri + '\'' +
                '}';
    }
}
