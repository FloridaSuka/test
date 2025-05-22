package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import models.dto.create.CreateNxenesit;
import models.dto.update.UpdateNxenesit;
import services.NxenesitService;
import utils.LanguageHandler;
import utils.MenuUtils;
import utils.SceneLocator;
import utils.SceneNavigator;

public class NxenesiController {



    @FXML private ListView<String> raportiNxenesve;

    @FXML private MenuButton menuLanguage;

    @FXML public void initialize() {
        // Configure language menu
        LanguageHandler.configureLanguageMenu(menuLanguage, SceneLocator.STUDENT_PAGE);
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
    private void handleLogout(ActionEvent event) {
        SceneNavigator.logout((Node) event.getSource());
    }
    private final NxenesitService service = new NxenesitService();

@FXML
private void onOpenMungesat(ActionEvent event) {
    SceneNavigator.switchScene((Node) event.getSource(), SceneLocator.MUNGESAT_PAGE);
}
@FXML
private void onOpenNotat(ActionEvent event) {
    SceneNavigator.switchScene((Node) event.getSource(), SceneLocator.STUDENT_GRADES_PAGE);
}
    private void mbushRaportinENxenesve() {
        raportiNxenesve.getItems().clear();
        var nxenesit = service.merrTeGjitheNxenesit();
        for (var n : nxenesit) {
            String rreshti = "ID: " + n.getId()
                    + " | Emër: " + n.getEmri()
                    + " " + n.getMbiemri()
                    + " | Datëlindja: " + n.getDatelindja()
                    + " | Gjinia: " + n.getGjinia()
                    + " | Email: " + n.getEmail()
                    + " | Tel: " + n.getPhone()
                    + " | Adresa: " + n.getAdresa().getRruga();
            raportiNxenesve.getItems().add(rreshti);
        }
    }


}

