package utils;

import javafx.application.Platform;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;
import utils.SceneLocator;

import java.util.Locale;

/**
 * Kjo klasë menaxhon ndërrimin e gjuhës dhe rifreskimin e skenës.
 */
public class LanguageHandler {

    /**
     * Konfiguron ndërrimin e gjuhës për një MenuButton dhe rifreskon skenën.
     * Përdor Platform.runLater për të pritur deri sa skena të jetë ngarkuar.
     *
     * @param menuButton MenuButton që përmban opsionet e gjuhës
     * @param page       Rruga e skedarit FXML në SceneLocator
     */
    public static void configureLanguageMenu(MenuButton menuButton, String page) {
        Platform.runLater(() -> {
            // ✅ Presim që skena të ngarkohet
            Stage stage = (Stage) menuButton.getScene().getWindow();

            // ✅ Konfigurimi i ndërrimit të gjuhës për çdo item në MenuButton
            menuButton.getItems().forEach(item -> {
                item.setOnAction(event -> {
                    String languageCode = item.getText().toLowerCase(); // "ENG" bëhet "eng"
                    if (languageCode.equals("alb")) {
                        languageCode = "al";
                    } else if (languageCode.equals("eng")) {
                        languageCode = "en";
                    }
                    changeLanguage(languageCode, stage, page);
                });
            });
        });
    }

    /**
     * Ndryshon gjuhën dhe rifreskon skenën.
     *
     * @param languageCode Kodi i gjuhës ("en" për anglisht, "al" për shqip)
     * @param stage        Stage që do të rifreskohet
     * @param page         Rruga e skenarit FXML në SceneLocator
     */
    private static void changeLanguage(String languageCode, Stage stage, String page) {
        Locale.setDefault(new Locale(languageCode));
        SceneLocator.locate(stage, page);
        System.out.println("✅ Gjuha u ndryshua në: " + languageCode.toUpperCase());
    }
}
