package controllers.pizzagui;
import customer_info.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static list.JsonController.*;

import java.io.IOException;

public class AddNewCustomerController {


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


    public void addNewCustomer(ActionEvent actionEvent) throws IOException {

        if (isFieldEmpty()) {
            setUpController("empty field");
        }
        else if(isDuplicate(phoneNumber.getText())){
            setUpController("duplicate customer");
        }

        else {
            customerAddress newAddress = new customerAddress(streetAddress.getText(),
                    cityName.getText(),
                    stateName.getText(),
                    zipCode.getText());
            customerCreditCard newCreditCard;
            Customer newCustomer;
            if (creditNumber.getText().equals("")) {
                newCustomer = new Customer(firstName.getText(),
                        lastName.getText(),
                        newAddress,
                        phoneNumber.getText(),
                        null);
            } else {
                newCreditCard = new customerCreditCard(nameOnCard.getText(),
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
                serializeCustomers();
                goBackToStaffScreen();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setUpController(String update) throws IOException {

        ////This get the fxml loader ready
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Add-New-Customer-View.fxml"));
        ////This preloads the next fxml
        Parent root = fxmlLoader.load();
        ////This grabs the controller being used in the current fxmlLoader
        AddNewCustomerController addNewCustomerController = fxmlLoader.getController();
        fxmlLoader.setController(addNewCustomerController);

        ////Line to change
        if(update.equals("empty field")) {
            addNewCustomerController.errorText.setText("Please do not leave fields blank");
        }
        else if(update.equals("duplicate customer")){
            addNewCustomerController.errorText.setText("Customer Already Exists");
        }

            /*
        This will restart the order menu page after pressing Add to Cart
         */
        Stage window = (Stage) firstName.getScene().getWindow();
        Scene scene = new Scene(root,900,600);
        window.setTitle("Staff-View.fxml");
        window.setScene(scene);
        window.setResizable(false);
        window.show();

    }



    public boolean isDuplicate(String newPhoneNumber) {
        for (Customer c : customerList) {
            if (c.getPhoneNumber().equals(newPhoneNumber)) {
                return true;
            }
        }
        return false;
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

    public void goBackToStaffScreen(ActionEvent actionEvent) throws IOException{
        changeView("Staff-View.fxml");
    }
    public void goBackToStaffScreen() throws IOException{
        changeView("Staff-View.fxml");
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


    public void logOut(ActionEvent actionEvent) throws IOException{
        changeView("Login-view.fxml");
    }



}