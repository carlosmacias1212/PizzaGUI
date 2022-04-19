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


    public void sizeToggleButton(ActionEvent actionEvent) {
    }

    public void SpecialtyToggleButton(ActionEvent actionEvent) {
    }

    public void buildYourOwnButton(ActionEvent actionEvent) {
    }

    public void goBackToStaffView(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) label.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Staff-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle("Staff View");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public void logOutButton(ActionEvent actionEvent) {
    }

    public void addToOrder(ActionEvent actionEvent) {
    }


}
