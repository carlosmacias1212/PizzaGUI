package controllers.pizzagui;

import customer_info.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import management.Manager;
import management.Staff;

import java.io.IOException;

public class ManagerViewController extends StaffViewController{

    public Staff employee;

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

    public void addEmployee() throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Add-New-Employee-View.fxml"));
        Parent root = fxmlLoader.load();
        AddNewEmployeeController addNewEmployeeController = fxmlLoader.getController();
        fxmlLoader.setController(addNewEmployeeController);

        addNewEmployeeController.setEmployee(getEmployee());

        addNewEmployeeController.displayName();

        Stage window = (Stage) label.getScene().getWindow();

        Scene scene = new Scene(root,900,600);
        window.setTitle("Add New Employee");
        window.setScene(scene);
        window.setResizable(false);
        window.show();

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

    public void updatePayment() throws IOException {

        if(custToRemove.getText().equals("")){
            customerLabel.setText("Enter customer number");
        }

        else if (Customer.isDuplicate(custToRemove.getText())){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Update-Payment-View.fxml"));
            Parent root = fxmlLoader.load();
            UpdatePayment updatePayment = fxmlLoader.getController();
            fxmlLoader.setController(updatePayment);

            updatePayment.setCurrentUser(getCurrentUser());
            updatePayment.setCustomerPhoneNumber(custToRemove.getText());
            updatePayment.setEmployee(getEmployee());
            updatePayment.displayName();

            Stage window = (Stage) label.getScene().getWindow();

            Scene scene = new Scene(root, 900, 600);
            window.setTitle("Update Payment");
            window.setScene(scene);
            window.setResizable(false);
            window.show();

        }
        else{
            customerLabel.setText("Customer does not exist");
        }
    }

    public void showOrderList() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Show-Orders-View.fxml"));
        Parent root = fxmlLoader.load();
        ShowOrdersController showOrdersController = fxmlLoader.getController();
        fxmlLoader.setController(showOrdersController);

        showOrdersController.setEmployee(getEmployee());
        showOrdersController.displayOrders();

        Stage window = (Stage) label.getScene().getWindow();

        Scene scene = new Scene(root, 900, 600);
        window.setTitle("Order List");
        window.setScene(scene);
        window.setResizable(false);
        window.show();

    }




}
