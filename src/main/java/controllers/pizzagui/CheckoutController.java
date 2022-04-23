package controllers.pizzagui;

import food.FoodItems;
import food.Pizza;
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


import static list.JsonController.orderList;

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
                if (item.getClass() == Pizza.class) {

                    String type = ((Pizza) item).getPizzaType();
                    pizzas.add(new Label(type));
                }
            }
        }

    }

    @FXML
    private VBox pizzaList = new VBox();

    @FXML void initialize() {

        Label pizza = new Label("Pizzas");
        pizzaList.getChildren().add(pizza);

        /*
        for (Label p: pizzas) {
            HBox hbox = new HBox();
            hbox.getChildren().add(p);
            pizzaList.getChildren().add(hbox);
        }

         */

    }




    public void goBackToStaffView(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) label.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Order-Menu-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle("Staff View");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public void logOutButton(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) label.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle("PieHackers Pizza Restaurant!");
        window.setScene(scene);
        window.setResizable(false);
        window.show();

    }


}
