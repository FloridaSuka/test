package models.dto.create;

public class CreateLenda {
    private String emri;
    private String drejtimi;
    private String perioda;
    private String mesuesi;

    public CreateLenda(String emri, String drejtimi, String perioda, String mesuesi) {
        this.emri = emri;
        this.drejtimi = drejtimi;
        this.perioda = perioda;
        this.mesuesi = mesuesi;
    }

    public String getEmri() {
        return emri;
    }

    public String getDrejtimi() {
        return drejtimi;
    }

    public String getPerioda() {
        return perioda;
    }

    public String getMesuesi() {
        return mesuesi;
    }
}
