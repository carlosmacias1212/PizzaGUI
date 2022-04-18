package controllers.pizzagui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.google.gson.*;
import javafx.scene.control.TextField;

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

    public void goBackToStaffScreen(ActionEvent actionEvent) {
    }

    public void logOut(ActionEvent actionEvent) {
    }
}
