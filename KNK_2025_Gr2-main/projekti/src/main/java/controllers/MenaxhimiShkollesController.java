package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import models.Shkolla;
import models.dto.create.CreateShkolla;
import models.dto.update.UpdateShkolla;
import repositories.AdresaRepository;
import repositories.ShkollaRepository;
import utils.LanguageHandler;
import utils.SceneLocator;

import static utils.ZipUtils.gjejQytetinNgaZip;
import java.util.List;

public class MenaxhimiShkollesController {

    @FXML private TextField txtId;
    @FXML private TextField txtEmri;
    @FXML private TextField txtTel;
    @FXML private TextField txtAdresa;
    @FXML private TextField txtZip;
    @FXML
    private ListView<String> raportiShkollave;

    private final ShkollaRepository repo = new ShkollaRepository();
    private final AdresaRepository adresaRepo = new AdresaRepository();
    @FXML
    private MenuButton menuLanguage;

    @FXML
    public void initialize() {
        LanguageHandler.configureLanguageMenu(menuLanguage, SceneLocator.ADMIN_PAGE);
    }
    @FXML
    private void shto() {
        String rruga = txtAdresa.getText();
        String kodiPostar = txtZip.getText();
        String qyteti = gjejQytetinNgaZip(kodiPostar);

        if (qyteti == null) {
            showAlert(false, "Gabim", "Kodi postar i panjohur!", "Kontrolloni kodin postar.");
            return;
        }

        AdresaRepository adresaRepo = new AdresaRepository();
        Integer adresaId = adresaRepo.shtoAdrese(qyteti, rruga, kodiPostar);

        if (adresaId == null) {
            showAlert(false, "Gabim", "Adresa nuk u ruajt!", "Adresa dështoi.");
            return;
        }
        CreateShkolla shkolla=new CreateShkolla(
                txtEmri.getText(),
                txtTel.getText(),
                adresaId
        );

        ShkollaRepository shkollarepo=new ShkollaRepository();
        boolean success = shkollarepo.shtoShkollen(shkolla);


        showAlert(success, "Shtim", "Shkolla u shtua me sukses!", "Shtimi dështoi.");
    }

    @FXML
    private void perditeso() {
        int id = Integer.parseInt(txtId.getText());
        String rruga = txtAdresa.getText();
        String zip = txtZip.getText();
        Integer adresaId = 0;
        if (!rruga.isBlank() && !zip.isBlank()) {
            String qyteti = gjejQytetinNgaZip(zip);
            if (qyteti != null) {
                adresaId = adresaRepo.shtoAdrese(qyteti, rruga, zip);
            }
        }
        UpdateShkolla shkolla = new UpdateShkolla(
                id,
                txtEmri.getText().isBlank() ? null : txtEmri.getText(),
                txtTel.getText().isBlank() ? null : txtTel.getText(),
                adresaId
        );

        boolean success = repo.perditesoShkollen(shkolla);
        showAlert(success, "Përditësim", "Shkolla u përditësua me sukses!", "Përditësimi dështoi.");
    }

    @FXML
    private void fshij() {
        int id = Integer.parseInt(txtId.getText());
        boolean success = repo.fshijShkollen(id);

        if (success) {
            raportiShkollave.getItems().add(" Fshirje: ID " + id + " | Emri: " + txtEmri.getText());
        }

    }

    private void showAlert(boolean success, String title, String msgSuccess, String msgFail) {
        Alert alert = new Alert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(success ? msgSuccess : msgFail);
        alert.showAndWait();
    }

}