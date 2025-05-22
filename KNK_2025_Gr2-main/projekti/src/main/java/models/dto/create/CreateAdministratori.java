package models.dto.create;

import models.User;

import java.time.LocalDateTime;
import java.util.Date;

public class CreateAdministratori {
    private int ID;
    private User user;
    private String emailZyrtar;
    private String telefoni;
    private String departamenti;
    private boolean aktiv;
    private LocalDateTime dataKrijimit;

    public CreateAdministratori(int ID, User user, String emailZyrtar, String telefoni, String departamenti, boolean aktiv, LocalDateTime dataKrijimit) {
        this.ID = ID;
        this.user = user;
        this.emailZyrtar = emailZyrtar;
        this.telefoni = telefoni;
        this.departamenti = departamenti;
        this.aktiv = aktiv;
        this.dataKrijimit = dataKrijimit;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEmailZyrtar() {
        return emailZyrtar;
    }

    public void setEmailZyrtar(String emailZyrtar) {
        this.emailZyrtar = emailZyrtar;
    }

    public String getTelefoni() {
        return telefoni;
    }

    public void setTelefoni(String telefoni) {
        this.telefoni = telefoni;
    }

    public String getDepartamenti() {
        return departamenti;
    }

    public void setDepartamenti(String departamenti) {
        this.departamenti = departamenti;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public LocalDateTime getDataKrijimit() {
        return dataKrijimit;
    }

    public void setDataKrijimit(LocalDateTime dataKrijimit) {
        this.dataKrijimit = dataKrijimit;
    }
}