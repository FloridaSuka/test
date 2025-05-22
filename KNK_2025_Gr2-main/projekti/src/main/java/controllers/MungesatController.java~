package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Mungesa;
import services.MungesaService;

public class MungesatController {

    @FXML
    private TableView<Mungesa> tableMungesat;

    @FXML
    private TableColumn<Mungesa, Integer> colId, colLenda, colPerioda;

    @FXML
    private TableColumn<Mungesa, String> colStudent, colData, colArsyeja;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colStudent.setCellValueFactory(new PropertyValueFactory<>("student"));
        colLenda.setCellValueFactory(new PropertyValueFactory<>("lendaId"));
        colPerioda.setCellValueFactory(new PropertyValueFactory<>("periodaId"));
        colData.setCellValueFactory(new PropertyValueFactory<>("dataMungeses"));
        colArsyeja.setCellValueFactory(new PropertyValueFactory<>("arsyeja"));

        MungesaService service = new MungesaService();
        ObservableList<Mungesa> lista = FXCollections.observableArrayList(service.getMungesat());
        tableMungesat.setItems(lista);
    }
}
