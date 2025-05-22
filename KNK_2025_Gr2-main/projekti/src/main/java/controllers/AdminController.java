package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.MenuButton;
import utils.LanguageHandler;
import utils.SceneLocator;
import utils.SceneNavigator;

import java.util.ResourceBundle;

public class AdminController {

    @FXML
    private MenuButton menuLanguage;


    @FXML
    public void initialize() {
        LanguageHandler.configureLanguageMenu(menuLanguage, SceneLocator.ADMIN_PAGE);
    }
    @FXML
    private void onOpenSettings(ActionEvent event) {
        SceneNavigator.switchScene((Node) event.getSource(), SceneLocator.SETTINGS_PAGE);
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        SceneNavigator.logout((Node) event.getSource());
    }

    @FXML
    private void onOpenSchool(ActionEvent event) {
        SceneNavigator.switchScene((Node) event.getSource(), SceneLocator.SCHOOL_MANAGEMENT_PAGE);
    }
    @FXML
    private void onOpenPrincipal(ActionEvent event) {
        SceneNavigator.switchScene((Node) event.getSource(), SceneLocator.PRINCIPAL_MANAGEMENT_PAGE);

    }
}
