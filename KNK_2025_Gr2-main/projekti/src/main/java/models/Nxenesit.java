package models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Nxenesit {
    private int id;
    private String emri;
    private String mbiemri;
    private Date datelindja;
    private char gjinia;
    private String email;
    private String phone;
    private Adresa adresa;

    public Nxenesit(int id, String emri, String mbiemri, Date datelindja, char gjinia, String email, String phone, Adresa adresa) {
        this.id = id;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.datelindja = datelindja;
        this.gjinia = gjinia;
        this.email = email;
        this.phone = phone;
        this.adresa = adresa;
    }

    public Nxenesit(String emri, String mbiemri, Date datelindja, char gjinia, String email, String phone, Adresa adresa) {
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.datelindja = datelindja;
        this.gjinia = gjinia;
        this.email = email;
        this.phone = phone;
        this.adresa = adresa;
    }

    public static Nxenesit fromResultSet(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String emri = result.getString("emri");
        String mbiemri = result.getString("mbiemri");
        Date datelindja = result.getDate("datelindja");
        char gjinia = result.getString("gjinia").charAt(0);
        String email = result.getString("email");
        String phone = result.getString("phone");
        Adresa adresa = Adresa.getInstance(result);

        return new Nxenesit(id, emri, mbiemri, datelindja, gjinia, email, phone, adresa);
    }

    public int getId() {
        return id;
    }

    public String getEmri() {
        return emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public Date getDatelindja() {
        return datelindja;
    }

    public char getGjinia() {
        return gjinia;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public void setDatelindja(Date datelindja) {
        this.datelindja = datelindja;
    }

    public void setGjinia(char gjinia) {
        this.gjinia = gjinia;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Nxenesit {" +
                "ID = " + id +
                ", Emri = '" + emri + '\'' +
                ", Mbiemri = '" + mbiemri + '\'' +
                ", Datelindja = " + datelindja +
                ", Gjinia = " + gjinia +
                ", Email = '" + email + '\'' +
                ", Phone = '" + phone + '\'' +
                ", Adresa = " + adresa +
                '}';
    }
}
