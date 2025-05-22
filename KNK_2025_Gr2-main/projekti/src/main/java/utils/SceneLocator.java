package utils;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class SceneLocator {
    public final static String MUNGESAT_PAGE = "/views/mungesat.fxml";
    public final static String NXENESIT_PAGE = "/views/nxenesit.fxml";
    public final static String SETTINGS_PAGE = "/views/settings.fxml";
    public final static String LOGIN_PAGE = "/views/login.fxml";
    public final static String ADMIN_PAGE = "/views/adminView.fxml";
    public final static String PRINCIPAL_PAGE = "/views/drejtorView.fxml";
    public final static String GRADE_MANAGEMENT_PAGE = "/views/MenaxhimiINotave.fxml";
    public final static String SCHOOL_MANAGEMENT_PAGE = "/views/menaxhimiShkolles.fxml";
    public final static String ABSENCES_PAGE = "/views/MenaxhimiMungesave.fxml";
    public final static String ADD_USER_PAGE = "/views/shtoUser.fxml";
    public final static String RESET_PASSWORD = "/views/rivendosFjalekalimin.fxml";
    public final static String TEACHER_PAGE = "/views/mesuesiView.fxml";
    public final static String STUDENT_PAGE = "/views/nxenesitView.fxml";
    public final static String HELP_PAGE = "/views/help.fxml";
    public final static String CLASS_MANAGEMENT_PAGE = "/views/MenaxhimiKlaseve.fxml";
    public final static String SUBJECT_MANAGEMENT_PAGE = "/views/MenaxhimiLendeve.fxml";
    public final static String TEACHER_MANAGEMENT_PAGE = "/views/MenaxhimiIMesuesit.fxml";
    public final static String STUDENT_MANAGEMENT_PAGE = "/views/MenaxhimiNxenesve.fxml";
    public final static String PRINCIPAL_MANAGEMENT_PAGE = "/views/MenaxhimiDrejtoreve.fxml";
    public final static String PRINCIPAL_STATISTICS_PAGE = "/views/StatistikatDrejtor.fxml";
    public static final String STUDENT_ABSENCES_PAGE = "/views/Mungesat.fxml";
    public final static String TEACHER_STATISTICS_PAGE = "/views/statistikaMesuesi.fxml";
   public final static String  STUDENT_GRADES_PAGE = "/views/NotatNxenesi.fxml";

    public static void locate(Event event, String form) {
        Node eventNode = (Node) event.getSource();
        Stage stage = (Stage) eventNode.getScene().getWindow();
        locate(stage, form);
    }

    public static void locate(javafx.scene.input.MouseEvent event, String form) {
        Node eventNode = (Node) event.getSource();
        Stage stage = (Stage) eventNode.getScene().getWindow();
        locate(stage, form);
    }


    public static void locate(Stage stage, String form) {
        Locale locale = Locale.getDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.Messages", locale);

        FXMLLoader loader = new FXMLLoader(SceneLocator.class.getResource(form), bundle);

        try {
            System.out.println("👉 Ngarkimi i pamjes: " + form);
            Pane formPane = loader.load();
            Scene newScene = new Scene(formPane);
            stage.setScene(newScene);
            stage.show();
        } catch (IOException ioe) {
            System.out.println("❌ Nuk mund të ngarkohet pamja: " + form);
            ioe.printStackTrace();
        }
    }


    public static void locate(Pane pane, String form) {
        Pane formPane = loadPane(form, Locale.getDefault());
        pane.getChildren().clear();
        pane.getChildren().add(formPane);
    }



    private static Pane loadPane(String form, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.Messages", locale);
        FXMLLoader loader = new FXMLLoader(SceneLocator.class.getResource(form), bundle);
        try {
            return loader.load();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
    }
}