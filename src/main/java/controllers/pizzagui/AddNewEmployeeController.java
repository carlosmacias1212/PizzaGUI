package controllers.pizzagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import management.Manager;
import management.Staff;

import java.io.IOException;

public class AddNewEmployeeController {

    private Staff employee;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField password;

    @FXML
    private TextField employeeType;

    @FXML
    private TextField employeeID;

    @FXML
    private Text errorText;

    @FXML
    private Label currentUser;

    public void addNewEmployee(){
        if(isFieldEmpty()) {
            errorText.setText("Please do not leave fields blank");
        }

        else if(Staff.isDuplicate(employeeID.getText())) {
            errorText.setText("Employee already exists");
        }
        else {
            if(employeeType.getText().equalsIgnoreCase("Manager")){
                Manager.createNewManager(firstName.getText(),
                                            lastName.getText(),
                                            password.getText(),
                                            employeeID.getText());
            }
            else{
                Manager.createNewStaff(firstName.getText(),
                                        lastName.getText(),
                                        password.getText(),
                                        employeeID.getText());
            }
        }

    }


    public void logOut(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) firstName.getScene().getWindow();
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

            staffViewController.setEmployee(getEmployee());
            staffViewController.displayName();

            Stage window = (Stage) firstName.getScene().getWindow();

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

    public boolean isFieldEmpty() {
        if(firstName.getText().equals("")){
            return true;
        }
        else if(lastName.getText().equals("")){
            return true;
        }
        else if(password.getText().equals("")){
            return true;
        }
        else if(employeeType.getText().equals("")){
            return true;
        }
        else return employeeID.getText().equals("");
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
}
