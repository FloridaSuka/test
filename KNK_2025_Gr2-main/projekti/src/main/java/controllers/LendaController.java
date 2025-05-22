package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.dto.create.CreateLenda;
import repositories.LendaRepository;
import utils.LanguageHandler;
import utils.MenuUtils;
import utils.SceneLocator;

public class LendaController {

    @FXML private TextField txtId;
    @FXML private TextField txtEmri;
    @FXML private TextField txtDrejtimi;
    @FXML private TextField txtPerioda;
    @FXML private TextField txtMesuesi;

    private final LendaRepository repo = new LendaRepository();
    @FXML
    private MenuButton menuLanguage;

    @FXML
    public void initialize() {
        LanguageHandler.configureLanguageMenu(menuLanguage, SceneLocator.SUBJECT_MANAGEMENT_PAGE);
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
    private void shtoLenda() {
        CreateLenda lenda = new CreateLenda(
                txtEmri.getText(),
                txtDrejtimi.getText(),
                txtPerioda.getText(),
                txtMesuesi.getText()
        );

        boolean success = repo.shto(lenda);
        showAlert(success, "Shtim", "Lënda u shtua me sukses!", "Shtimi dështoi!");
    }
    @FXML
    private void fshijLenda() {
        int id = Integer.parseInt(txtId.getText());
        boolean success = repo.fshij(id);
        showAlert(success, "Fshirje", "Lënda u fshi me sukses!", "Fshirja dështoi!");
    }

    private void showAlert(boolean success, String title, String msgSuccess, String msgFail) {
        Alert alert = new Alert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(success ? msgSuccess : msgFail);
        alert.showAndWait();
    }
}