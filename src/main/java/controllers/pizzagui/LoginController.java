package controllers.pizzagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import management.Staff;

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
        }
        else{
            failedText.setText("WRONG BITCH");

        }

    }
}