package controllers.pizzagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import management.Staff;

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
            failedText.setText("WRONG BITCH");
        }

    }

    public void switchToStaffView() throws IOException {
        Stage window = (Stage) username.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Staff-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle("Staff View");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

}