package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {


    public void openHelloView() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo/hello-view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Hello View");
            stage.setScene(new Scene(root, 400, 300));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openMungesatView() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/mungesat.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Mungesat View");
            stage.setScene(new Scene(root, 800, 500));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
