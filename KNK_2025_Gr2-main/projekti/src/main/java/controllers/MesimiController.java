//package controllers;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//import models.Mesimi;
//import services.MesimiService;
//
//public class MesimiController {
//
//    @FXML
//    private TableView<Mesimi> mesimiTable;
//    @FXML
//    private TableColumn<Mesimi, Integer> lendaIdCol;
//    @FXML
//    private TableColumn<Mesimi, Integer> profesoriIdCol;
//    @FXML
//    private TableColumn<Mesimi, Integer> klasaIdCol;
//    @FXML
//    private TableColumn<Mesimi, Integer> drejtimiIdCol;
//
//    @FXML
//    private TextField lendaIdField;
//    @FXML
//    private TextField profesoriIdField;
//    @FXML
//    private TextField klasaIdField;
//    @FXML
//    private TextField drejtimiIdField;
//
//    private final MesimiService mesimiService = new MesimiService();
//
//    private final ObservableList<Mesimi> mesimiList = FXCollections.observableArrayList();
//
//    @FXML
//    public void initialize() {
//        // Lidh kolonat me fushat
//        lendaIdCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getLendaId()).asObject());
//        profesoriIdCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getProfesoriId()).asObject());
//        klasaIdCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getKlasaId()).asObject());
//        drejtimiIdCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getDrejtimiId()).asObject());
//
//        loadMesimet();
//    }
//
//    public void loadMesimet() {
//        mesimiList.setAll(mesimiService.getMesimet());
//        mesimiTable.setItems(mesimiList);
//    }
//
//    @FXML
//    public void addMesimi() {
//        try {
//            int lid = Integer.parseInt(lendaIdField.getText());
//            int pid = Integer.parseInt(profesoriIdField.getText());
//            int klid = Integer.parseInt(klasaIdField.getText());
//            int did = Integer.parseInt(drejtimiIdField.getText());
//
//            Mesimi mesimi = new Mesimi(lid, pid, klid, did);
//            mesimiService.addMesimi(mesimi);
//            loadMesimet();
//            clearFields();
//
//            showAlert(Alert.AlertType.INFORMATION, "Sukses", "Mesimi u shtua me sukses!");
//        } catch (NumberFormatException e) {
//            showAlert(Alert.AlertType.ERROR, "Gabim", "Ju lutem fusni ID të vlefshme!");
//        }
//    }
//
//    @FXML
//    public void deleteMesimi() {
//        Mesimi selected = mesimiTable.getSelectionModel().getSelectedItem();
//        if (selected != null) {
//            mesimiService.deleteMesimi(selected.getLendaId(), selected.getProfesoriId(),
//                    selected.getKlasaId(), selected.getDrejtimiId());
//            loadMesimet();
//            showAlert(Alert.AlertType.INFORMATION, "Fshirje", "Mesimi u fshi me sukses!");
//        } else {
//            showAlert(Alert.AlertType.WARNING, "Asnjë zgjedhje", "Zgjidh një rresht për fshirje.");
//        }
//    }
//
//    private void clearFields() {
//        lendaIdField.clear();
//        profesoriIdField.clear();
//        klasaIdField.clear();
//        drejtimiIdField.clear();
//    }
//
//    private void showAlert(Alert.AlertType type, String title, String message) {
//        Alert alert = new Alert(type);
//        alert.setTitle(title);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }
//}
//
