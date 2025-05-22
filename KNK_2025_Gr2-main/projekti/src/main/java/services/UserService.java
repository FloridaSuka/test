package services;

import models.User;
import models.dto.create.CreateUser;
import models.dto.update.UpdateUser;
import repositories.UserRepository;

public class UserService {

    private static User currentUser;  // Përdoruesi i kyçur aktualisht
    private final UserRepository userRepository = new UserRepository();

    public boolean register(CreateUser user) {
        return userRepository.shtoUser(user);
    }

    public User authenticate(String username, String password) {
        User user = userRepository.authenticate(username, password);
        if (user != null) {
            currentUser = user;
        }
        return user;
    }

    public boolean verifyUser(String username, String verificationCode) {
        return userRepository.verifyUser(username, verificationCode);
    }

    public boolean updatePassword(UpdateUser updateUser) {
        return userRepository.updatePassword(updateUser);
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }
}
