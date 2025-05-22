package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Shkolla {
    private int id;
    private String emri;
    private String tel;
    private Adresa adresa;

    public Shkolla(int id, String emri, String tel, Adresa adresa) {
        this.id = id;
        this.emri = emri;
        this.tel = tel;
        this.adresa = adresa;
    }
    public Shkolla(String emri, String tel, Adresa adresa) {
        this.emri = emri;
        this.tel = tel;
        this.adresa = adresa;
    }

    public static Shkolla fromResultSet(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String emri = result.getString("emri");
        String tel = result.getString("tel");

        Adresa adresa = Adresa.getInstance(result);

        return new Shkolla(id, emri, tel, adresa);
    }

    public int getId() {
        return id;
    }

    public String getEmri() {
        return emri;
    }

    public String getTel() {
        return tel;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Shkolla {" +
                "ID = " + id +
                ", Emri = '" + emri + '\'' +
                ", Tel = '" + tel + '\'' +
                ", Adresa = " + adresa +
                '}';
    }
}
