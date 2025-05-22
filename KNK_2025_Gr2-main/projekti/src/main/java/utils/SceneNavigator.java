package utils;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Stack;

public class SceneNavigator {

    private static final Stack<String> history = new Stack<>();
    public static final String LOGIN_PAGE = "/views/login.fxml";

    public static void initializeHistory(String initialPath) {
        if (!history.contains(initialPath)) {
            System.out.println("✅ Ruajtja e path-it fillestar në histori: " + initialPath);
            history.push(initialPath);
        }
    }

    // ✅ Ndërrimi i skenës me ResourceBundle përkrahur
    public static void switchScene(Node node, String path) {
        try {
            Locale locale = new Locale("al"); // ose Locale.getDefault()
            ResourceBundle bundle = ResourceBundle.getBundle("bundles.Messages", locale);

            Scene currentScene = node.getScene();
            if (currentScene != null) {
                Parent currentRoot = currentScene.getRoot();
                String currentPath = currentRoot.getId();

                if (currentPath == null) {
                    currentPath = path;
                    currentRoot.setId(path);
                }

                if (!history.contains(currentPath)) {
                    System.out.println("📌 Ruaj në histori: " + currentPath);
                    history.push(currentPath);
                }
            }

            System.out.println("📌 Historia e skenave: " + history);

            URL resource = SceneNavigator.class.getResource(path);
            if (resource == null) {
                System.out.println("❌ Skedari nuk u gjet: " + path);
                return;
            }

            FXMLLoader loader = new FXMLLoader(resource, bundle);
            Parent view = loader.load();
            view.setId(path);

            Scene scene = new Scene(view);
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

            System.out.println("✅ Skena u ngarkua me sukses: " + path);

        } catch (IOException e) {
            System.out.println("❌ Gabim gjatë ngarkimit të skenës: " + path);
            e.printStackTrace();
        }
    }

    // ✅ Kthimi prapa në histori
    public static void goBack(Node node) {
        try {
            System.out.println("📌 Historia aktuale: " + history);

            if (!history.isEmpty()) {
                String previousPath = history.pop();
                System.out.println("🔄 Duke u kthyer në: " + previousPath);

                URL resource = SceneNavigator.class.getResource(previousPath);
                if (resource == null) {
                    System.out.println("❌ Skedari nuk u gjet: " + previousPath);
                    return;
                }

                Locale locale = new Locale("al");
                ResourceBundle bundle = ResourceBundle.getBundle("bundles.Messages", locale);

                FXMLLoader loader = new FXMLLoader(resource, bundle);
                Parent view = loader.load();
                view.setId(previousPath);

                Scene scene = new Scene(view);
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setScene(scene);
                stage.show();

                System.out.println("✅ U kthye me sukses te: " + previousPath);
            } else {
                System.out.println("⚠️ Historia nuk ka më skena për t'u kthyer prapa.");
            }
        } catch (IOException e) {
            System.out.println("❌ Gabim gjatë kthimit prapa!");
            e.printStackTrace();
        }
    }

    // ✅ Funksioni për logout
    public static void logout(Node node) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Konfirmim");
        alert.setHeaderText("Dëshironi të dilni nga llogaria?");
        alert.setContentText("Kliko OK për të vazhduar, ose Cancel për të anuluar.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.out.println("👉 Po bëhet logout...");
            try {
                Locale locale = new Locale("al");
                ResourceBundle bundle = ResourceBundle.getBundle("bundles.Messages", locale);

                FXMLLoader loader = new FXMLLoader(SceneNavigator.class.getResource(LOGIN_PAGE), bundle);
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setScene(new Scene(loader.load()));
                stage.setTitle("EduMetrics - Login");
                stage.show();

                System.out.println("✅ U ridrejtua me sukses te faqja e login.");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("❌ Gabim gjatë ngarkimit të faqes së login.");
            }
        } else {
            System.out.println("🔄 Logout u anulua.");
        }
    }
}


