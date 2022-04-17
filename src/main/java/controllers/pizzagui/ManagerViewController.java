package controllers.pizzagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.google.gson.*;

public class ManagerViewController {

    @FXML
    private Label label;
    public void buttonManager(ActionEvent actionEvent) {
        label.setText("Okay i channge this with buttonn");
    }
}
