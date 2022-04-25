package controllers.pizzagui;

import customer_info.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import management.Staff;

import java.io.IOException;

public class StaffViewController {


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



    @FXML
    public void createCustomerAccount(ActionEvent actionEvent) throws IOException{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Add-New-Customer-View.fxml"));
        Parent root = fxmlLoader.load();
        AddNewCustomerController addNewCustomerController = fxmlLoader.getController();
        fxmlLoader.setController(addNewCustomerController);

        addNewCustomerController.setEmployee(employee);
        addNewCustomerController.displayName();

        Stage window = (Stage) label.getScene().getWindow();

        Scene scene = new Scene(root,900,600);
        window.setTitle("Add Customer");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    @FXML
    public void updateCustomerInfo(ActionEvent actionEvent) throws IOException {

        if (custPhoneNumber.getText().equals("")){
            failedText.setText("Please enter a phone number");
        }

        else if (Customer.isDuplicate(custPhoneNumber.getText())) {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Update-Customer-View.fxml"));
            Parent root = fxmlLoader.load();
            UpdateCustomerController updateCustomerController = fxmlLoader.getController();
            fxmlLoader.setController(updateCustomerController);

            updateCustomerController.setEmployee(employee);
            updateCustomerController.setCurrentCustomer(currentCustomer);
            updateCustomerController.setCustomerToUpdate(Customer.getCustomer(custPhoneNumber.getText()));
            updateCustomerController.displayName();

            Stage window = (Stage) label.getScene().getWindow();
            Scene scene = new Scene(root, 900, 600);
            window.setTitle("Update Customer View");
            window.setScene(scene);
            window.setResizable(false);
            window.show();

        }

        else{
            failedText.setText("Customer does not exist");
        }
    }

    @FXML
    public void orderNow(ActionEvent actionEvent) throws IOException{

        if (custPhoneNumber.getText().equals("")){
            failedText.setText("Please enter a phone number");
        }
        else if (toggleOrderType.getSelectedToggle() == null){
            failedText1.setText("Please select order type");
        }

        else if (Customer.isDuplicate(custPhoneNumber.getText())) {

            currentCustomer.setText(custPhoneNumber.getText());

            if(toggleOrderType.getSelectedToggle().equals(pickUp)){
                orderType.setText("Pick-up");
            }
            else{
                orderType.setText("Delivery");
            }



            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Order-Menu-View.fxml"));
            Parent root = fxmlLoader.load();
            OrderMenuController orderMenuController = fxmlLoader.getController();
            fxmlLoader.setController(orderMenuController);

            orderMenuController.setEmployee(employee);
            orderMenuController.setCurrentCustomer(currentCustomer);
            orderMenuController.setOrderType(orderType);
            orderMenuController.displayName();


            Stage window = (Stage) label.getScene().getWindow();
            Scene scene = new Scene(root, 900, 600);
            window.setTitle("Order Menu");
            window.setScene(scene);
            window.setResizable(false);
            window.show();
        }

        else {
            failedText.setText("Customer does not exist");
        }
    }

    @FXML
    public void logOut(ActionEvent actionEvent) throws IOException{
        Stage window = (Stage) label.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle("PieHackers Pizza Restaurant!");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public void displayName(){
        currentUser.setText("Hello, "+employee.employeeType);
    }

    public Label getCurrentUser() {
        return currentUser;
    }

    public Staff getEmployee() {
        return employee;
    }

    public void setEmployee(Staff employee) {
        this.employee = employee;
    }

    public TextField getCustPhoneNumber() {
        return custPhoneNumber;
    }

    public void setCustPhoneNumber(TextField custPhoneNumber) {
        this.custPhoneNumber = custPhoneNumber;
    }

    public Label getOrderType(){
        return this.orderType;
    }

    public void setOrderType(Label orderType){
        this.orderType = orderType;
    }

    public Label getFailedText() {
        return failedText;
    }

    public void setFailedText(Label failedText) {
        this.failedText = failedText;
    }
}
