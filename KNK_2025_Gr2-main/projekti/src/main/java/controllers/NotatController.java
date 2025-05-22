package controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import models.Notat;
import models.dto.create.CreateNotat;
import repositories.LendaRepository;
import services.NotatService;
import utils.LanguageHandler;
import utils.MenuUtils;
import utils.SceneLocator;

public class NotatController {

    @FXML private TextField txtIdNxenesit, txtIdMesuesit, txtLenda, nota1, nota2;
    @FXML private ComboBox<String> cmbKlasa, cmbParalelja, cmbDrejtimi,comboPeriudha;
    @FXML private Label lblMesatarja, lblNotaFinale;
    @FXML private ListView<String> listaNotave;
    @FXML private ListView<String> raportiStatistik;

    private final LendaRepository lendaRepository = new LendaRepository();

    private final NotatService notatService = new NotatService();

    @FXML
    private MenuButton menuLanguage;

    @FXML
    public void initialize() {
        LanguageHandler.configureLanguageMenu(menuLanguage, SceneLocator.GRADE_MANAGEMENT_PAGE);
        mbushRaportinMeNotatNgaDatabaza();
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

    @FXML
    private void regjistroNota() {
        // Kontrollo nëse ndonjë fushë është bosh
        if (txtIdNxenesit.getText().isEmpty() || txtIdMesuesit.getText().isEmpty() ||
                txtLenda.getText().isEmpty() || nota1.getText().isEmpty() || nota2.getText().isEmpty() ||
                cmbDrejtimi.getValue() == null || cmbParalelja.getValue() == null || cmbKlasa.getValue() == null) {
            showAlert("Gabim", "Ju lutem plotësoni të gjitha fushat!");
            return;
        }

        try {
            int nxenesiId = Integer.parseInt(txtIdNxenesit.getText().trim());
            int mesuesiId = Integer.parseInt(txtIdMesuesit.getText().trim());
            String emriLendes = txtLenda.getText().trim();
            int lendaId = lendaRepository.getLendaIdByName(emriLendes);

            if (lendaId == 0) {
                showAlert("Gabim", "Lënda nuk u gjet në databazë.");
                return;
            }

            int notaPare = Integer.parseInt(nota1.getText().trim());
            int notaDyte = Integer.parseInt(nota2.getText().trim());
            int periudha = Integer.parseInt(comboPeriudha.getValue().trim());
            int drejtimiId = convertDrejtimiToId(cmbDrejtimi.getValue());
            int paraleljaId = convertParaleljaToId(cmbParalelja.getValue());
            int klasaId =convertKlasaToId(cmbKlasa.getValue());

            if (drejtimiId == 0 || paraleljaId == 0 || klasaId == 0) {
                showAlert("Gabim", "Vlerat e drejtimit, paraleles apo klasës janë të pavlefshme.");
                return;
            }

            // ✅ Krijimi i objektit për ruajtje
            CreateNotat nota = new CreateNotat(nxenesiId, lendaId, mesuesiId, drejtimiId,klasaId, paraleljaId, periudha,notaPare, notaDyte);
            boolean sukses = notatService.regjistroNota(nota);

            if (sukses) {
                showAlert("Sukses!", "Nota u ruajt me sukses!");

                shtoNeRaport(); // shton notën në raportin ListView
                raportiStatistik.getItems().add("✅ U regjistrua nota për nxënësin ID: " + txtIdNxenesit.getText());

                pastroFushat();
            } else {
                showAlert("Gabim!", "Dështoi ruajtja e notës.");
            }

        } catch (NumberFormatException e) {
            showAlert("Gabim në format", "Sigurohu që ID-të dhe notat janë numra të vlefshëm.");
        }
    }

    private void shtoNeRaport() {
        String raport = "Nxënësi ID: " + txtIdNxenesit.getText() +
                " | Lënda ID: " + txtLenda.getText() +
                " | Nota 1: " + nota1.getText() +
                " | Nota 2: " + nota2.getText();
        listaNotave.getItems().add(raport);
    }

    @FXML
    private void llogaritMesataren() {
        try {
            double n1 = Double.parseDouble(nota1.getText().trim());
            double n2 = Double.parseDouble(nota2.getText().trim());
            double mesatarja = (n1 + n2) / 2.0;

            lblMesatarja.setText(String.format("%.2f", mesatarja));

            String notaFinale;
            if (mesatarja >= 9) notaFinale = "10";
            else if (mesatarja >= 8) notaFinale = "9";
            else if (mesatarja >= 7) notaFinale = "8";
            else if (mesatarja >= 6) notaFinale = "7";
            else if (mesatarja >= 5) notaFinale = "6";
            else notaFinale = "5";

            lblNotaFinale.setText(notaFinale);

        } catch (NumberFormatException e) {
            showAlert("Gabim", "Ju lutem shkruani nota valide për të llogaritur mesataren.");
        }
    }

    @FXML
    private void pastroFushat() {
        txtIdNxenesit.clear();
        txtIdMesuesit.clear();
        txtLenda.clear();
        nota1.clear();
        nota2.clear();
        cmbDrejtimi.setValue(null);
        cmbParalelja.setValue(null);
        cmbKlasa.setValue(null);
        lblMesatarja.setText("");
        lblNotaFinale.setText("");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private int convertDrejtimiToId(String drejtimi) {
        return switch (drejtimi) {
            case "Shoqëror" -> 1;
            case "Natyror" -> 2;
            case "Ekonomik" -> 3;
            case "Teknik" -> 4;
            default -> 0;
        };
    }

    private int convertParaleljaToId(String paralelja) {
        return switch (paralelja) {
            case "A" -> 1;
            case "B" -> 2;
            case "C" -> 3;
            case "D" -> 4;
            case "E" -> 5;
            case "F" -> 6;
            default -> 0;
        };
    }
    private int convertKlasaToId(String klasa) {
        return switch (klasa) {
            case "10" -> 1;
            case "11" -> 2;
            case "12" -> 3;
            default -> 0;
        };
    }


    private void mbushRaportinMeNotatNgaDatabaza() {
        listaNotave.getItems().clear();

        for (Notat nota : notatService.merrTeGjithaNotat()) {
            String raport = "📄 Nxënës ID: " + nota.getNxenesi().getId() +
                    " | Lënda: " + nota.getLenda().getEmri() +
                    " | Nota 1: " + nota.getNotaPare() +
                    " | Nota 2: " + nota.getNotaDyte();
            listaNotave.getItems().add(raport);
        }
    }


}
