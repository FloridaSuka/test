package utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MenuUtils {

//-------FILLIMI I MENU FILE
    //NEW
    public static void handleNew() {
        Stage stage = new Stage();
        SceneLocator.locate(stage, SceneLocator.ADD_USER_PAGE);
        stage.setTitle("Shto Përdorues të Ri");
        stage.show();
    }
    //Perfundimi NEW

    //Opsioni OPEN
    private static final Map<String, List<String>> allowedViewsPerScene = Map.ofEntries(
            Map.entry("AdminController", List.of("menaxhimiShkolles.fxml", "menaxhimiDrejtoreve.fxml")),
            Map.entry("MenaxhimiShkollesController", List.of("menaxhimiDrejtoreve.fxml")),
            Map.entry("MenaxhimiDrejtoreveController", List.of("menaxhimiShkolles.fxml")),

            Map.entry("DrejtoriController", List.of("MenaxhimiMesuesit.fxml", "MenaxhimiKlaseve.fxml", "MenaxhimiLendeve.fxml", "StatistikatDrejtor.fxml")),
            Map.entry("MenaxhimiIMesuesitController", List.of("MenaxhimiKlaseve.fxml", "MenaxhimiLendeve.fxml", "StatistikatDrejtor.fxml")),
            Map.entry("MenaxhimiKlaseveController", List.of("MenaxhimiMesuesit.fxml", "MenaxhimiLendeve.fxml", "StatistikatDrejtor.fxml")),
            Map.entry("MenaxhimiLendeveController", List.of("MenaxhimiMesuesit.fxml", "MenaxhimiKlaseve.fxml", "StatistikatDrejtor.fxml")),
            Map.entry("StatistikatDrejtorController", List.of("MenaxhimiMesuesit.fxml", "MenaxhimiKlaseve.fxml", "MenaxhimiLendeve.fxml")),


            Map.entry("MesuesiController", List.of("MenaxhimiNxenesve.fxml", "MenaxhimiINotave.fxml","MenaxhimiMungesave.fxml", "statistikaMesuesi.fxml")),
            Map.entry("NotatController", List.of("MenaxhimiNxenesve.fxml","MenaxhimiMungesave.fxml", "statistikaMesuesi.fxml")),
            Map.entry("MesuesiStatistikatController", List.of("MenaxhimiNxenesve.fxml", "MenaxhimiINotave.fxml","MenaxhimiMungesave.fxml")),
            Map.entry("MungesaController", List.of("MenaxhimiNxenesve.fxml", "MenaxhimiINotave.fxml", "statistikaMesuesi.fxml")),
            Map.entry("MenaxhimiNxenesveController", List.of("MenaxhimiINotave.fxml","MenaxhimiMungesave.fxml", "statistikaMesuesi.fxml")),

            Map.entry("NxenesiController", List.of("statistikaNxenesi.fxml", "Mungesat.fxml","" )),
            Map.entry("NxenesitStatistikatController", List.of("Mungesat.fxml","" )),
            Map.entry("NxenesMungesaController", List.of("statistikaNxenesi.fxml","" ))
    );

    public static void openConditionalView(String currentController, String fxmlName, String title) {
        List<String> allowedViews = allowedViewsPerScene.getOrDefault(currentController, List.of());

        if (allowedViews.contains(fxmlName)) {
            openView("/views/" + fxmlName, title);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Qasje e ndaluar");
            alert.setHeaderText(null);
            alert.setContentText("Nuk lejohet të hapet ky view nga ky rol.");
            alert.showAndWait();
        }
    }
    public static void openView(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(MenuUtils.class.getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showError("Gabim gjatë hapjes së view-it: " + fxmlPath);
        }
    }
    private static void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Gabim");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public static void populateOpenSubMenu(Menu openMenu, String controllerName) {
        openMenu.getItems().clear(); // pastro menynë ekzistuese

        List<String> views = allowedViewsPerScene.getOrDefault(controllerName, List.of());

        for (String view : views) {
            if (view == null || view.isBlank()) continue;

            // Titulli i shfaqur në meny
            String title = formatTitleFromFxml(view);

            MenuItem item = new MenuItem(title);
            item.setOnAction(e -> openConditionalView(controllerName, view, title));

            openMenu.getItems().add(item);
        }
    }
    private static String formatTitleFromFxml(String fxmlName) {
        return fxmlName
                .replace(".fxml", "")
                .replace("Menaxhimi", "Menaxhimi i")
                .replace("Statistikat", "Statistikat")
                .replace("statistika", "Statistika")
                .replaceAll("([A-Z])", " $1") // ndan fjalët në titull
                .trim();
    }
    //perfundimi OPEN


//PERFUNDIMI I MENUSE FILE
//FILLIMI I EDIT
public static void registerShortcuts(Scene scene) {
    scene.getAccelerators().put(
            new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN),
            () -> performUndo(scene)
    );
    scene.getAccelerators().put(
            new KeyCodeCombination(KeyCode.F4, KeyCombination.ALT_DOWN),
            () -> {
                System.exit(0);
            }
    );
    scene.getAccelerators().put(
            new KeyCodeCombination(KeyCode.Y, KeyCombination.CONTROL_DOWN),
            () -> performRedo(scene)
    );
    scene.getAccelerators().put(
            new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN),
            () -> handleNew()
    );

    scene.getAccelerators().put(
            new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN),
            () -> performCut(scene)
    );

    scene.getAccelerators().put(
            new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN),
            () -> performCopy(scene)
    );

    scene.getAccelerators().put(
            new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN),
            () -> performPaste(scene)
    );

    scene.getAccelerators().put(
            new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN),
            () -> performSelectAll(scene)
    );
}

    private static TextInputControl getFocusedTextInput(Scene scene) {
        if (scene.getFocusOwner() instanceof TextInputControl input) {
            return input;
        }
        return null;
    }

    public static void performUndo(Scene scene) {
        TextInputControl focused = getFocusedTextInput(scene);
        if (focused != null) focused.undo();
    }

    public static void performRedo(Scene scene) {
        TextInputControl focused = getFocusedTextInput(scene);
        if (focused != null) focused.redo();
    }

    public static void performCut(Scene scene) {
        TextInputControl focused = getFocusedTextInput(scene);
        if (focused != null) focused.cut();
    }

    public static void performCopy(Scene scene) {
        TextInputControl focused = getFocusedTextInput(scene);
        if (focused != null) focused.copy();
    }

    public static void performPaste(Scene scene) {
        TextInputControl focused = getFocusedTextInput(scene);
        if (focused != null) focused.paste();
    }

    public static void performSelectAll(Scene scene) {
        TextInputControl focused = getFocusedTextInput(scene);
        if (focused != null) focused.selectAll();
    }
//PERFUNDIMI I EDIT


//MENUJA HELP
    public static void openhelp() {
        Stage stage = new Stage();
        SceneLocator.locate(stage, SceneLocator.HELP_PAGE);
        stage.setTitle("Help");
        stage.show();
    }

}


