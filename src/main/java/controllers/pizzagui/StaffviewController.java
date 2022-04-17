package controllers.pizzagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.google.gson.*;

public class StaffviewController {

    @FXML
    private Label staffLabel;

    public void Button(ActionEvent actionEvent) {
        staffLabel.setText("New text after button press");
    }
}
