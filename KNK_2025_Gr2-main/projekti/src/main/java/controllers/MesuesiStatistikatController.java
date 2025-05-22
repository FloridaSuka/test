package controllers;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.MenuButton;
import utils.LanguageHandler;
import utils.SceneLocator;

public class MesuesiStatistikatController {

    @FXML
    private LineChart<String, Number> lineChartKlasa;

    @FXML
    private LineChart<String, Number> lineChartGjinia;

    @FXML
    private MenuButton menuLanguage;

    @FXML
    public void initialize() {
        setupKlasaChart();
        setupGjiniaChart();
        LanguageHandler.configureLanguageMenu(menuLanguage, SceneLocator.HELP_PAGE);

    }

    private void setupKlasaChart() {
        CategoryAxis xAxis = (CategoryAxis) lineChartKlasa.getXAxis();
        NumberAxis yAxis = (NumberAxis) lineChartKlasa.getYAxis();

        xAxis.setLabel("Klasa");
        yAxis.setLabel("Numri i Nxënësve");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Nxënësit sipas klasës");

        // Shembull i dhënash
        series.getData().add(new XYChart.Data<>("Klasa 9", 48));
        series.getData().add(new XYChart.Data<>("Klasa 10", 42));
        series.getData().add(new XYChart.Data<>("Klasa 11", 53));
        series.getData().add(new XYChart.Data<>("Klasa 12", 39));

        lineChartKlasa.getData().clear();
        lineChartKlasa.getData().add(series);
    }

    private void setupGjiniaChart() {
        CategoryAxis xAxis = (CategoryAxis) lineChartGjinia.getXAxis();
        NumberAxis yAxis = (NumberAxis) lineChartGjinia.getYAxis();

        xAxis.setLabel("Gjinia");
        yAxis.setLabel("Numri i Nxënësve");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Nxënësit sipas gjinise");

        // Shembull i dhënash
        series.getData().add(new XYChart.Data<>("Mashkull", 102));
        series.getData().add(new XYChart.Data<>("Femër", 108));

        lineChartGjinia.getData().clear();
        lineChartGjinia.getData().add(series);
    }
}

