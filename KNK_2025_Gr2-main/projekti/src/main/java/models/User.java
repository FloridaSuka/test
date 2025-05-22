package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

    public enum Role {ADMIN, DREJTOR, MESUES, NXENES, PRINCIPAL, STUDENT, TEACHER}
    private int id;
    private String username;
    private String password;
    private String email;
    private String emer;
    private String mbiemer;
    private Role role = Role.MESUES;

    public User(int id, String username, String password, String email, String emer, String mbiemer, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.emer = emer;
        this.mbiemer = mbiemer;
        this.role = role;
    }

    public User(String username, String passwordHash, Role role) {
        this(0, username, passwordHash, null, null, null, role);
    }

    public int getId() {
        return id;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getEmail(){
        return email;
    }
    public String getEmer() {
        return emer;
    }
    public String getMbiemer() {
        return mbiemer;
    }
    public Role getRole(){
        return role;
    }
    public String setUsername(String username){
        return this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setEmer(String emer) {
        this.emer = emer;
    }
    public void setMbiemer(String mbiemer) {
        this.mbiemer = mbiemer;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public static User getInstance(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String username = result.getString("username");
        String password = result.getString("password");
        String email = result.getString("email");
        String emer = result.getString("name");         // kolona për emër
        String mbiemer = result.getString("surname");   // kolona për mbiemër

        String roleStr = result.getString("role");
        User.Role role = roleStr != null
                ? User.Role.valueOf(roleStr.trim().toUpperCase())
                : User.Role.MESUES;

        return new User(id, username, password, email, emer, mbiemer, role);
    }


    @Override
    public String toString() {
        return String.format("User{id=%d, username='%s', role=%s}", id, username, role);
    }
}
