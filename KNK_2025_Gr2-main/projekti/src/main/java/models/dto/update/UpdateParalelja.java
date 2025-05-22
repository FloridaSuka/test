package main.java.models.dto.update;

public class UpdateParalelja {
    private int id;
    private String emri;


    public UpdateParalelja(int id, String emri) {
        this.id = id;
        this.emri = emri;

    }

    public int getId() {
        return id;
    }

    public String getEmri() {
        return emri;
    }

}
