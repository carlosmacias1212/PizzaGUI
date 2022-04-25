package controllers.pizzagui;

import food.BYO;
import food.Drink;
import food.FoodItems;
import food.Pizza;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import management.Order;
import management.Staff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static list.JsonController.*;

public class CheckoutController {

    Staff employee;

    Order order;

    @FXML
    private Label currentUser;

    private List<FoodItems> foodList = new ArrayList<>();

    @FXML
    public Label label;
    private Order currentOrder = orderList.get(orderList.size() - 1);
    private List<FoodItems> cart = currentOrder.getCart();

    private List<FoodItems> cartView = new ArrayList<FoodItems>();
    public ArrayList<Label> pizzas = new ArrayList<Label>();
    public ArrayList<Label> sides = new ArrayList<Label>();
    public ArrayList<Label> drinks = new ArrayList<Label>();


    public void populateLabels() {

        for (FoodItems item: cart) {

            //Skip if item type is already an entry in cart
            if (isRepeat(item)) {
                continue;
            }


            String desc="";

            if (item.getFoodName().equals("pizza")) {

                String type;
                String size;

                if (item.getType().equals("Custom")) {
                    type = "Custom";
                    size = ((BYO) item).getSize();
                } else {
                    type = item.getType();
                    size = ( (Pizza) item).getSize();

                    desc = size + "     " + type;

                }

                cartView.add(item);
                pizzas.add(new Label(desc));



            } else if (item.getFoodName().equals("side")) {
                String type = item.getType();
                cartView.add(item);
                sides.add(new Label(type));

            } else if (item.getFoodName().equals("drink")) {
                String type = item.getType();
                cartView.add(item);
                drinks.add(new Label(type));
            }
        }

    }


    //Only want one label per specific type of food item (ex. small cheese)
    private Boolean isRepeat(FoodItems foodType) {
        for (FoodItems f: cartView) {
            if (foodType.getFoodName().equals("pizza")) {
                if (foodType.getType().equals("Custom")) {
                    if (sameCustom((BYO) f, (BYO) foodType)) {
                        return true;
                    }
                } else {

                    Pizza p1 = (Pizza) f;
                    Pizza p2 = (Pizza) foodType;
                    if (p1.getType().equals(p2.getType()) && p1.getSize().equals(p2.getSize())) {
                        return true;
                    }
                }
            } else if (foodType.getFoodName().equals("side")) {
                if (f.getType().equals(foodType.getType())) {
                    return true;
                }
            } else if (foodType.getFoodName().equals("drink")) {
                if (f.getType().equals(foodType.getType())) {
                    if (((Drink) f).getDrinkType().equals(((Drink) foodType).getDrinkType())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private Boolean sameCustom(BYO custom1, BYO custom2) {

        if (
                custom1.getCheese().equals(custom2.getCheese()) &&
                        custom1.getSauce().equals(custom2.getSauce()) &&
                        custom1.getSize().equals(custom2.getSize()) &&
                        custom1.getCrustType().equals(custom2.getCrustType())
        ) {

        } else {
            return false;
        }


        if (custom1.getToppings().size() != custom2.getToppings().size()) {
            return false;
        }


        int toppingMatches = 0;
        for (String topping: custom1.getToppings()) {
            for (String findTopping: custom2.getToppings()) {
                if (topping.equals(findTopping)) {
                    toppingMatches++;
                    break;
                }
            }
        }

        if (toppingMatches != custom1.getToppings().size()) {
            return false;
        }

        return true;
    }

    @FXML
    private VBox cartList = new VBox();

    @FXML void initialize() {

        populateLabels();

        Label pizza = new Label("PIZZAS");
        cartList.getChildren().add(pizza);



        for (Label p: pizzas) {
            HBox hbox = new HBox();
            hbox.getChildren().add(p);
            cartList.getChildren().add(hbox);
        }

        Label Sides = new Label("SIDES");
        cartList.getChildren().add(Sides);

        for (Label s: sides) {
            HBox hbox = new HBox();
            hbox.getChildren().add(s);
            cartList.getChildren().add(hbox);
        }


        Label Drinks = new Label("DRINKS");
        cartList.getChildren().add(Drinks);

        for (Label d: drinks) {
            HBox hbox = new HBox();
            hbox.getChildren().add(d);
            cartList.getChildren().add(hbox);
        }



    }

    public void goBackToOrderMenu(ActionEvent actionEvent) throws IOException {

        if(isManager()){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Order-Menu-View.fxml"));
            Parent root = fxmlLoader.load();
            OrderMenuController orderMenuController = fxmlLoader.getController();
            fxmlLoader.setController(orderMenuController);

            orderMenuController.setEmployee(employee);
            orderMenuController.setFoodList(foodList);
            orderMenuController.displayName();


            Stage window = (Stage) label.getScene().getWindow();

            Scene scene = new Scene(root,900,600);
            window.setTitle("Manager View");
            window.setScene(scene);
            window.setResizable(false);
            window.show();
        }

//        If it's a staff logged in, go back to staff view
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Order-Menu-View.fxml"));
            Parent root = fxmlLoader.load();
            OrderMenuController orderMenuController = fxmlLoader.getController();
            fxmlLoader.setController(orderMenuController);

            orderMenuController.setEmployee(employee);
            orderMenuController.setFoodList(foodList);
            orderMenuController.setNewOrder(order);
            orderMenuController.displayName();

            Stage window = (Stage) label.getScene().getWindow();

            Scene scene = new Scene(root,900,600);
            window.setTitle("Staff View");
            window.setScene(scene);
            window.setResizable(false);
            window.show();
        }
    }

    public boolean isManager(){
        return employee.getEmployeeType().equals("Manager");
    }

    public void logOutButton(ActionEvent actionEvent) throws IOException {
        changeView("Login-view.fxml");

    }

    public void displayName(){
        currentUser.setText("Hello " + employee.employeeType);
    }

    public void changeView(String viewName) throws IOException {
        Stage window = (Stage) label.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        window.setTitle("PieHackers Pizza Restaurant!");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public Staff getEmployee() {
        return employee;
    }

    public void setEmployee(Staff employee) {
        this.employee = employee;
    }

    public List<FoodItems> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<FoodItems> foodList) {
        this.foodList = foodList;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }




}


