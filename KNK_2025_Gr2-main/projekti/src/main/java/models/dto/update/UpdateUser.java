package models.dto.update;

public class UpdateUser {
    private String username;
    private String newPassword;
    private String verificationCode;

    public UpdateUser(String username, String newPassword, String verificationCode) {
        this.username = username;
        this.newPassword = newPassword;
        this.verificationCode = verificationCode;
    }

    public String getUsername() {
        return username;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
