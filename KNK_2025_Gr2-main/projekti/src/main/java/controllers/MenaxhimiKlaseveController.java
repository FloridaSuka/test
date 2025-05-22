package controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Klasa;
import models.dto.create.CreateKlasa;
import services.KlasaService;
import utils.LanguageHandler;
import utils.SceneLocator;

import java.util.List;

public class MenaxhimiKlaseveController {

    @FXML
    private TextField txtNiveli, txtShkolla ,txtParalelja, txtProfesori, txtDrejtimi, txtId;



    @FXML
    private Button btnShto;

    private final KlasaService klasaService = new KlasaService();

    @FXML
    private MenuButton menuLanguage;

    @FXML
    public void initialize() {
        LanguageHandler.configureLanguageMenu(menuLanguage, SceneLocator.CLASS_MANAGEMENT_PAGE);

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNiveli.setCellValueFactory(new PropertyValueFactory<>("niveli"));
        colShkolla.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getShkolla().getEmri()));
        colParalelja.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getParalelja().getEmri()));
        colMesuesi.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().getMesuesi().getEmri() + " " + cellData.getValue().getMesuesi().getMbiemri()));
        colDrejtimi.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDrejtimi().getEmri()));

        mbushTabelen();

    }
    @FXML private TableView<Klasa> tabelaKlasave;
    @FXML private TableColumn<Klasa, Integer> colId;
    @FXML private TableColumn<Klasa, Integer> colNiveli;
    @FXML private TableColumn<Klasa, String> colShkolla;
    @FXML private TableColumn<Klasa, String> colParalelja;
    @FXML private TableColumn<Klasa, String> colMesuesi;
    @FXML private TableColumn<Klasa, String> colDrejtimi;


    @FXML
    private void shtoKlasa() {
        int shkollaId = klasaService.lookupId("shkolla", "emri", txtShkolla.getText());
        int paraleljaId = klasaService.lookupId("paralelja", "emri", txtParalelja.getText());
        int profesoriId = klasaService.lookupId("mesuesi", "emri", txtProfesori.getText());
        int drejtimiId = klasaService.lookupId("drejtimi", "emri", txtDrejtimi.getText());

        CreateKlasa klasa = new CreateKlasa(
                Integer.parseInt(txtNiveli.getText()),
                shkollaId, paraleljaId, profesoriId, drejtimiId
        );

        if (klasaService.shtoKlasa(klasa)) {




            mbushTabelen();

        } else {


        }
    }
    private void showAlert(Alert.AlertType alertType, String title, String header) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.showAndWait();
    }


    private void mbushTabelen() {
        List<Klasa> klasat = klasaService.gjejTeGjitha();
        ObservableList<Klasa> listaObservable = FXCollections.observableArrayList(klasat);
        tabelaKlasave.setItems(listaObservable);
    }


}
