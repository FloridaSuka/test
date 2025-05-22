package models.dto.update;

public class UpdateMungesa {
    private int id;
    private String student;
    private int lendaId;
    private int periodaId;
    private String dataMungeses;
    private String arsyeja;

    public UpdateMungesa(int id, String student, int lendaId, int periodaId, String dataMungeses, String arsyeja) {
        this.id = id;
        this.student = student;
        this.lendaId = lendaId;
        this.periodaId = periodaId;
        this.dataMungeses = dataMungeses;
        this.arsyeja = arsyeja;
    }

    public int getId() { return id; }
    public String getStudent() { return student; }
    public int getLendaId() { return lendaId; }
    public int getPeriodaId() { return periodaId; }
    public String getDataMungeses() { return dataMungeses; }
    public String getArsyeja() { return arsyeja; }

    public void setId(int id) { this.id = id; }
    public void setStudent(String student) { this.student = student; }
    public void setLendaId(int lendaId) { this.lendaId = lendaId; }
    public void setPeriodaId(int periodaId) { this.periodaId = periodaId; }
    public void setDataMungeses(String dataMungeses) { this.dataMungeses = dataMungeses; }
    public void setArsyeja(String arsyeja) { this.arsyeja = arsyeja; }
}
