package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Mesuesi {
    private int id;
    private String emri;
    private String mbiemri;
    private String email;
    private String tel;
    private Adresa adresa;

    public Mesuesi(int id, String emri, String mbiemri, String email, String tel, Adresa adresa) {
        this.id = id;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.email = email;
        this.tel = tel;
        this.adresa = adresa;
    }

    public Mesuesi(String emri, String mbiemri, String email, String tel, Adresa adresa) {
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.email = email;
        this.tel = tel;
        this.adresa = adresa;
    }

    // ✅ Krijimi i instancës nga ResultSet
    public static Mesuesi fromResultSet(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String emri = result.getString("emri");
        String mbiemri = result.getString("mbiemri");
        String email = result.getString("email");
        String tel = result.getString("tel");
        Adresa adresa = Adresa.getInstance(result);

        return new Mesuesi(id, emri, mbiemri, email, tel, adresa);
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

    public String getEmail() {
        return email;
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

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Punonjesit {" +
                "ID = " + id +
                ", Emri = '" + emri + '\'' +
                ", Mbiemri = '" + mbiemri + '\'' +
                ", Email = '" + email + '\'' +
                ", Tel = '" + tel + '\'' +
                ", Adresa = " + adresa +
                '}';
    }
    public Mesuesi(int id, String emri, String mbiemri, String email, String tel) {
        this.id = id;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.email = email;
        this.tel = tel;
    }

}
