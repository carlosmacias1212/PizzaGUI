package controllers.pizzagui;
import customer_info.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import com.google.gson.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import list.JsonController;
import static list.JsonController.*;

import java.io.IOException;

public class AddNewCustomerController {


    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField streetNum;

    @FXML
    private TextField streetName;

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




    public void addNewCustomer(ActionEvent actionEvent) {
        customerAddress newAddress = new customerAddress(streetNum.getText()+" "+streetName.getText(),
                                                         cityName.getText(),
                                                         stateName.getText(),
                                                         zipCode.getText());
        customerCreditCard newCreditCard;
        Customer newCustomer;
        if(creditNumber.getText() == null) {
            newCustomer = new Customer(firstName.getText(),
                                                lastName.getText(),
                                                newAddress,
                                                phoneNumber.getText(),
                                       null);
        }
        else {
            newCreditCard = new customerCreditCard(firstName.getText(),
                                                   creditNumber.getText(),
                                                   ccvNumber.getText(),
                                                   cardExpiration.getText());

            newCustomer = new Customer(firstName.getText(),
                                       lastName.getText(),
                                       newAddress,
                                       phoneNumber.getText(),
                                       newCreditCard);
        }

        customerList.add(newCustomer);
        try {
            serializeACustomerList();
            goBackToStaffScreen();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void goBackToStaffScreen(ActionEvent actionEvent) throws IOException{
        Stage window = (Stage) firstName.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Staff-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle("Staff View");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }
    public void goBackToStaffScreen() throws IOException{
        Stage window = (Stage) firstName.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Staff-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle("Staff View");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public void logOut(ActionEvent actionEvent) throws IOException{
        Stage stg = (Stage) firstName.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        stg.setTitle("PieHackers Pizza Restaurant!");
        stg.setScene(scene);
        stg.setResizable(false);
        stg.show();
    }

}
