package models.dto.create;

public class CreateDrejtimi {
    private String emri;
    private int shkollaId;
    private int paraleljaId;

    public CreateDrejtimi(String emri, int shkollaId, int paraleljaId) {
        this.emri = emri;
        this.shkollaId = shkollaId;
        this.paraleljaId = paraleljaId;
    }

    public String getEmri() {
        return emri;
    }

    public int getShkollaId() {
        return shkollaId;
    }

    public int getParaleljaId() {
        return paraleljaId;
    }
}
