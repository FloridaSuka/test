package models.dto.update;

public class UpdateNxenesit {
    private int id;
    private String emri;
    private String mbiemri;
    private String datelindja;
    private char gjinia;
    private String email;
    private String phone;
    private int adresaId;

    public UpdateNxenesit(int id, String emri, String mbiemri, String datelindja, char gjinia, String email, String phone, int adresaId) {
        this.id = id;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.datelindja = datelindja;
        this.gjinia = gjinia;
        this.email = email;
        this.phone = phone;
        this.adresaId = adresaId;
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

    public String getDatelindja() {
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

    public int getAdresaId() {
        return adresaId;
    }

}