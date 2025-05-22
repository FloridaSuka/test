package models.dto.update;

public class UpdateAdresa {
    private int id;
    private String qyteti;
    private String rruga;
    private String kodiPostar;

    public UpdateAdresa(int id, String qyteti, String rruga, String kodiPostar) {
        this.id = id;
        this.qyteti = qyteti;
        this.rruga = rruga;
        this.kodiPostar = kodiPostar;
    }

    public int getId() {
        return id;
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

