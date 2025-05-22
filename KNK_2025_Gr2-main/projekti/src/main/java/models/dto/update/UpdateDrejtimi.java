package models.dto.update;

public class UpdateDrejtimi {
    private int id;
    private String emri;
    private int shkollaId;
    private int paraleljaId;

    public UpdateDrejtimi(int id, String emri, int shkollaId, int paraleljaId) {
        this.id = id;
        this.emri = emri;
        this.shkollaId = shkollaId;
        this.paraleljaId = paraleljaId;
    }

    public int getId() {
        return id;
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

