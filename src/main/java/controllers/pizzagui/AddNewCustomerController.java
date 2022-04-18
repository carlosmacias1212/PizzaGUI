package controllers.pizzagui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import com.google.gson.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddNewCustomerController {

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField streetNum;

    @FXML
    private TextField streetName;

    @FXML
    private TextField stateName;

    @FXML
    private TextField cityName;

    @FXML
    private TextField zipCode;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField creditNumber;

    @FXML
    private TextField ccvNumber;


    public void addNewCustomer(ActionEvent actionEvent) {
    }

    public void goBackToStaffScreen(ActionEvent actionEvent) throws IOException{
        Stage window = (Stage) firstName.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Staff-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle("Staff View");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public void logOut(ActionEvent actionEvent) throws IOException{
        Stage stg = (Stage) firstName.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        stg.setTitle("PieHackers Pizza Restaurant!");
        stg.setScene(scene);
        stg.setResizable(false);
        stg.show();
    }

    public void switchToStaffView() throws IOException {

    }
}
