package controllers.pizzagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import com.google.gson.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import management.Staff;

import java.io.IOException;

public class StaffViewController {

    private Staff employee;

    @FXML
    private Label label;

    @FXML
    private Label currentUser;
    private TextField custPhoneNumber;

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
        Stage window = (Stage) label.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Update-Customer-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle("Update Customer View");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

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
        currentUser.setText("Hello "+employee.employeeID);
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
}
