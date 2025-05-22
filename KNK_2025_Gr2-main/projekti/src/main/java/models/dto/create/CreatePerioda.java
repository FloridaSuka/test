package models.dto.create;

public class CreatePerioda {
    private String emri;
    private String dataFillimit;
    private String dataMbarimit;

    public CreatePerioda(String emri, String dataFillimit, String dataMbarimit) {
        this.emri = emri;
        this.dataFillimit = dataFillimit;
        this.dataMbarimit = dataMbarimit;
    }

    public String getEmri() { return emri; }
    public String getDataFillimit() { return dataFillimit; }
    public String getDataMbarimit() { return dataMbarimit; }

    public void setEmri(String emri) { this.emri = emri; }
    public void setDataFillimit(String dataFillimit) { this.dataFillimit = dataFillimit; }
    public void setDataMbarimit(String dataMbarimit) { this.dataMbarimit = dataMbarimit; }
}
