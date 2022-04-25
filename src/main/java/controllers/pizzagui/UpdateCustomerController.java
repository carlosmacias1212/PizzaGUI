package controllers.pizzagui;
import customer_info.Customer;
import customer_info.customerAddress;
import customer_info.customerCreditCard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import management.Staff;

import java.io.IOException;

import static list.JsonController.*;

public class UpdateCustomerController {

    Customer customerToUpdate;

    private Staff employee;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField streetAddress;

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

    @FXML
    private TextField cardExpiration;

    @FXML
    private TextField nameOnCard;
    @FXML
    private Text errorText;

    @FXML
    private Label currentUser;

    @FXML
    private Label currentCustomer;

    public void updateCustomer(ActionEvent actionEvent) throws IOException {

        if (isFieldEmpty()) {
            setUpController("empty field");
        }
//        else if(Customer.isDuplicate(phoneNumber.getText())){
//            setUpController("duplicate customer");
//        }

        else {

//            Customer customerToUpdate = Customer.getCustomer(currentCustomer.getText());

            customerAddress newAddress = new customerAddress(streetAddress.getText(),
                                                                cityName.getText(),
                                                                stateName.getText(),
                                                                zipCode.getText());
            customerCreditCard newCreditCard = new customerCreditCard(nameOnCard.getText(),
                                                                        creditNumber.getText(),
                                                                        ccvNumber.getText(),
                                                                        cardExpiration.getText());
            if (creditNumber.getText().equals("")) {
                customerToUpdate.setFirstName(firstName.getText());
                customerToUpdate.setLastName(lastName.getText());
                customerToUpdate.setAddress(newAddress);
                customerToUpdate.setPhoneNumber(phoneNumber.getText());
            }
            else {
                customerToUpdate.setFirstName(firstName.getText());
                customerToUpdate.setLastName(lastName.getText());
                customerToUpdate.setAddress(newAddress);
                customerToUpdate.setPhoneNumber(phoneNumber.getText());
                customerToUpdate.setCreditCard(newCreditCard);
            }

            try {
                serializeCustomers();
                backToRightStaffScreen();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setTextBoxes(){

    }
    public void setUpController(String update) throws IOException {

        if(isManager()){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Update-Customer-View.fxml"));
            Parent root = fxmlLoader.load();
            UpdateCustomerController updateCustomerController = fxmlLoader.getController();
            fxmlLoader.setController(updateCustomerController);

            if(update.equals("empty field")) {
                updateCustomerController.errorText.setText("Please do not leave fields blank");
            }
            else if(update.equals("duplicate customer")){
                updateCustomerController.errorText.setText("Customer Already Exists");
            }

            updateCustomerController.setEmployee(employee);
            updateCustomerController.setCurrentCustomer(currentCustomer);
            updateCustomerController.displayName();

            Stage window = (Stage) firstName.getScene().getWindow();

            Scene scene = new Scene(root,900,600);
            window.setTitle("Update Customer");
            window.setScene(scene);
            window.setResizable(false);
            window.show();
        }

//        If it's a staff logged in, go back to staff view
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Update-Customer-View.fxml"));
            Parent root = fxmlLoader.load();
            UpdateCustomerController updateCustomerController = fxmlLoader.getController();
            fxmlLoader.setController(updateCustomerController);

            if(update.equals("empty field")) {
                updateCustomerController.errorText.setText("Please do not leave fields blank");
            }
            else if(update.equals("duplicate customer")){
                updateCustomerController.errorText.setText("Customer Already Exists");
            }

            updateCustomerController.setEmployee(employee);
            updateCustomerController.setCurrentCustomer(currentCustomer);
            updateCustomerController.displayName();

            Stage window = (Stage) firstName.getScene().getWindow();

            Scene scene = new Scene(root,900,600);
            window.setTitle("Update Customer");
            window.setScene(scene);
            window.setResizable(false);
            window.show();
        }
    }

    public void goBackToStaffScreen(ActionEvent actionEvent) throws IOException{
//        If it's a manager logged in, go back to manager view
        backToRightStaffScreen();
    }

    //    for the back button
    public void goBackToStaffScreen() throws IOException{
        //        If it's a manager logged in, go back to manager view
        backToRightStaffScreen();

    }

    public void backToRightStaffScreen() throws IOException {

        if(isManager()){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Manager-View.fxml"));
            Parent root = fxmlLoader.load();
            StaffViewController staffViewController = fxmlLoader.getController();
            fxmlLoader.setController(staffViewController);

            staffViewController.setEmployee(employee);
//            staffViewController.displayName();

            Stage window = (Stage) firstName.getScene().getWindow();

            Scene scene = new Scene(root,900,600);
            window.setTitle("Manager View");
            window.setScene(scene);
            window.setResizable(false);
            window.show();
        }

//        If it's a staff logged in, go back to staff view
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Staff-View.fxml"));
            Parent root = fxmlLoader.load();
            StaffViewController staffViewController = fxmlLoader.getController();
            fxmlLoader.setController(staffViewController);

            staffViewController.setEmployee(employee);
//            staffViewController.displayName();

            Stage window = (Stage) firstName.getScene().getWindow();

            Scene scene = new Scene(root,900,600);
            window.setTitle("Staff View");
            window.setScene(scene);
            window.setResizable(false);
            window.show();
        }
    }

    public void logOut(ActionEvent actionEvent) throws IOException{
        changeView("Login-view.fxml");
    }

    public void changeView(String viewName) throws IOException {
        Stage window = (Stage) firstName.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(viewName));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle(viewName);
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public boolean isManager(){
        return employee.getEmployeeType().equals("Manager");
    }

    public boolean isFieldEmpty() {
        if(firstName.getText().equals("")){
            return true;
        }
        else if(lastName.getText().equals("")){
            return true;
        }
        else if(streetAddress.getText().equals("")){
            return true;
        }
        else if(cityName.getText().equals("")){
            return true;
        }
        else if(stateName.getText().equals("")){
            return true;
        }
        else if(zipCode.getText().equals("")){
            return true;
        }
        else return phoneNumber.getText().equals("");
    }

    public Staff getEmployee() {
        return employee;
    }

    public void setEmployee(Staff employee) {
        this.employee = employee;
    }

    public void displayName(){
        currentUser.setText("Hello, "+employee.employeeType);
    }

    public Label getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Label currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public Customer getCustomerToUpdate() {
        return customerToUpdate;
    }

    public void setCustomerToUpdate(Customer customerToUpdate) {
        this.customerToUpdate = customerToUpdate;
    }
}
