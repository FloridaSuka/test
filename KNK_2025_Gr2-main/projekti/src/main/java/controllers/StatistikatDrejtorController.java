package controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import repositories.MesuesiRepository;
import repositories.MungesatRepository;
import repositories.NotatRepository;
import repositories.NxenesitRepository;
import utils.LanguageHandler;
import utils.MenuUtils;
import utils.SceneLocator;

public class StatistikatDrejtorController {

    @FXML
    private PieChart outerPieChart;

    @FXML
    private PieChart innerPieChart;

    @FXML
    private Button btnRifresko;

    @FXML
    private Label lblTotalNxenesit;

    @FXML
    private Label lblMesuesit;

    @FXML
    private Label lblMungesat;

    private final NotatRepository notatRepo = new NotatRepository();
    private final MungesatRepository mungesatRepo = new MungesatRepository();
    private final MesuesiRepository mesuesitRepo = new MesuesiRepository();
    private final NxenesitRepository nxenesitRepo = new NxenesitRepository();
    @FXML
    private MenuButton menuLanguage;

    @FXML
    public void initialize() {
        ngarkoGrafiket();
        btnRifresko.setOnAction(e -> ngarkoGrafiket());
        LanguageHandler.configureLanguageMenu(menuLanguage, SceneLocator.PRINCIPAL_STATISTICS_PAGE);
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

    private void ngarkoGrafiket() {
        // ------------------------- NOTAT -------------------------
        ObservableList<PieChart.Data> notat = FXCollections.observableArrayList(
                new PieChart.Data("Nota 1", notatRepo.numronNotat(1)),
                new PieChart.Data("Nota 2", notatRepo.numronNotat(2)),
                new PieChart.Data("Nota 3", notatRepo.numronNotat(3)),
                new PieChart.Data("Nota 4", notatRepo.numronNotat(4)),
                new PieChart.Data("Nota 5", notatRepo.numronNotat(5))
        );
        outerPieChart.setData(notat);
        outerPieChart.setLabelsVisible(true);
        outerPieChart.setLegendVisible(false);

        // ------------------------- MUNGESAT -------------------------
        ObservableList<PieChart.Data> mungesat = FXCollections.observableArrayList(
                new PieChart.Data("Mungesat-Meshkuj", mungesatRepo.numriMungesavePerGjinine("M")),
                new PieChart.Data("Mungesat-Femra", mungesatRepo.numriMungesavePerGjinine("F"))
        );

        ObservableList<PieChart.Data> mungesatNormalizuara = normalizo(mungesat);
        innerPieChart.setData(mungesatNormalizuara);
        innerPieChart.setLabelsVisible(true);
        innerPieChart.setLegendVisible(false);

        // ------------------------- VLERAT -------------------------
        int nxenesat = nxenesitRepo.merrNumrinENxenesve();
        lblTotalNxenesit.setText(String.valueOf(nxenesat));

        int mesueset = mesuesitRepo.merrNumrinEMesuesve();
        lblMesuesit.setText(String.valueOf(mesueset));

        int nrMungesat = mungesatRepo.numriMungesavePerGjinine("M") + mungesatRepo.numriMungesavePerGjinine("F");
        lblMungesat.setText(String.valueOf(nrMungesat));

        // ------------------------- STILIZIM + TOOLTIP -------------------------
        Platform.runLater(() -> {
            setPieColors(notat, new String[]{"#2980b9", "#27ae60", "#f1c40f", "#e67e22", "#c0392b"});
            setPieColors(mungesatNormalizuara, new String[]{"#1abc9c", "#e74c3c"});

            vendosTooltip(notat);
            vendosTooltip(mungesatNormalizuara);


        });
    }

    private ObservableList<PieChart.Data> normalizo(ObservableList<PieChart.Data> lista) {
        double total = lista.stream().mapToDouble(PieChart.Data::getPieValue).sum();
        ObservableList<PieChart.Data> normalizuar = FXCollections.observableArrayList();
        for (PieChart.Data d : lista) {
            double vleraNormale = (d.getPieValue() / total) * 100;
            normalizuar.add(new PieChart.Data(d.getName(), vleraNormale));
        }
        return normalizuar;
    }

    private void setPieColors(ObservableList<PieChart.Data> data, String[] colors) {
        for (int i = 0; i < data.size(); i++) {
            final PieChart.Data d = data.get(i);
            final String color = colors[i % colors.length];
            d.nodeProperty().addListener((obs, oldNode, newNode) -> {
                if (newNode != null) {
                    newNode.setStyle("-fx-pie-color: " + color + ";");
                }
            });
        }
    }

    private void vendosTooltip(ObservableList<PieChart.Data> data) {
        for (PieChart.Data d : data) {
            Tooltip tooltip = new Tooltip(d.getName() + ": " + String.format("%.1f", d.getPieValue()) + "%");
            Tooltip.install(d.getNode(), tooltip);
        }
    }


}


