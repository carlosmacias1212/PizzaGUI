package controllers.pizzagui;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class OrderMenuController {
    @FXML
    public Label label;

    // GUI button implementation:
    public void sizeToggleButton(ActionEvent actionEvent) {
    }

    public void SpecialtyToggleButton(ActionEvent actionEvent) {
    }

    public void buildYourOwnButton(ActionEvent actionEvent) {
    }

    // transitions current user to the staff view screen:
    public void goBackToStaffView(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) label.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Staff-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle("Staff View");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }
}