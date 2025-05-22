package models.dto.create;

public class CreateMesuesi {
    public String emri, mbiemri, email, tel, roli;
    public int adresaId;

    public CreateMesuesi(String emri, String mbiemri, String email, String tel, String roli, int adresaId) {
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.email = email;
        this.tel = tel;
        this.roli = roli;
        this.adresaId = adresaId;
    }
}
