package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Adresa;
import services.AdresaService;

import java.util.List;

public class AdresaController {

    @FXML
    private TableView<Adresa> tableAdresat;

    @FXML
    private TableColumn<Adresa, Integer> colId;

    @FXML
    private TableColumn<Adresa, String> colQyteti;

    @FXML
    private TableColumn<Adresa, String> colRruga;

    @FXML
    private TableColumn<Adresa, String> colKodiPostar;

    private AdresaService adresaService;

    public AdresaController() {
        adresaService = new AdresaService();
    }


    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colQyteti.setCellValueFactory(new PropertyValueFactory<>("qyteti"));
        colRruga.setCellValueFactory(new PropertyValueFactory<>("rruga"));
        colKodiPostar.setCellValueFactory(new PropertyValueFactory<>("kodiPostar"));

        ObservableList<Adresa> lista = FXCollections.observableArrayList(adresaService.getAdresat());
        tableAdresat.setItems(lista);
    }


    public void displayAdresat() {
        List<Adresa> adresat = adresaService.getAdresat();
        for (Adresa adresa : adresat) {
            System.out.println("ID: " + adresa.getId() + ", Qyteti: " + adresa.getQyteti() +
                    ", Rruga: " + adresa.getRruga() + ", Kodi Postar: " + adresa.getKodiPostar());
        }
    }


    public void addAdresa(Adresa adresa) {
        adresaService.addAdresa(adresa);
        refreshTable();
        showAlert("Sukses", "Adresa është shtuar me sukses.", AlertType.INFORMATION);
    }


    public void updateAdresa(Adresa adresa) {
        adresaService.updateAdresa(adresa);
        refreshTable();
        showAlert("Sukses", "Adresa është përditësuar me sukses.", AlertType.INFORMATION);
    }


    public void deleteAdresa(int id) {
        adresaService.deleteAdresa(id);
        refreshTable();
        showAlert("Sukses", "Adresa është fshirë me sukses.", AlertType.INFORMATION);
    }


    private void refreshTable() {
        ObservableList<Adresa> lista = FXCollections.observableArrayList(adresaService.getAdresat());
        tableAdresat.setItems(lista);
    }


    private void showAlert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

