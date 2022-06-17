package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import sample.model.DailyNotes;
import sample.model.MedicationCheckBox;
import sample.model.MedicationIntakeList;

import java.io.IOException;

public class Controller {
    private Scene scene;
    private DailyNotes dailyNotes = new DailyNotes();
    private MedicationIntakeList medicationList;
    @FXML TextArea notesTextField;
    @FXML VBox medicationIntakeList;

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @FXML
    void changeViewToOverviewMedication() throws IOException {
        scene.setRoot(FXMLLoader.load(getClass().getResource("views/overview-medication.fxml")));
        notesTextField.setText(dailyNotes.getNotesContent());
        for (MedicationCheckBox medicationCheckBox : medicationList.getMedicationCheckBoxList()) {
            AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPrefSize(200, 200);
            CheckBox checkBox = new CheckBox(medicationCheckBox.getMedicationName() + "&#10;" + medicationCheckBox.getDateAndAmount() + "&#10;");
            checkBox.setStyle("-fx-background-color: #F4D9D8;");
            checkBox.setTextFill(Paint.valueOf("#707070"));
            checkBox.setSelected(medicationCheckBox.getIsChecked());
            checkBox.setPadding(new Insets(15, 15, 15, 15));
            AnchorPane.setLeftAnchor(checkBox, 0.0);
            AnchorPane.setRightAnchor(checkBox, 0.0);
            AnchorPane.setTopAnchor(checkBox, 0.0);
            medicationIntakeList.getChildren().addAll(anchorPane);
        }

    }

    @FXML
    void changeViewToDailyTaskView() throws IOException {
        scene.setRoot(FXMLLoader.load(getClass().getResource("views/daily-task-view.fxml")));
    }

    @FXML
    void openNewMedicationPopup() throws IOException {
        scene.setRoot(FXMLLoader.load(getClass().getResource("views/new-medication-popup.fxml")));
    }

    @FXML
    void notesTextInputChanged(){
        dailyNotes.setNotesContent(notesTextField.getText());
    }
}
