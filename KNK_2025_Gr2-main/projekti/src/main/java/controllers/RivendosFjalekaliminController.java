package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.dto.update.UpdateUser;
import services.UserService;
import utils.LanguageHandler;
import utils.MenuUtils;
import utils.SceneLocator;

import java.util.Locale;

public class RivendosFjalekaliminController {

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private PasswordField txtPassword1;

    @FXML
    private PasswordField txtPassword2;

    @FXML
    private MenuButton menuLanguage;

    private final UserService userService = new UserService();

    @FXML
    public void initialize() {
        LanguageHandler.configureLanguageMenu(menuLanguage, SceneLocator.RESET_PASSWORD);
        String name = this.getClass().getSimpleName();
        System.out.println("🔍 Controller aktiv: " + name);
        MenuUtils.populateOpenSubMenu(menuOpen, name);
    }
    @FXML private MenuItem menuCut, menuCopy, menuPaste, menuUndo, menuSelectAll, menuRedo;
    @FXML private Menu menuOpen;

    @FXML
    public void handleNew(ActionEvent event) {
        MenuUtils.handleNew();
    }

    @FXML
    public void handleOpen() {
        // Shembull: ky controller është për admin
        MenuUtils.openConditionalView("MenaxhimiDrejtoreveController", "menaxhimiDrejtoreve.fxml", "Menaxhimi i Drejtoreve");
    }

    @FXML
    public void handleQuit() {
        System.exit(0);
    }

    @FXML
    public void handleUndo() {
        MenuUtils.performUndo(menuUndo.getParentPopup().getOwnerWindow().getScene());
    }

    @FXML
    public void handleRedo() {
        MenuUtils.performRedo(menuRedo.getParentPopup().getOwnerWindow().getScene());
    }

    @FXML
    public void handleCut() {
        MenuUtils.performCut(menuCut.getParentPopup().getOwnerWindow().getScene());
    }

    @FXML
    public void handleCopy() {
        MenuUtils.performCopy(menuCopy.getParentPopup().getOwnerWindow().getScene());
    }

    @FXML
    public void handlePaste() {
        MenuUtils.performPaste(menuPaste.getParentPopup().getOwnerWindow().getScene());
    }

    @FXML
    public void handleSelectAll() {
        MenuUtils.performSelectAll(menuSelectAll.getParentPopup().getOwnerWindow().getScene());
    }

    @FXML
    public void handleHelp() {
        MenuUtils.openhelp();
    }
    @FXML
    void handleChange(ActionEvent event) {
        String username = txtUsername.getText().trim();
        String verificationCode = txtPassword.getText().trim();
        String newPassword = txtPassword1.getText().trim();
        String confirmPassword = txtPassword2.getText().trim();

        // ✅ Validimet bazë
        if (!validateInputs(username, verificationCode, newPassword, confirmPassword)) return;

        // ✅ Verifikimi në databazë
        if (userService.verifyUser(username, verificationCode)) {
            UpdateUser updateUser = new UpdateUser(username, newPassword, verificationCode);

            if (userService.updatePassword(updateUser)) {
                showAlert(Alert.AlertType.INFORMATION, "Sukses!", "Fjalëkalimi u ndryshua me sukses!");
                Stage stage = (Stage) txtUsername.getScene().getWindow();
                SceneLocator.locate(stage, SceneLocator.LOGIN_PAGE);
            } else {
                showAlert(Alert.AlertType.ERROR, "Gabim!", "Ndryshimi i fjalëkalimit dështoi.");
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Gabim!", "Përdoruesi ose kodi i verifikimit është i pasaktë.");
        }
    }

    private boolean validateInputs(String username, String verificationCode, String newPassword, String confirmPassword) {
        if (username.isEmpty() || verificationCode.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Gabim!", "Ju lutem plotësoni të gjitha fushat.");
            return false;
        }

        if (!newPassword.equals(confirmPassword)) {
            showAlert(Alert.AlertType.ERROR, "Gabim!", "Fjalëkalimet nuk përputhen!");
            return false;
        }

        if (!newPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) {
            showAlert(Alert.AlertType.ERROR, "Gabim!", "Fjalëkalimi duhet të përmbajë shkronja të mëdha, të vogla dhe numra!");
            return false;
        }

        return true;
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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
}
