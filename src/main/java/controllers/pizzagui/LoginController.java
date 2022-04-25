package controllers.pizzagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import list.JsonController;
import management.Staff;
import static list.JsonController.*;

import java.io.IOException;

public class LoginController {
    @FXML
    private Text failedText;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;


    @FXML
    protected void logIn(ActionEvent actionEvent) {
        Staff newStaff = new Staff();
        if(newStaff.loginVerification(username.getText(), password.getText())){
            failedText.setText("Right!");
            try {
                switchToStaffView();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else{

            failedText.setText("Please try again");
        }

    }

    public void switchToStaffView() throws IOException {

        if(isManager(username.getText())){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Manager-View.fxml"));
            Parent root = fxmlLoader.load();
            StaffViewController staffViewController = fxmlLoader.getController();
            fxmlLoader.setController(staffViewController);

            staffViewController.setEmployee(getStaff());
            staffViewController.displayName();

            Stage window = (Stage) username.getScene().getWindow();

            Scene scene = new Scene(root,900,600);
            window.setTitle("Manager View");
            window.setScene(scene);
            window.setResizable(false);
            window.show();
        }

        else {

            ////This get the fxml loader ready
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Staff-View.fxml"));
            ////This preloads the next fxml
            Parent root = fxmlLoader.load();
            ////This grabs the controller being used in the current fxmlLoader
            StaffViewController staffViewController = fxmlLoader.getController();
            ////This searches and returns a staff from the username
            Staff user = JsonController.searchAndReturn(username.getText());
            ////Sets employee attribute in the controller to the user here
            staffViewController.setEmployee(user);
            ////This sets the Current userName in the top lefthand corner

            staffViewController.displayName();

            Stage window = (Stage) username.getScene().getWindow();
            Scene scene = new Scene(root, 900, 600);
            window.setTitle("Staff View");
            window.setScene(scene);
            window.setResizable(false);
            window.show();
        }
    }

    public void devLogIn(ActionEvent actionEvent) throws IOException {
        username.setText("admin");
        password.setText("admin");
        switchToStaffView();
    }

    public boolean isManager(String username) {
        for(Staff staff : staffList){
            if(username.equals(staff.employeeID) && staff.getEmployeeType().equals("Manager")){
                return true;
            }
        }
        return false;
    }

    public Staff getStaff(){
        for(Staff staff : staffList){
            if(username.getText().equals(staff.employeeID)){
                return staff;
            }
        }
        return null;
    }
}