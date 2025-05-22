package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;
import utils.LanguageHandler;
import utils.SceneLocator;
import utils.SceneNavigator;

import java.io.IOException;

public class MesuesiController {

    @FXML private MenuButton menuLanguage;

    @FXML public void initialize() {
        LanguageHandler.configureLanguageMenu(menuLanguage, SceneLocator.TEACHER_PAGE);

    }

    @FXML
    private void handleStudents(ActionEvent event) {
        SceneNavigator.switchScene((Node) event.getSource(), SceneLocator.STUDENT_MANAGEMENT_PAGE);
    }
    @FXML
    private void handleGrades(ActionEvent event) {
        SceneNavigator.switchScene((Node) event.getSource(), SceneLocator.GRADE_MANAGEMENT_PAGE);
    }
    @FXML
    private void handleAbsence(ActionEvent event) {
        SceneNavigator.switchScene((Node) event.getSource(), SceneLocator.ABSENCES_PAGE);
    }
    @FXML
    private void onOpenStatisticsTeacher(ActionEvent event) {
        SceneNavigator.switchScene((Node) event.getSource(), SceneLocator.TEACHER_STATISTICS_PAGE);
    }
    @FXML
    private void handleLogout(ActionEvent event) {
        SceneNavigator.logout((Node) event.getSource());
    }

    @FXML
    private void onOpenSettings(ActionEvent event) {
        SceneNavigator.switchScene((Node) event.getSource(), SceneLocator.SETTINGS_PAGE);
    }


}