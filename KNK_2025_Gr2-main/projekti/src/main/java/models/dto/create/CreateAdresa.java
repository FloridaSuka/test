package models.dto.create;

public class CreateAdresa {
    private String qyteti;
    private String rruga;
    private String kodiPostar;

    public CreateAdresa(String qyteti, String rruga, String kodiPostar) {
        this.qyteti = qyteti;
        this.rruga = rruga;
        this.kodiPostar = kodiPostar;
    }

    public String getQyteti() {
        return qyteti;
    }

    public String getRruga() {
        return rruga;
    }

    public String getKodiPostar() {
        return kodiPostar;
    }
}

