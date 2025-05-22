package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Drejtimi;
import services.DrejtimiService;

public class DrejtimiController {

    @FXML
    private TableView<Drejtimi> tableDrejtimet;

    @FXML
    private TableColumn<Drejtimi, Integer> colId, colShkollaId, colParaleljaId;

    @FXML
    private TableColumn<Drejtimi, String> colEmri;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colEmri.setCellValueFactory(new PropertyValueFactory<>("emri"));
        colShkollaId.setCellValueFactory(new PropertyValueFactory<>("shkollaId"));
        colParaleljaId.setCellValueFactory(new PropertyValueFactory<>("paraleljaId"));

        DrejtimiService service = new DrejtimiService();
        ObservableList<Drejtimi> lista = FXCollections.observableArrayList(service.getDrejtimet());
        tableDrejtimet.setItems(lista);
    }


    public void addDrejtimi(Drejtimi drejtimi) {
        DrejtimiService service = new DrejtimiService();
        service.addDrejtimi(drejtimi);
        refreshTable();
    }


    public void updateDrejtimi(Drejtimi drejtimi) {
        DrejtimiService service = new DrejtimiService();
        service.updateDrejtimi(drejtimi);
        refreshTable();
    }


    public void deleteDrejtimi(int id) {
        DrejtimiService service = new DrejtimiService();
        service.deleteDrejtimi(id);
        refreshTable();
    }

    private void refreshTable() {
        DrejtimiService service = new DrejtimiService();
        ObservableList<Drejtimi> lista = FXCollections.observableArrayList(service.getDrejtimet());
        tableDrejtimet.setItems(lista);
    }
}
