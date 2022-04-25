package controllers.pizzagui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import management.Order;
import management.Staff;

public class ConfirmationController {

    private Staff employee;
    private Order order;
    @FXML
    private Label currentUser;
    private Label totalPrice;

    public void submit(){
        // radio buttons for payment method
        // text box for cash given and change to be given
        // show success of payment/order
        // show receipt
    }

    public void displayName(){
        currentUser.setText("Hello " + employee.employeeType);
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
}
