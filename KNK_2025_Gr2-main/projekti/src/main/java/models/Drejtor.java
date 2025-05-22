package models;

public class Drejtor {
    private int id;
    private String emri;
    private String mbiemri;
    private String email;
    private String tel;
    private int adresaId;
    private int shkollaId;

    public Drejtor(int id, String emri, String mbiemri, String email, String tel, int adresaId, int shkollaId) {
        this.id = id;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.email = email;
        this.tel = tel;
        this.adresaId = adresaId;
        this.shkollaId = shkollaId;
    }

    public Drejtor(String emri, String mbiemri, String email, String tel, int adresaId, int shkollaId) {
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.email = email;
        this.tel = tel;
        this.adresaId = adresaId;
        this.shkollaId = shkollaId;
    }

    public int getId() { return id; }
    public String getEmri() { return emri; }
    public String getMbiemri() { return mbiemri; }
    public String getEmail() { return email; }
    public String getTel() { return tel; }
    public int getAdresaId() { return adresaId; }
    public int getShkollaId() { return shkollaId; }

    public void setId(int id) { this.id = id; }
    public void setEmri(String emri) { this.emri = emri; }
    public void setMbiemri(String mbiemri) { this.mbiemri = mbiemri; }
    public void setEmail(String email) { this.email = email; }
    public void setTel(String tel) { this.tel = tel; }
    public void setAdresaId(int adresaId) { this.adresaId = adresaId; }
    public void setShkollaId(int shkollaId) { this.shkollaId = shkollaId; }
}
