package models.dto.create;

public class CreateShkolla {
    private String emri;
    private String tel;
    private int adresaId;

    public CreateShkolla(String emri, String tel, int adresaId) {
        this.emri = emri;
        this.tel = tel;
        this.adresaId = adresaId;
    }

    public String getEmri() { return emri; }
    public String getTel() { return tel; }
    public int getAdresaId() { return adresaId; }
}
