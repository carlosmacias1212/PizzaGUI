package controllers.pizzagui;

import customer_info.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.google.gson.*;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ManagerViewController extends StaffViewController{

    @FXML
    private Label label;

    private TextField employeeID;

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
