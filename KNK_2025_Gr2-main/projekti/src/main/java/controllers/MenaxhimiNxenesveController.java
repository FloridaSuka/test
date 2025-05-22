package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import models.dto.create.CreateNxenesit;
import models.dto.update.UpdateNxenesit;
import services.NxenesitService;
import utils.LanguageHandler;
import utils.SceneLocator;

public class MenaxhimiNxenesveController {
    @FXML
    private TextField txtId, txtEmri, txtMbiemri, txtDatelindja, txtGjinia, txtEmail, txtPhone, txtAdresa;
    private final NxenesitService service = new NxenesitService();
    @FXML private MenuButton menuLanguage;

    @FXML public void initialize() {
        // Configure language menu
        LanguageHandler.configureLanguageMenu(menuLanguage, SceneLocator.STUDENT_MANAGEMENT_PAGE);
        mbushRaportinENxenesve();
    }


    private void mbushRaportinENxenesve() {
    }

    @FXML
    private void shtoNxenes() {
        int adresaId = service.getAdresaId(txtAdresa.getText());
        CreateNxenesit nx = new CreateNxenesit(
                txtEmri.getText(),
                txtMbiemri.getText(),
                txtDatelindja.getText(),
                txtGjinia.getText().charAt(0),
                txtEmail.getText(),
                txtPhone.getText(),
                adresaId
        );

        if (service.shto(nx)) {
            showAlert("Sukses", "Nxënësi u shtua me sukses.");
        } else {
            showAlert("Gabim", "Nxënësi nuk u shtua.");
        }
    }

    @FXML
    private void fshijNxenes() {
        int id = Integer.parseInt(txtId.getText());
        if (service.fshij(id)) {
            showAlert("Sukses", "Nxënësi u fshi me sukses.");
        } else {
            showAlert("Gabim", "Nxënësi nuk u fshi.");
        }
    }

    @FXML
    private void perditesoNxenes() {
        int adresaId = service.getAdresaId(txtAdresa.getText());
        UpdateNxenesit nx = new UpdateNxenesit(
                Integer.parseInt(txtId.getText()),
                txtEmri.getText(),
                txtMbiemri.getText(),
                txtDatelindja.getText(),
                txtGjinia.getText().charAt(0),
                txtEmail.getText(),
                txtPhone.getText(),
                adresaId
        );

        if (service.perditeso(nx)) {
            showAlert("Sukses", "Nxënësi u përditësua me sukses.");
        } else {
            showAlert("Gabim", "Përditësimi dështoi.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
