package controllers.pizzagui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import management.Order;
import management.Staff;

import java.util.ArrayList;

public class ReceiptController {

    public VBox receiptList;
    private Order order;

    private Staff employee;

    private ArrayList<Label> orderItems = new ArrayList<Label>();

    private Label currentUser;


    public void generate() {
        String[][] receipt = order.generateReceipt();

        for (int i = 0; i < receipt.length; i++) {

            HBox hbox = new HBox();
            Label fname = new Label(receipt[i][0]);
            fname.setStyle("-fx-font-family: 'Arial Rounded MT Bold'");

            Label type = new Label(" " + receipt[i][1] + "        " + receipt[i][2]);


            hbox.getChildren().add(fname);

            hbox.setAlignment(Pos.CENTER_LEFT);

            HBox hbox2 = new HBox();

            hbox2.getChildren().add(type);
            hbox2.setAlignment(Pos.CENTER_RIGHT);



            if (receipt[i][0] != null) {
                receiptList.getChildren().addAll(hbox, hbox2);
            }


        }



    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setEmployee(Staff employee) {
        this.employee = employee;
    }

    public void setCurrentUser(Label currentUser) {
        this.currentUser = currentUser;
    }

    public void displayName(){
        currentUser.setText("Hello, " + employee.employeeType);
//        currentCustomer.setText("Cust: " + currentCustomer.getText());
//        orderType.setText(orderType.getText() + " Order");

    }


}
