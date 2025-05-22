package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.User;
import services.UserService;
import utils.LanguageHandler;
import utils.SceneLocator;
import utils.SceneNavigator;

import java.io.IOException;
import java.util.Locale;
import java.util.Optional;

import static utils.SceneLocator.*;

public class LoginController {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private MenuButton menuLanguage;

    private final UserService userService = new UserService();

    @FXML
    public void initialize() {
        LanguageHandler.configureLanguageMenu(menuLanguage, SceneLocator.LOGIN_PAGE);
    }

    @FXML
    private void handleLogin() {
        String username = txtUsername.getText().trim();
        String password = txtPassword.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Kredenciale të Zbrazëta", "Ju lutem plotësoni të gjitha fushat!", "Përdoruesi dhe Fjalëkalimi nuk mund të jenë të zbrazëta.");
            return;
        }

        User u = userService.authenticate(username, password);

        if (u == null) {
            txtUsername.clear();
            txtPassword.clear();
            txtUsername.requestFocus();
            showAlert(Alert.AlertType.ERROR, "Kredenciale të pasakta", "Kyçja dështoi!", "Përdoruesi ose fjalëkalimi janë të pasakta. Provo përsëri.");
            return;
        }

        // Printo për verifikim
        System.out.println("🔄 Roli i përdoruesit: " + u.getRole());

        try {
            Node source = txtUsername;

            switch (u.getRole()) {
                case ADMIN:
                    SceneNavigator.switchScene(source, ADMIN_PAGE);
                    break;

                case PRINCIPAL:
                case DREJTOR:
                    SceneNavigator.switchScene(source, PRINCIPAL_PAGE);
                    break;

                case MESUES:
                case TEACHER:
                    SceneNavigator.switchScene(source, TEACHER_PAGE);
                    break;

                case STUDENT:
                case NXENES:
                    SceneNavigator.switchScene(source, STUDENT_PAGE);
                    break;

                default:
                    showAlert(Alert.AlertType.WARNING, "Roli i panjohur", "Roli i përdoruesit nuk është i njohur!", "Kontrolloni të dhënat e përdoruesit ose kontaktoni administratorin.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Gabim gjatë hapjes së faqes", "Ndodhi një gabim gjatë ngarkimit të pamjes kryesore.", "Kontrolloni lidhjen dhe provoni përsëri.");
        }
    }

    @FXML
    private void onForgotPassword(ActionEvent event) {
        System.out.println("🔄 Duke kaluar në Rivendos Fjalëkalimin...");
        SceneLocator.locate(event, SceneLocator.RESET_PASSWORD);
    }

    @FXML
    void handleEnglishLanguage(ActionEvent event) {
        Locale.setDefault(new Locale("en"));
        Stage stage = (Stage) menuLanguage.getScene().getWindow();
        SceneLocator.locate(stage, SceneLocator.LOGIN_PAGE);
    }

    @FXML
    void handleAlbanianLanguage(ActionEvent event) {
        Locale.setDefault(new Locale("sq"));
        Stage stage = (Stage) menuLanguage.getScene().getWindow();
        SceneLocator.locate(stage, SceneLocator.LOGIN_PAGE);
    }

    private void showAlert(Alert.AlertType alertType, String title, String header, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
