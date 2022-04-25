package controllers.pizzagui;

import customer_info.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.google.gson.*;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import management.Staff;

import java.io.IOException;

public class ManagerViewController extends StaffViewController{



    private Staff employee;

    @FXML
    private Label orderType = new Label();

    @FXML
    private Label label;

    @FXML
    private Label currentUser;

    @FXML
    private Label failedText;
    @FXML
    private Label failedText1;
    @FXML
    private TextField custPhoneNumber;
    @FXML
    private Label currentCustomer = new Label();

    @FXML
    private RadioButton pickUp;
    @FXML
    private RadioButton delivery;
    public ToggleGroup toggleOrderType = new ToggleGroup();



    public void buttonManager(ActionEvent actionEvent) {
        label.setText("Okay i channge this with buttonn");
    }

    public void showCustomerList(){
    }

    public void removeCustomer() throws IOException {
        Customer.removeCustomer(getCustPhoneNumber().getText());
    }

    public void removeStaff() {

    }

    public void removeManager() {

    }




}
