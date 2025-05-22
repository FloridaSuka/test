package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import models.User;
import repositories.MesuesiRepository;
import repositories.NotatRepository;
import services.UserService;
import utils.LanguageHandler;
import utils.MenuUtils;
import utils.SceneLocator;

public class StatistikatMesuesiController {

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private Label lblTotalNxenesit;

    @FXML
    private Label lblMesatare;

    private final NotatRepository notatRepository = new NotatRepository();

    @FXML
    private void onBtnRifreskoClicked() {
        initialize();
    }
    @FXML
    private MenuButton menuLanguage;

    @FXML
    public void initialize() {
        User user = UserService.getCurrentUser();
        LanguageHandler.configureLanguageMenu(menuLanguage, SceneLocator.TEACHER_STATISTICS_PAGE);

        if (user != null) {
            String email = user.getEmail();
            int mesuesiId = new MesuesiRepository().getMesuesiIdByEmail(email);

            if (mesuesiId > 0) {
                // Numri i nxënësve
                int nxenesat = notatRepository.numriNxenesvePerMesuesin(mesuesiId);
                lblTotalNxenesit.setText(String.valueOf(nxenesat));

                // Mesatarja e notave
                double mesatarja = notatRepository.mesatarjaNotavePerMesuesin(mesuesiId);
                lblMesatare.setText(String.format("%.2f", mesatarja));

                // Grafikët për nota sipas gjinisë dhe mesuesit
                XYChart.Series<String, Number> femaleSeries = new XYChart.Series<>();
                femaleSeries.setName("F");

                XYChart.Series<String, Number> maleSeries = new XYChart.Series<>();
                maleSeries.setName("M");

                for (int nota = 1; nota <= 5; nota++) {
                    int countF = notatRepository.numriNotavePerGjinineDheNoten(nota, "F", mesuesiId);
                    int countM = notatRepository.numriNotavePerGjinineDheNoten(nota, "M", mesuesiId);

                    femaleSeries.getData().add(new XYChart.Data<>(String.valueOf(nota), countF));
                    maleSeries.getData().add(new XYChart.Data<>(String.valueOf(nota), countM));
                }

                barChart.getData().clear();
                barChart.getData().addAll(femaleSeries, maleSeries);

                Platform.runLater(() -> {
                    Node title = barChart.lookup(".chart-title");
                    if (title != null) {
                        title.setStyle("-fx-text-fill: white;");
                    }

                    CategoryAxis xAxis = (CategoryAxis) barChart.getXAxis();
                    xAxis.setTickLabelFill(Color.WHITE);
                    Node xAxisLabel = xAxis.lookup(".axis-label");
                    if (xAxisLabel != null) {
                        xAxisLabel.setStyle("-fx-text-fill: white;");
                    }

                    NumberAxis yAxis = (NumberAxis) barChart.getYAxis();
                    yAxis.setTickLabelFill(Color.WHITE);
                    Node yAxisLabel = yAxis.lookup(".axis-label");
                    if (yAxisLabel != null) {
                        yAxisLabel.setStyle("-fx-text-fill: white;");
                    }

                    applyBarColors(femaleSeries, "#f28482");
                    applyBarColors(maleSeries, "#84a9f2");
                    updateLegendColors();
                });

            } else {
                System.out.println("Mesuesi me email " + email + " nuk u gjet.");
                lblTotalNxenesit.setText("0");
                lblMesatare.setText("0.00");
                barChart.getData().clear();
            }

        } else {
            System.out.println("User not found!");
            lblTotalNxenesit.setText("0");
            lblMesatare.setText("0.00");
            barChart.getData().clear();
        }
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

    private void applyBarColors(XYChart.Series<String, Number> series, String color) {
        for (XYChart.Data<String, Number> data : series.getData()) {
            Node node = data.getNode();
            if (node != null) {
                node.setStyle("-fx-bar-fill: " + color + ";");
            } else {
                Platform.runLater(() -> {
                    if (data.getNode() != null) {
                        data.getNode().setStyle("-fx-bar-fill: " + color + ";");
                    }
                });
            }
        }
    }

    private void updateLegendColors() {
        for (Node node : barChart.lookupAll(".chart-legend-item")) {
            if (node instanceof Label label && label.getGraphic() instanceof Region region) {
                String text = label.getText();
                label.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
                if ("F".equals(text)) {
                    region.setStyle("-fx-background-color: #f28482;");
                } else if ("M".equals(text)) {
                    region.setStyle("-fx-background-color: #84a9f2;");
                }
            }
        }
    }
}
