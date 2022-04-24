package controllers.pizzagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import com.google.gson.*;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import management.Order;
import management.Staff;

import java.io.IOException;

public class StaffViewController {

    public ToggleGroup $orderType;
    private Staff employee;
    @FXML
    private String orderType;

    @FXML
    private Label label;

    @FXML
    private Label currentUser;

    @FXML
    private Label failedText;
    @FXML
    private TextField custPhoneNumber;

    @FXML
    private RadioButton pickUp;
    @FXML
    private RadioButton delivery;



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

        if (custPhoneNumber.getText().equals("")){
            failedText.setText("Please enter a phone number");
        }

        else {

            if(pickUp.isSelected()){
                setOrderType("Pick-up");
            }
            else{
                setOrderType("Delivery");
            }

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Order-Menu-View.fxml"));
            Parent root = fxmlLoader.load();
            OrderMenuController orderMenuController = fxmlLoader.getController();
            fxmlLoader.setController(orderMenuController);

            orderMenuController.setCurrentCustomer(custPhoneNumber.getText());
            orderMenuController.setOrderType(orderType);
            orderMenuController.setEmployee(employee);

//            orderMenuController.setCurrentCustomer(label1);
            orderMenuController.displayName();


            Stage window = (Stage) label.getScene().getWindow();
            Scene scene = new Scene(root, 900, 600);
            window.setTitle("Order Menu");
            window.setScene(scene);
            window.setResizable(false);
            window.show();
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
        currentUser.setText("Hello "+employee.employeeType);
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

    public String getOrderType(){
        return this.orderType;
    }

    public void setOrderType(String orderType){
        this.orderType = orderType;
    }
}
