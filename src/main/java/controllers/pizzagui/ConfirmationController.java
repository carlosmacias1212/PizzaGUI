package controllers.pizzagui;

import food.FoodItems;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import management.Order;
import management.Staff;
import static list.JsonController.serializeOrders;
import static list.JsonController.orderList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConfirmationController {

    @FXML
    public Label failedText;
    @FXML
    public TextField moneyGiven;
    public Label failedText1;

    public ToggleGroup payGroup;
    private float customerCash;

    private Staff employee;
    private Order order;
    private List<FoodItems> cart = new ArrayList<>();
    @FXML
    private Label currentUser;
    private Label totalPrice;
    @FXML
    private RadioButton cash;
    @FXML
    private RadioButton check;
    @FXML
    private RadioButton card;

    public void submit(){

        // radio buttons for payment method
        if(payGroup.getSelectedToggle() == null){

            failedText.setText("Please select payment type");

        }

        else{

            if(payGroup.getSelectedToggle().equals(cash)){
                order.setPayment("Cash Payment");

                if(moneyGiven.getText().equals("")){
                    failedText.setText("Collect Payment");
                }
                else{
                    customerCash = Float.parseFloat(moneyGiven.getText());

                    if(customerCash < Float.parseFloat(totalPrice.getText())){
                        failedText.setText("Not enough money given");
                    }
                    else {
                        failedText.setText("Give customer $" + calcChange() + " for change");
                        failedText1.setText("Payment Successful");
                        orderList.add(order);
                        serializeOrders();
                        try {
                            logOut();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            else if (payGroup.getSelectedToggle().equals(check)){
                order.setPayment("Check Payment");

                if(moneyGiven.getText().equals("")){
                    failedText.setText("Collect Payment");
                }
                else{
                    customerCash = Float.parseFloat(moneyGiven.getText());
                    if(customerCash < Float.parseFloat(totalPrice.getText())){
                        failedText.setText("Check is less than total price");
                    }
                    else {
                        failedText.setText("Give customer $" + calcChange() + " for change");
                        failedText1.setText("Payment Successful, $30 fee if check bounces");
                        orderList.add(order);
                        serializeOrders();
                        try {
                            logOut();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            else{
                order.setPayment("Card Payment");
                failedText.setText("Payment Successful");
                orderList.add(order);
                serializeOrders();
                try {
                    logOut();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // show receipt method
    }

    public void logOut() throws IOException {
        changeView("Login-view.fxml");

    }

    public float calcChange(){
        return customerCash - Float.parseFloat(totalPrice.getText());
    }

    public void changeView(String viewName) throws IOException {
        Stage window = (Stage) failedText.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(viewName));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle("PieHackers Pizza Restaurant!");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public void goBackToCheckout(ActionEvent actionEvent) throws IOException {

        if(isManager()){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Checkout-View.fxml"));
            Parent root = fxmlLoader.load();
            CheckoutController checkoutController = fxmlLoader.getController();
            fxmlLoader.setController(checkoutController);

            checkoutController.setEmployee(getEmployee());
            checkoutController.setTotalPrice(getTotalPrice());
            checkoutController.setOrder(getOrder());
            checkoutController.setFoodList(getFoodList());
            checkoutController.setCurrentUser(getCurrentUser());

            checkoutController.start();
            checkoutController.displayName();

//            Stage window = (Stage) failedText.getScene().getWindow();
            Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            Scene scene = new Scene(root,900,600);
            window.setTitle("Check Out");
            window.setScene(scene);
            window.setResizable(false);
            window.show();
        }

//        If it's a staff logged in, go back to staff view
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Checkout-View.fxml"));
            Parent root = fxmlLoader.load();
            CheckoutController checkoutController = fxmlLoader.getController();
            fxmlLoader.setController(checkoutController);

            checkoutController.setEmployee(getEmployee());
            checkoutController.setTotalPrice(getTotalPrice());
            checkoutController.setOrder(getOrder());
            checkoutController.setFoodList(getFoodList());
            checkoutController.setCurrentUser(getCurrentUser());

            checkoutController.start();
            checkoutController.displayName();

            Stage window = (Stage) failedText.getScene().getWindow();

            Scene scene = new Scene(root,900,600);
            window.setTitle("Check Out");
            window.setScene(scene);
            window.setResizable(false);
            window.show();
        }
    }

    public boolean isManager(){
        return employee.getEmployeeType().equals("Manager");
    }

    public void displayName(){
        System.out.println(employee.employeeType);

        currentUser.setText("Hello, " + employee.employeeType);
        failedText1.setText("Total Price: $" + totalPrice.getText());
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Label getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Label currentUser) {
        this.currentUser = currentUser;
    }

    public Staff getEmployee() {
        return employee;
    }

    public void setEmployee(Staff employee) {
        this.employee = employee;
    }

    public Label getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Label totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<FoodItems> getFoodList() {
        return cart;
    }

    public void setFoodList(List<FoodItems> foodList) {
        this.cart = foodList;
    }
}
