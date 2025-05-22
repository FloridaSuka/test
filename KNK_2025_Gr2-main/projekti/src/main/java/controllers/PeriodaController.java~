package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Perioda;
import models.dto.create.CreatePerioda;
import models.dto.update.UpdatePerioda;

import java.net.URL;
import java.util.ResourceBundle;

public class PeriodaController implements Initializable {

    @FXML private TableView<Perioda> tablePerioda;
    @FXML private TableColumn<Perioda, Integer> colId;
    @FXML private TableColumn<Perioda, String> colEmri;
    @FXML private TableColumn<Perioda, String> colFillimi;
    @FXML private TableColumn<Perioda, String> colMbarimi;

    @FXML private TextField txtId, txtEmri, txtFillimi, txtMbarimi;

    private ObservableList<Perioda> periodat = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("idPerioda"));
        colEmri.setCellValueFactory(new PropertyValueFactory<>("emri"));
        colFillimi.setCellValueFactory(new PropertyValueFactory<>("dataFillimit"));
        colMbarimi.setCellValueFactory(new PropertyValueFactory<>("dataMbarimit"));

        tablePerioda.setItems(periodat);
    }

    @FXML
    private void shtoPerioda() {
<<<<<<< Updated upstream
        var dto = new CreatePerioda(
                txtEmri.getText(),
                txtFillimi.getText(),
                txtMbarimi.getText()
        );
=======
        try {
            var dto = new CreatePeriodaDTO(
                    txtEmri.getText(),
                    txtFillimi.getText(),
                    txtMbarimi.getText()
            );
>>>>>>> Stashed changes

            int id = periodat.size() + 1;
            Perioda p = Perioda.of(id, dto.getEmri(), dto.getDataFillimit(), dto.getDataMbarimit());
            periodat.add(p);
            pastroFushat();
        } catch (Exception e) {
            showAlert("Gabim", "Nuk u shtua periudha: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void perditesoPerioda() {
<<<<<<< Updated upstream
        int id = Integer.parseInt(txtId.getText());
        var dto = new UpdatePerioda(
                id,
                txtEmri.getText(),
                txtFillimi.getText(),
                txtMbarimi.getText()
        );
=======
        try {
            int id = Integer.parseInt(txtId.getText());
            var dto = new UpdatePeriodaDTO(
                    id,
                    txtEmri.getText(),
                    txtFillimi.getText(),
                    txtMbarimi.getText()
            );
>>>>>>> Stashed changes

            for (int i = 0; i < periodat.size(); i++) {
                if (periodat.get(i).getIdPerioda() == dto.getIdPerioda()) {
                    Perioda eRe = Perioda.of(dto.getIdPerioda(), dto.getEmri(), dto.getDataFillimit(), dto.getDataMbarimit());
                    periodat.set(i, eRe);
                    break;
                }
            }
            pastroFushat();
        } catch (Exception e) {
            showAlert("Gabim", "Nuk u përditësua periudha: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void fshijPerioda() {
        try {
            int id = Integer.parseInt(txtId.getText());
            periodat.removeIf(p -> p.getIdPerioda() == id);
            pastroFushat();
        } catch (Exception e) {
            showAlert("Gabim", "Nuk u fshi periudha: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void pastroFushat() {
        txtId.clear(); txtEmri.clear(); txtFillimi.clear(); txtMbarimi.clear();
    }

    private void showAlert(String title, String msg, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
