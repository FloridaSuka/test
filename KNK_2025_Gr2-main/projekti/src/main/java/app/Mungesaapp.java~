package app
        ;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Mungesaapp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Ngarkimi i skedarit FXML
            Parent root = FXMLLoader.load(getClass().getResource("/views/mungesa.fxml"));
            primaryStage.setTitle("Sistemi i Mungesave");
            primaryStage.setScene(new Scene(root, 1200, 800));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
