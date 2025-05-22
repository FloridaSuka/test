package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.Drejtor;
import repositories.AdresaRepository;
import repositories.DrejtoriRepository;
import utils.LanguageHandler;
import utils.MenuUtils;
import utils.SceneLocator;

import static utils.ZipUtils.gjejQytetinNgaZip;

public class MenaxhimiDrejtoreveController {
    @FXML private TextField txtAdresa;
    @FXML private TextField txtzip;
    @FXML private TextField txtEmri;
    @FXML private TextField txtMbiemri;
    @FXML private TextField txtEmail;
    @FXML private TextField txtTel;
    @FXML private TextField txtIdShkolla;
    @FXML private TextField txtId;
    @FXML private TableView<Drejtor> tabelaDrejtor;
    @FXML private TableColumn<Drejtor, Integer> colId;
    @FXML private TableColumn<Drejtor, String> colEmri;
    @FXML private TableColumn<Drejtor, String> colMbiemri;
    @FXML private TableColumn<Drejtor, Integer> colShkolla;

    @FXML private MenuItem menuCut, menuCopy, menuPaste, menuUndo, menuSelectAll, menuRedo;
    @FXML private Menu menuOpen;


    private final DrejtoriRepository drejtoriRepo = new DrejtoriRepository();
    private final AdresaRepository adresaRepo = new AdresaRepository();
    @FXML
    private MenuButton menuLanguage;

    @FXML
    public void initialize() {

        String name = this.getClass().getSimpleName();
        System.out.println("🔍 Controller aktiv: " + name);
        MenuUtils.populateOpenSubMenu(menuOpen, name);

        LanguageHandler.configureLanguageMenu(menuLanguage, SceneLocator.PRINCIPAL_MANAGEMENT_PAGE);

    }
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
    private void shtoDrejtor() {
        String rruga = txtAdresa.getText();
        String kodiPostar = txtzip.getText();
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

        Drejtor d = new Drejtor(
                txtEmri.getText(),
                txtMbiemri.getText(),
                txtEmail.getText(),
                txtTel.getText(),
                adresaId,
                Integer.parseInt(txtIdShkolla.getText())
        );

        DrejtoriRepository drejtoriRepo = new DrejtoriRepository();
        boolean success = drejtoriRepo.shtoDrejtor(d);
        showAlert(success, "Shtim", "Drejtori u shtua me sukses!", "Shtimi dështoi.");
    }


    @FXML
    private void perditesoDrejtor() {
        int id = Integer.parseInt(txtId.getText());
        String rruga = txtAdresa.getText();
        String zip = txtzip.getText();

        Integer adresaId = 0;
        if (!rruga.isBlank() && !zip.isBlank()) {
            String qyteti = gjejQytetinNgaZip(zip);
            if (qyteti != null) {
                adresaId = adresaRepo.shtoAdrese(qyteti, rruga, zip);
            }
        }

        Drejtor d = new Drejtor(
                id,
                txtEmri.getText().isBlank() ? null : txtEmri.getText(),
                txtMbiemri.getText().isBlank() ? null : txtMbiemri.getText(),
                txtEmail.getText().isBlank() ? null : txtEmail.getText(),
                txtTel.getText().isBlank() ? null : txtTel.getText(),
                adresaId,
                txtIdShkolla.getText().isBlank() ? 0 : Integer.parseInt(txtIdShkolla.getText())
        );


        boolean success = drejtoriRepo.perditesoDrejtor(d);
        showAlert(success, "Përditësim", "Drejtori u përditësua me sukses!", "Përditësimi dështoi.");
    }

    // 🔸 Fshirja
    @FXML
    private void fshijDrejtor() {
        int id = Integer.parseInt(txtId.getText());
        boolean success = drejtoriRepo.fshijDrejtor(id);
        showAlert(success, "Fshirje", "Drejtori u fshi me sukses!", "Fshirja dështoi.");
    }
    private void showAlert(boolean success, String title, String msgSuccess, String msgFail) {
        Alert alert = new Alert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(success ? msgSuccess : msgFail);
        alert.showAndWait();
    }


}
