package controllers.pizzagui;

import customer_info.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import management.Order;
import management.Staff;

import static list.JsonController.customerList;
import static list.JsonController.orderList;

import java.io.IOException;

public class ShowOrdersController {

    public Label sceneTitle;
    public VBox orderVbox;
    private Staff employee;

    public void displayOrders(){
        orderVbox.setSpacing(60);
        orderVbox.setAlignment(Pos.CENTER);


        for (Customer c : customerList) {
            String text = "";
            text += "Phone Number: " + c.getPhoneNumber() + "\n";
            text += "Delivery Information \n";
            text += "    Type:       Order Number: \n";

            for (Order o : orderList) {
                if (c.getPhoneNumber().equals(o.getCustomerPhoneNumber())) {
                    if (o.getOrderType().equals(true)) {
                        text += "    " + "pickup" + "        " + o.getOrderID()+"\n";
                    } else {
                        text += "    " + "delivery" + "      " + o.getOrderID()+"\n";
                    }
                }
            }
            text += "    " + "Address" + "      " + c.getAddress().toString()+"\n";

            Label newLabel = new Label();
            newLabel.setStyle("-fx-font-family: Arial");
            newLabel.setText(text);
            newLabel.setAlignment(Pos.CENTER);
            orderVbox.getChildren().add(newLabel);
            }

        /*

         */

    }

    public void goBackToStaffView(ActionEvent actionEvent) throws IOException {

        if(isManager()){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Manager-View.fxml"));
            Parent root = fxmlLoader.load();
            StaffViewController staffViewController = fxmlLoader.getController();
            fxmlLoader.setController(staffViewController);

            staffViewController.setEmployee(getEmployee());
            staffViewController.displayName();

            Stage window = (Stage) sceneTitle.getScene().getWindow();

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

            Stage window = (Stage) sceneTitle.getScene().getWindow();

            Scene scene = new Scene(root,900,600);
            window.setTitle("Staff View");
            window.setScene(scene);
            window.setResizable(false);
            window.show();
        }
    }
    //This takes us back to the original Manager view
    public void logOut(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) sceneTitle.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle("PieHackers Pizza Restaurant!");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }
    //This logs you out and send you back to the Login View
    public boolean isManager(){
        return employee.getEmployeeType().equals("Manager");
    }
    //Checks to see if the employee is of type manager
    public Staff getEmployee() {
        return employee;
    }
    //Getter for employee

    public void setEmployee(Staff employee) {
        this.employee = employee;
    }
    //Setter for employee
}
