package controllers.pizzagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import com.google.gson.*;
import javafx.stage.Stage;
import management.Staff;
import java.io.IOException;

public class StaffViewController {
    private Staff employee;

    @FXML
    private Label label;

    @FXML
    private Label currentUser;

    // transitions current user to the "Add Customer" screen:
    // this will allow the current user to create/add new customers to the system:
    @FXML
    public void createCustomerAccount(ActionEvent actionEvent) throws IOException{
        Stage window = (Stage) label.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Add-New-Customer-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle("Add Customer");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    // transitions current user to the "Update Customer View" screen:
    // this allows the current user to update existing customer information within the system:
    @FXML
    public void updateCustomerInfo(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) label.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Update-Customer-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle("Update Customer View");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    // transitions the current user to the "Order Menu" screen:
    // the user will have access to all items available on the menu:
    @FXML
    public void orderNow(ActionEvent actionEvent) throws IOException{
        Stage window = (Stage) label.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Order-Menu-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle("Order Menu");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    // logs the current user out of the system and transitions back to the login screen:
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

    // displays the current user (according to the user's employeeID) on the upper left-hand of the screen:
    public void displayName(String userName){
        currentUser.setText("Hello "+employee.employeeID);
    }

    // getter method for currentUser:
    public Label getCurrentUser() {
        return currentUser;
    }

    // getter method for employee:
    public Staff getEmployee() {
        return employee;
    }

    // setter method for employee:
    public void setEmployee(Staff employee) {
        this.employee = employee;
    }
}