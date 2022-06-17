package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;

import java.io.IOException;

public class Controller {
    private Scene scene;

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @FXML
    void changeViewToOverviewMedication() throws IOException {
        scene.setRoot(FXMLLoader.load(getClass().getResource("views/overview-medication.fxml")));
    }

    @FXML
    void changeViewToDailyTaskView() throws IOException {
        scene.setRoot(FXMLLoader.load(getClass().getResource("views/daily-task-view.fxml")));
    }

    @FXML
    void openNewMedicationPopup() throws IOException {
        scene.setRoot(FXMLLoader.load(getClass().getResource("views/new-medication-popup.fxml")));
    }
}
