package controllers;

import database.DBConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import utils.SceneLocator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;

public class ShtoUser {

    @FXML
    private TextField txtEmri;

    @FXML
    private TextField txtMbiemri;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPerdoruesi;

    @FXML
    private PasswordField txtFjalekalimi;

    @FXML
    private PasswordField txtFjalekalimi2;

    @FXML
    private RadioButton radioDrejtor;

    @FXML
    private RadioButton radioMesues;

    @FXML
    private RadioButton radioNxenes;

    private ToggleGroup roleGroup;

    @FXML private MenuButton menuLanguage;


    @FXML
    public void initialize() {
        // Inicializimi i grupit
        roleGroup = new ToggleGroup();

        // Shtimi i butonave në grup
        radioDrejtor.setToggleGroup(roleGroup);
        radioMesues.setToggleGroup(roleGroup);
        radioNxenes.setToggleGroup(roleGroup);

        // Mos selekto asnjë si default
        roleGroup.selectToggle(null);
    }

    @FXML
    private void handleRegister() {
        if (txtEmri.getText().isEmpty() || txtMbiemri.getText().isEmpty() ||
                txtEmail.getText().isEmpty() || txtPerdoruesi.getText().isEmpty() ||
                txtFjalekalimi.getText().isEmpty() || txtFjalekalimi2.getText().isEmpty() ||
                roleGroup.getSelectedToggle() == null) {

            showAlert("Gabim", "Të dhëna të paplotësuara", "Ju lutem plotësoni të gjitha fushat!");
            return;
        }

        // ✅ Validimi me RegEx
        if (!txtEmri.getText().matches("[A-Za-z\\s]+")) {
            showAlert("Gabim", "Emri është i pavlefshëm", "Emri duhet të përmbajë vetëm shkronja dhe hapësira.");
            return;
        }

        if (!txtMbiemri.getText().matches("[A-Za-z\\s]+")) {
            showAlert("Gabim", "Mbiemri është i pavlefshëm", "Mbiemri duhet të përmbajë vetëm shkronja dhe hapësira.");
            return;
        }

        if (!txtEmail.getText().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            showAlert("Gabim", "Email i pavlefshëm", "Ju lutem vendosni një email të vlefshëm.");
            return;
        }

        if (!txtPerdoruesi.getText().matches("[A-Za-z0-9_]+")) {
            showAlert("Gabim", "Username i pavlefshëm", "Username duhet të përmbajë vetëm shkronja, numra ose '_'.");
            return;
        }

        if (!txtFjalekalimi.getText().equals(txtFjalekalimi2.getText())) {
            showAlert("Gabim", "Fjalëkalimet nuk përputhen", "Ju lutem kontrolloni fjalëkalimet!");
            return;
        }

        if (!txtFjalekalimi.getText().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) {
            showAlert("Gabim", "Fjalëkalimi i pavlefshëm", "Fjalëkalimi duhet të përmbajë të paktën një shkronjë të madhe, një të vogël, një numër dhe të jetë të paktën 8 karaktere.");
            return;
        }

        // ✅ Marrja e të dhënave
        String emri = txtEmri.getText();
        String mbiemri = txtMbiemri.getText();
        String email = txtEmail.getText();
        String perdoruesi = txtPerdoruesi.getText();
        String fjalekalimi = txtFjalekalimi.getText();
        String roli = ((RadioButton) roleGroup.getSelectedToggle()).getText();

        // ✅ Regjistrimi në databazë
        String query = "INSERT INTO users (name, surname, email, username, password, role) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            if (connection == null) {
                System.out.println("❌ Lidhja me databazën nuk u realizua.");
                return;
            }

            System.out.println("✅ Lidhja me databazën u realizua me sukses.");

            // Vendos të dhënat për ruajtje
            statement.setString(1, emri);
            statement.setString(2, mbiemri);
            statement.setString(3, email);
            statement.setString(4, perdoruesi);
            statement.setString(5, fjalekalimi);
            statement.setString(6, roli);

            // Ekzekuto query-n
            System.out.println("📝 Po regjistrohet në databazë...");
            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Të dhënat u ruajtën me sukses.");
                clearFields();
                showAlert("Sukses", "Regjistrimi u krye me sukses!", "Përdoruesi është ruajtur në sistem.");
            } else {
                System.out.println("❌ Asnjë rresht nuk u ruajt në databazë.");
            }

        } catch (SQLException e) {
            showAlert("Gabim", "Regjistrimi dështoi", "Ka ndodhur një gabim gjatë regjistrimit: " + e.getMessage());
            System.out.println("❌ Gabim gjatë ruajtjes: " + e.getMessage());
            e.printStackTrace();
        }

    }

    private void showAlert(String title, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        txtEmri.clear();
        txtMbiemri.clear();
        txtEmail.clear();
        txtPerdoruesi.clear();
        txtFjalekalimi.clear();
        txtFjalekalimi2.clear();
        roleGroup.selectToggle(null);
    }

    @FXML
    void handleEnglishLanguage(ActionEvent event) {
        Locale.setDefault(new Locale("en"));

        Stage stage = (Stage) menuLanguage.getScene().getWindow();
        SceneLocator.locate(stage, SceneLocator.ADD_USER_PAGE);
    }

    @FXML
    void handleAlbanianLanguage(ActionEvent event) {
        Locale.setDefault(new Locale("sq"));

        Stage stage = (Stage) menuLanguage.getScene().getWindow();
        SceneLocator.locate(stage, SceneLocator.ADD_USER_PAGE);
    }

}
