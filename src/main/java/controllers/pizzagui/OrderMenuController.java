package controllers.pizzagui;

import food.Drink;
import food.FoodItems;
import food.Pizza;
import food.Side;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import management.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static list.JsonController.*;


public class OrderMenuController {

    private List<FoodItems> foodList = new ArrayList<>();
    public ToggleGroup sideGroup;
    public ToggleGroup drinkGroup;
    public ToggleGroup sizeGroup;
    public ToggleGroup PizzaTypes;

    public ToggleButton pep;
    public ToggleButton supreme;
    public ToggleButton cheese;
    public ToggleButton sausage;
    public ToggleButton veggie;
    public ToggleButton marinara;
    public ToggleButton small;
    public ToggleButton medium;
    public ToggleButton large;
    public ToggleButton wings;
    public ToggleButton breadSticks;
    public ToggleButton garlicKnots;
    public ToggleButton bonelessWings;
    public ToggleButton coke;
    public ToggleButton dietCoke;
    public ToggleButton sprite;
    public ToggleButton drPepper;
    public ToggleButton xlarge;

    public Label label;




    public void addToOrder(ActionEvent actionEvent) throws IOException {

        FoodItems side;
        FoodItems drink;
        String size = "";
        String pizzaType = "";
        String sideType;
        String drinkType;

        if(pep.equals(PizzaTypes.getSelectedToggle())){
            pizzaType = "pepperoni";
        }else if (cheese.equals(PizzaTypes.getSelectedToggle())){
            pizzaType = "cheese";
        }else if (veggie.equals(PizzaTypes.getSelectedToggle())){
            pizzaType = "veggie";
        }else if (sausage.equals(PizzaTypes.getSelectedToggle())){
            pizzaType = "sausage";
        }else if (marinara.equals(PizzaTypes.getSelectedToggle())){
            pizzaType = "marinara";
        }else if (supreme.equals(PizzaTypes.getSelectedToggle())){
            pizzaType = "supreme";
        }

        if(small.equals(sizeGroup.getSelectedToggle())){
            size = "small";
            foodList.add(new Pizza(pizzaType,size));
        }else if (medium.equals(sizeGroup.getSelectedToggle())){
            size = "medium";
            foodList.add(new Pizza(pizzaType,size));
        }else if (large.equals(sizeGroup.getSelectedToggle())){
            size = "large";
            foodList.add(new Pizza(pizzaType,size));
        }else if (xlarge.equals(sizeGroup.getSelectedToggle())){
            size = "xlarge";
            foodList.add(new Pizza(pizzaType,size));
        }

        if(breadSticks.equals(sideGroup.getSelectedToggle())){
            sideType = "breadsticks";
        }else if (garlicKnots.equals(sideGroup.getSelectedToggle())){
            sideType = "garlicknots";
        }else if (wings.equals(sideGroup.getSelectedToggle())){
            sideType = "wings";
        }else if (bonelessWings.equals(sideGroup.getSelectedToggle())){
            sideType = "bonelesswings";
        }
        else{
            sideType = "";
        }

        if(coke.equals(drinkGroup.getSelectedToggle())){
            drinkType = "coke";
        }else if (dietCoke.equals(drinkGroup.getSelectedToggle())){
            drinkType = "dietCoke";
        }else if (drPepper.equals(drinkGroup.getSelectedToggle())){
            drinkType = "drPepper";
        }else if (sprite.equals(drinkGroup.getSelectedToggle())){
            drinkType = "sprite";
        }else{
            drinkType = "";
        }


        switch (sideType) {
            case "breadsticks" -> {
                side = new Side("breadSticks");
                foodList.add(side);
            }
            case "garlicknots" -> {
                side = new Side("garlicKnots");
                foodList.add(side);
            }
            case "wings" -> {
                side = new Side("wings");
                foodList.add(side);
            }
            case "bonelesswings" -> {
                side = new Side("bonelessWings");
                foodList.add(side);
            }
        }

        switch (drinkType) {
            case "coke" -> {
                drink = new Drink("coke");
                foodList.add(drink);
            }
            case "dietCoke" -> {
                drink = new Drink("dietCoke");
                foodList.add(drink);
            }
            case "drPepper" -> {
                drink = new Drink("mountainDew");
                foodList.add(drink);
            }
            case "sprite" -> {
                drink = new Drink("sprite");
                foodList.add(drink);
            }
        }


        for (FoodItems item : foodList) {
            if(item.getFoodName() != null)
            {
                System.out.println(item.getFoodName());
            }
        }

        ////This get the fxml loader ready
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Order-Menu-View.fxml"));
        ////This preloads the next fxml
        Parent root = fxmlLoader.load();
        ////This grabs the controller being used in the current fxmlLoader
        OrderMenuController orderMenuController = fxmlLoader.getController();
        fxmlLoader.setController(orderMenuController);
        ////Sets employee attribute in the controller to the user here
        orderMenuController.setFoodList(foodList);


        /*
        This will restart the order menu page after pressing Add to Cart
         */
        Stage window = (Stage) label.getScene().getWindow();
        Scene scene = new Scene(root,900,600);
        window.setTitle("Order Menu");
        window.setScene(scene);
        window.setResizable(false);
        window.show();




    }



    public void buildYourOwnButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Build-Your-Own-View.fxml"));
        ////This preloads the next fxml
        Parent root = fxmlLoader.load();
        ////This grabs the controller being used in the current fxmlLoader
        BYOController byoController = fxmlLoader.getController();
        fxmlLoader.setController(byoController);
        ////Sets employee attribute in the controller to the user here
        byoController.setList(foodList);

        Stage window = (Stage) label.getScene().getWindow();
        Scene scene = new Scene(root,900,600);
        window.setTitle("Build Your Own");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public void goBackToStaffView(ActionEvent actionEvent) throws IOException {
        changeView("Staff-View");
    }

    public void logOutButton(ActionEvent actionEvent) throws IOException {
        changeView("Login-view-View");
    }


    public void setFoodList(List<FoodItems> foodList) {
        this.foodList = foodList;
    }

    public void finishOrder(ActionEvent actionEvent) throws IOException {
        Order newOrder = new Order("5747", true);
        newOrder.addToCart(foodList);
        newOrder.setOrderTotal();
        orderList.add(newOrder);
        serializeOrders();

        Stage window = (Stage) label.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Checkout-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle("Staff View");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
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
