package models.dto.update;

public class UpdateAdministratori {
    private int id;
    private int userId;
    private String emailZyrtar;
    private String telefoni;
    private String departamenti;
    private boolean aktiv;

    public UpdateAdministratori(int id, int userId, String emailZyrtar, String telefoni, String departamenti, boolean aktiv) {
        this.id = id;
        this.userId = userId;
        this.emailZyrtar = emailZyrtar;
        this.telefoni = telefoni;
        this.departamenti = departamenti;
        this.aktiv = aktiv;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmailZyrtar() {
        return emailZyrtar;
    }

    public String getTelefoni() {
        return telefoni;
    }

    public String getDepartamenti() {
        return departamenti;
    }

    public boolean isAktiv() {
        return aktiv;
    }
}
