package models.dto.create;
import models.User;

public class CreateUser {
    private String username;
    private String password;
    private String email;
    private String emer;
    private String mbiemer;
    private User.Role role;

    public CreateUser(String username, String password, String email, String emer, String mbiemer, User.Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.emer = emer;
        this.mbiemer = mbiemer;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getEmer() {
        return emer;
    }

    public String getMbiemer() {
        return mbiemer;
    }

    public User.Role getRole() {
        return role;
    }
}
