package models.dto.update;

public class UpdatePerioda {
    private int idPerioda;
    private String emri;
    private String dataFillimit;
    private String dataMbarimit;

    public UpdatePerioda(int idPerioda, String emri, String dataFillimit, String dataMbarimit) {
        this.idPerioda = idPerioda;
        this.emri = emri;
        this.dataFillimit = dataFillimit;
        this.dataMbarimit = dataMbarimit;
    }

    public int getIdPerioda() { return idPerioda; }
    public String getEmri() { return emri; }
    public String getDataFillimit() { return dataFillimit; }
    public String getDataMbarimit() { return dataMbarimit; }

    public void setIdPerioda(int idPerioda) { this.idPerioda = idPerioda; }
    public void setEmri(String emri) { this.emri = emri; }
    public void setDataFillimit(String dataFillimit) { this.dataFillimit = dataFillimit; }
    public void setDataMbarimit(String dataMbarimit) { this.dataMbarimit = dataMbarimit; }
}
