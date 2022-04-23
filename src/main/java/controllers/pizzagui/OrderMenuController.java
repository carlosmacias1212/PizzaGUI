package controllers.pizzagui;

import food.Drink;
import food.FoodItems;
import food.Pizza;
import food.Side;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import management.Order;
import management.Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static management.Menu.*;

public class OrderMenuController {

    private List<FoodItems> foodList = new ArrayList<>();
    public ToggleGroup sideGroup;
    @FXML
    public ToggleGroup drinkGroup;
    @FXML
    public ToggleGroup sizeGroup;
    @FXML
    public ToggleGroup PizzaTypes;

    @FXML
    public ToggleGroup size;

    @FXML
    public ToggleGroup sides;

    @FXML
    public ToggleGroup drink;

    @FXML
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

    @FXML
    public Label label;





    public void addToOrder(ActionEvent actionEvent) throws IOException {

        FoodItems newPizza;
        FoodItems side;
        FoodItems drink;

        String size = "";
        String pizzaType = "";
        String sideType;
        String drinkType;
        String drinkSize;

        if(pep.equals(PizzaTypes.getSelectedToggle())){
            pizzaType = PEPPERONI;
        }else if (cheese.equals(PizzaTypes.getSelectedToggle())){
            pizzaType = CHEESE;
        }else if (veggie.equals(PizzaTypes.getSelectedToggle())){
            pizzaType = VEGGIE;
        }else if (sausage.equals(PizzaTypes.getSelectedToggle())){
            pizzaType = SAUSAGE;
        }else if (marinara.equals(PizzaTypes.getSelectedToggle())){
            pizzaType = MARINARA;
        }else if (supreme.equals(PizzaTypes.getSelectedToggle())){
            pizzaType = SUPREME;
        }

        if(small.equals(sizeGroup.getSelectedToggle())){
            size = SMALL;
            foodList.add(new Pizza(pizzaType,size));
        }else if (medium.equals(sizeGroup.getSelectedToggle())){
            size = MEDIUM;
            foodList.add(new Pizza(pizzaType,size));
        }else if (large.equals(sizeGroup.getSelectedToggle())){
            size = LARGE;
            foodList.add(new Pizza(pizzaType,size));
        }else if (xlarge.equals(sizeGroup.getSelectedToggle())){
            size = XLARGE;
            foodList.add(new Pizza(pizzaType,size));
        }

        if(breadSticks.equals(sideGroup.getSelectedToggle())){
            sideType = BREAD_STICKS;
        }else if (garlicKnots.equals(sideGroup.getSelectedToggle())){
            sideType = GARLIC_KNOTS;
        }else if (wings.equals(sideGroup.getSelectedToggle())){
            sideType = WINGS;
        }else if (bonelessWings.equals(sideGroup.getSelectedToggle())){
            sideType = BONELESS_WINGS;
        }
        else{
            sideType = "";
        }

        if(coke.equals(drinkGroup.getSelectedToggle())){
            drinkType = SMALL;
        }else if (dietCoke.equals(drinkGroup.getSelectedToggle())){
            drinkType = MEDIUM;
        }else if (drPepper.equals(drinkGroup.getSelectedToggle())){
            drinkType = LARGE;
        }else if (sprite.equals(drinkGroup.getSelectedToggle())){
            drinkType = XLARGE;
        }else{
            drinkType = "";
        }


        switch (sideType) {
            case "Bread Sticks" -> {
                side = new Side(BREAD_STICKS);
                foodList.add(side);
            }
            case "Garlic Knots" -> {
                side = new Side(GARLIC_KNOTS);
                foodList.add(side);
            }
            case "Wings" -> {
                side = new Side(WINGS);
                foodList.add(side);
            }
            case "Boneless Wings" -> {
                side = new Side(BONELESS_WINGS);
                foodList.add(side);
            }
        }

        switch (drinkType) {
            case "Coke" -> {
                drink = new Drink(COKE);
                foodList.add(drink);
            }
            case "Diet Coke" -> {
                drink = new Drink(DIET_COKE);
                foodList.add(drink);
            }
            case "Dr. Pepper" -> {
                drink = new Drink(DR_PEPPER);
                foodList.add(drink);
            }
            case "Sprite" -> {
                drink = new Drink(SPRITE);
                foodList.add(drink);
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

//        for (FoodItems item : foodList) {
//            if(item.getFoodName() != null)
//            {
//                System.out.println(item.getFoodName());
//            }
//        }

    }

    public void finishOrder(ActionEvent actionEvent) throws IOException {

        Order order = new Order ("99", true);

        order.items = foodList;

        Stage window = (Stage) label.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Checkout-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle("Checkout");
        window.setScene(scene);
        window.setResizable(false);
        window.show();

    }

    public void sizeToggleButton(ActionEvent actionEvent) {
    }

    public void SpecialtyToggleButton(ActionEvent actionEvent) {
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
        changeView("Staff-View.fxml");
    }

    public void logOutButton(ActionEvent actionEvent) throws IOException {
        changeView("Login-view.fxml");
    }


    public void setFoodList(List<FoodItems> foodList) {
        this.foodList = foodList;
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
