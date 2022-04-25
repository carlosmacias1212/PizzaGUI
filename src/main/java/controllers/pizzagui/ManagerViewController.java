package controllers.pizzagui;

import customer_info.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import management.Manager;
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
    private TextField custToRemove;

    public TextField employeeToRemove;

    @FXML
    private Label currentCustomer = new Label();

    @FXML
    private Label staffLabel = new Label();

    @FXML
    private Label customerLabel = new Label();

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
        if(custToRemove.getText().equals("")){
            customerLabel.setText("Enter customer number");
        }
        else if(Customer.removeCustomer(custToRemove.getText())){
            customerLabel.setText("Customer has been removed");
        }
        else{
            customerLabel.setText("Customer does not exist");
        }
    }

    public void removeWorker() {
        if(employeeToRemove.getText().equals("")){
            staffLabel.setText("Enter employee ID");
        }
        else if(Manager.removeWorker(employeeToRemove.getText())){
            staffLabel.setText("Employee has been removed");
        }
        else{
            staffLabel.setText("Employee does not exist");
        }
    }






}
