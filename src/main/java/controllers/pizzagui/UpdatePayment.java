package controllers.pizzagui;

import customer_info.Customer;
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

import static list.JsonController.customerList;
import static list.JsonController.serializeCustomers;

public class UpdatePayment {

    private Staff employee;
    private String customerPhoneNumber;

    @FXML
    private TextField nameOnCard;
    @FXML
    private TextField cardNumber;
    @FXML
    private TextField securityCode;
    @FXML
    private TextField expDate;
    @FXML
    private Text errorText;
    @FXML
    private Label currentUser;

    public void update(ActionEvent actionEvent) {
        customerCreditCard cc = new customerCreditCard(nameOnCard.getText(), cardNumber.getText(), securityCode.getText(), expDate.getText());

        for (Customer c : customerList){
            if (c.getPhoneNumber().equals(getCustomerPhoneNumber())){
                c.setCreditCard(cc);
                serializeCustomers();
            }
        }
    }

    public void logOut(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) nameOnCard.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle("PieHackers Pizza Restaurant!");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public void goBackToStaffView(ActionEvent actionEvent) throws IOException {

        if(isManager()){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Manager-View.fxml"));
            Parent root = fxmlLoader.load();
            StaffViewController staffViewController = fxmlLoader.getController();
            fxmlLoader.setController(staffViewController);

            staffViewController.setEmployee(getEmployee());
            staffViewController.displayName();

            Stage window = (Stage) nameOnCard.getScene().getWindow();

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

            staffViewController.setEmployee(getEmployee());
            staffViewController.displayName();

            Stage window = (Stage) nameOnCard.getScene().getWindow();

            Scene scene = new Scene(root,900,600);
            window.setTitle("Staff View");
            window.setScene(scene);
            window.setResizable(false);
            window.show();
        }
    }

    public boolean isManager(){
        return employee.getEmployeeType().equals("Manager");
    }

    public Staff getEmployee() {
        return employee;
    }

    public void setEmployee(Staff employee) {
        this.employee = employee;
    }

    public Label getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Label currentUser) {
        this.currentUser = currentUser;
    }

    public void displayName(){
        currentUser.setText("Hello, "+employee.employeeType);
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }
}
