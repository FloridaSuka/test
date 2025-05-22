package controllers;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import models.User;
import repositories.NotatRepository;
import repositories.NxenesitRepository;
import services.UserService;
import utils.LanguageHandler;
import utils.MenuUtils;
import utils.SceneLocator;

public class NotatNxenesiController {

    @FXML
    private PieChart grafika;

    @FXML
    private Button btnRifresko;

    private NxenesitRepository nxenesiRepository = new NxenesitRepository();
    private NotatRepository notaRepository = new NotatRepository();

    private long currentNxenesiId;
    @FXML
    private MenuButton menuLanguage;

    @FXML
    public void initialize() {
        // Merr ID e nxenesit aktual (supozim: UserService ekziston)
        User user = UserService.getCurrentUser();
        if (user != null) {
            String email = user.getEmail();
            currentNxenesiId = nxenesiRepository.getNxenesiIdByEmail(email);
        } else {
            currentNxenesiId = 0; // ose ndonjë vlerë default, si -1
        }

        // Ngarko grafikën në fillim
        loadPieChartData();

        // Shto event në butonin Rifresko për rifreskim manual të grafikës
        btnRifresko.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadPieChartData();
            }
        });
        LanguageHandler.configureLanguageMenu(menuLanguage, SceneLocator.STUDENT_GRADES_PAGE);
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

    private void loadPieChartData() {
        if (currentNxenesiId <= 0) {
            grafika.getData().clear();
            return; // Nuk ka nxenes aktiv
        }

        grafika.getData().clear();

        // Përdor funksionin numriNotavePerNxenesin për nota 1-5
        for (int nota = 1; nota <= 5; nota++) {
            int count = notaRepository.numriNotavePerNxenesin(nota, currentNxenesiId);

            // Shto në PieChart vetëm nëse ka të dhëna
            if (count > 0) {
                PieChart.Data slice = new PieChart.Data("Nota " + nota, count);
                grafika.getData().add(slice);
            }
        }
    }
}
