package models.dto.update;

import models.dto.create.CreateMesuesi;

public class UpdateMesuesi extends CreateMesuesi {
    public int id;

    public UpdateMesuesi(int id, String emri, String mbiemri, String email, String tel, String roli, int adresaId) {
        super(emri, mbiemri, email, tel, roli, adresaId);
        this.id = id;
    }
}
