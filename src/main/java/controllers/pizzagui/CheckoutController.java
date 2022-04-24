package controllers.pizzagui;

import food.FoodItems;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import management.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static list.JsonController.*;

public class CheckoutController {

    @FXML
    public Label label;
    private Order currentOrder = orderList.get(orderList.size() - 1);
    private List<FoodItems> cart = currentOrder.getCart();
    public ArrayList<Label> pizzas = new ArrayList<Label>();
    public ArrayList<Label> sides = new ArrayList<Label>();
    public ArrayList<Label> drinks = new ArrayList<Label>();


    public void populateLabels() {

        for (FoodItems item: cart) {
            if (item.getFoodName().equals("pizza")) {
                String type;

                if (item.getType().equals("Custom")) {
                    type = "Custom";
                } else {
                    type = item.getType();
                }

                pizzas.add(new Label(type));


            } else if (item.getFoodName().equals("side")) {
                String type = item.getType();
                pizzas.add(new Label(type));

            } else if (item.getFoodName().equals("drink")) {
                String type = item.getType();
                sides.add(new Label(type));
            }
        }

    }

    @FXML
    private VBox cartList = new VBox();

    @FXML void initialize() {

        populateLabels();

        Label pizza = new Label("PIZZAS");
        cartList.getChildren().add(pizza);



        for (Label p: pizzas) {
            System.out.println("yea");
            HBox hbox = new HBox();
            hbox.getChildren().add(p);
            cartList.getChildren().add(hbox);
        }

        Label Sides = new Label("SIDES");

        for (Label s: sides) {
            HBox hbox = new HBox();
            hbox.getChildren().add(s);
            cartList.getChildren().add(hbox);
        }


        Label Drinks = new Label("DRINKS");

        for (Label d: drinks) {
            HBox hbox = new HBox();
            hbox.getChildren().add(d);
            cartList.getChildren().add(hbox);
        }



    }




    public void goBackToStaffView(ActionEvent actionEvent) throws IOException {
        changeView("Order-Menu-View.fxml");
    }

    public void logOutButton(ActionEvent actionEvent) throws IOException {
        changeView("Login-view.fxml");

    }

    public void changeView(String viewName) throws IOException {
        Stage window = (Stage) label.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(viewName));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle(viewName);
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }
}
