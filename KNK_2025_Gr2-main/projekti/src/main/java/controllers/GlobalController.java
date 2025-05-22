package controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import utils.SceneNavigator;

public class GlobalController {
    public void handleGoBack(ActionEvent event) {
        System.out.println("🔄 Duke u kthyer prapa nga GlobalController...");
        SceneNavigator.goBack((Node) event.getSource());
    }
}
