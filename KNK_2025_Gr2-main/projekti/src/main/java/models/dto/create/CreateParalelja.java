package main.java.models.dto.create;

public class CreateParalelja {
    private int id;
    private String emri;


    public CreateParalelja(int id, String emri) {
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
