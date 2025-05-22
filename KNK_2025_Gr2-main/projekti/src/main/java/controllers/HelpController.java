package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import utils.LanguageHandler;
import utils.MenuUtils;
import utils.SceneLocator;

public class HelpController {

    @FXML
    private TextArea txtContent;
    @FXML
    private MenuButton menuLanguage;

    @FXML
    public void initialize() {
        LanguageHandler.configureLanguageMenu(menuLanguage, SceneLocator.HELP_PAGE);
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
    private void showPerdorimi() {
        txtContent.setStyle("-fx-text-fill: #3498db; -fx-font-size: 14px;");
        txtContent.setText("""
                ✅ Si mund ta përdorim aplikacionin?
                
                Për të përdorur aplikacionin në mënyrë të plotë, ndiqni këto hapa:
                
                1️⃣ Plotëso fushat me të dhënat e nxënësit, lëndën dhe emrin e mësuesit.
                2️⃣ Vendos notat përkatëse në fushat "Nota 1" dhe "Nota 2".
                3️⃣ Zgjidh periudhën për të cilën po bëhet regjistrimi i notave.
                4️⃣ Kliko në "Llogarit Mesataren" për të parë mesataren dhe notën përfundimtare.
                5️⃣ Kliko në "Regjistro Notat" për t'i ruajtur në raport.
                6️⃣ Të gjitha notat e regjistruara do të shfaqen në seksionin e poshtëm të aplikacionit.
                7️⃣ Për të pastruar fushat dhe të fillosh regjistrimin e ri, kliko "Pastro Fushat".
                """);
    }

    @FXML
    private void showLlogaritja() {
        txtContent.setText("""
                ✅ Si bëhet llogaritja e statistikave?
                
                Sistemi automatikisht llogarit mesataren e dy notave që vendosen.
                
                - Mesatarja paraqitet në formatin decimal.
                - Nota përfundimtare rrumbullakoset automatikisht në numër të plotë.
                - Nëse ka gabime gjatë futjes së notave, sistemi shfaq mesazhe paralajmëruese.
                """);
    }

    @FXML
    private void showRegjistrimi() {
        txtContent.setText("""
                ✅ Si regjistrohen notat në sistem?
                
                Pasi të plotësohen të gjitha fushat me të dhënat përkatëse, kliko "Regjistro Notat".
                
                - Informacionet e nxënësit, mësuesit, lëndës dhe notat ruhen në listën e raporteve.
                - Secili regjistrim përmban datën dhe orën e saktë të regjistrimit.
                """);
    }

    @FXML
    private void showPastrimi() {
        txtContent.setText("""
                ✅ Si pastrohen fushat në aplikacion?
                
                Kur klikohet butoni "Pastro Fushat":
                
                - Të gjitha fushat e të dhënave fshihen.
                - Lista e raporteve mbetet e pandryshuar.
                - Mund të filloni një regjistrim të ri pa problem.
                """);
    }

    @FXML
    private void showShfaqja() {
        txtContent.setText("""
                ✅ Si mund të shfaqen raportet e regjistruara?
                
                Të gjitha notat e regjistruara me sukses shfaqen në seksionin e poshtëm të aplikacionit.
                
                - Mund të shikohen me datë dhe orë të regjistrimit.
                - Secili regjistrim paraqitet me detaje të plota për identifikim të saktë.
                """);
    }
}
