package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import models.dto.create.CreateNxenesit;
import models.dto.update.UpdateNxenesit;
import services.NxenesitService;
import utils.LanguageHandler;
import utils.SceneLocator;
import utils.SceneNavigator;

public class NxenesiController {



    @FXML private ListView<String> raportiNxenesve;

    @FXML private MenuButton menuLanguage;

    @FXML public void initialize() {
        // Configure language menu
        LanguageHandler.configureLanguageMenu(menuLanguage, SceneLocator.STUDENT_PAGE);
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

