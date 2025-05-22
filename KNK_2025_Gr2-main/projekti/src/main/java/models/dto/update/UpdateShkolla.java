package models.dto.update;

public class UpdateShkolla {
    private int id;
    private String emri;
    private String tel;
    private int adresaId;

    public UpdateShkolla(int id, String emri, String tel, int adresaId) {
        this.id = id;
        this.emri = emri;
        this.tel = tel;
        this.adresaId = adresaId;
    }

    public int getId() { return id; }
    public String getEmri() { return emri; }
    public String getTel() { return tel; }
    public int getAdresaId() { return adresaId; }
}
