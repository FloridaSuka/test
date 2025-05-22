package controllers;

import database.DBConnector;
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
import utils.MenuUtils;
import utils.SceneLocator;
import utils.SceneNavigator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class SettingsController {

    @FXML
    private Label txtId;

    @FXML
    private Label txtEmri;

    @FXML
    private Label txtMbiemri;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtUsername;

    private final UserService userService = new UserService();

    @FXML
    private MenuButton menuLanguage;


    public void initialize() {
        User user = UserService.getCurrentUser();

        if (user != null) {
            txtId.setText(String.valueOf(user.getId()));
            txtEmri.setText(user.getEmer());
            txtMbiemri.setText(user.getMbiemer());
            txtEmail.setText(user.getEmail());
            txtUsername.setText(user.getUsername());
        } else {
            System.out.println("User not found!");
        }
        LanguageHandler.configureLanguageMenu(menuLanguage, SceneLocator.SETTINGS_PAGE);
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
    private void fshiLlogarine() {
        if (txtId.getText().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Fushë e Zbrazët", "ID nuk është e plotësuar!");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Konfirmo Fshirjen");
        confirm.setHeaderText("A je i sigurt që dëshiron ta fshish këtë llogari?");
        confirm.setContentText("Ky veprim nuk mund të kthehet mbrapsht.");

        Optional<ButtonType> response = confirm.showAndWait();

        if (response.isPresent() && response.get().getButtonData().isDefaultButton()) {
            int userId = Integer.parseInt(txtId.getText());

            try (Connection connection = DBConnector.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?")) {

                preparedStatement.setInt(1, userId);
                int result = preparedStatement.executeUpdate();

                if (result > 0) {
                    UserService.setCurrentUser(null); // Pastro përdoruesin aktual

                    showAlert(Alert.AlertType.INFORMATION, "Llogaria u fshi", "Llogaria u fshi me sukses!");

                    // Ridrejto në Login.fxml
                    Parent root = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
                    Stage stage = (Stage) txtId.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();

                } else {
                    showAlert(Alert.AlertType.ERROR, "Gabim", "Llogaria nuk u gjet ose fshirja dështoi.");
                }

            } catch (SQLException | IOException e) {
                e.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Gabim gjatë fshirjes", "Ndodhi një gabim gjatë fshirjes së llogarisë.");
            }
        }
    }

    @FXML
    public void onForgotPassword(ActionEvent event) {
        SceneNavigator.switchScene((Node) event.getSource(), SceneLocator.RESET_PASSWORD);

    }

    @FXML
    public void ndryshoEmail(ActionEvent actionEvent) {
        String id = txtId.getText();
        String emailRi = txtEmail.getText();

        if (id.isEmpty() || emailRi.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Fushë e zbrazët", "ID ose Email janë të zbrazët.");
            return;
        }

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE users SET email = ? WHERE id = ?")) {

            stmt.setString(1, emailRi);
            stmt.setInt(2, Integer.parseInt(id));
            int result = stmt.executeUpdate();

            if (result > 0) {
                User currentUser = UserService.getCurrentUser();
                currentUser.setEmail(emailRi);

                showAlert(Alert.AlertType.INFORMATION, "Sukses", "Email u përditësua me sukses!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Gabim", "Email nuk u përditësua.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Gabim në lidhje", "Gabim gjatë përditësimit të email.");
        }
    }

    @FXML
    public void ndryshoUsername() {
        String id = txtId.getText();
        String userRi = txtUsername.getText();

        if (id.isEmpty() || userRi.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Fushë e zbrazët", "ID ose Username janë të zbrazët.");
            return;
        }

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE users SET username = ? WHERE id = ?")) {

            stmt.setString(1, userRi);
            stmt.setInt(2, Integer.parseInt(id));
            int result = stmt.executeUpdate();

            if (result > 0) {
                User currentUser = UserService.getCurrentUser();
                currentUser.setUsername(userRi);

                showAlert(Alert.AlertType.INFORMATION, "Sukses", "Username u përditësua me sukses!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Gabim", "Username nuk u përditësua.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Gabim në lidhje", "Gabim gjatë përditësimit të username.");
        }
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

