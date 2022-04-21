package controllers.pizzagui;

import food.FoodItems;
import food.Pizza;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderMenuController {

    public ToggleGroup sideGroup;
    public ToggleGroup drinkGroup;
    public ToggleGroup sizeGroup;
    public ToggleGroup PizzaTypes;
    private List<FoodItems> list = new ArrayList<>();
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
        String size = "";
        String pizzaType = "";
        String sides;
        String drink;

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
        }else if (medium.equals(sizeGroup.getSelectedToggle())){
            size = "medium";
        }else if (large.equals(sizeGroup.getSelectedToggle())){
            size = "large";
        }else if (xlarge.equals(sizeGroup.getSelectedToggle())){
            size = "xlarge";
        }

        if(breadSticks.equals(sideGroup.getSelectedToggle())){
            sides = "small";
        }else if (garlicKnots.equals(sideGroup.getSelectedToggle())){
            sides = "medium";
        }else if (wings.equals(sideGroup.getSelectedToggle())){
            sides = "large";
        }else if (bonelessWings.equals(sideGroup.getSelectedToggle())){
            sides = "xlarge";
        }
        else{
            sides = "";
        }

        if(coke.equals(drinkGroup.getSelectedToggle())){
            drink = "small";
        }else if (dietCoke.equals(drinkGroup.getSelectedToggle())){
            drink = "medium";
        }else if (drPepper.equals(drinkGroup.getSelectedToggle())){
            drink = "large";
        }else if (sprite.equals(drinkGroup.getSelectedToggle())){
            drink = "xlarge";
        }else{
            drink = "";
        }











        ////This get the fxml loader ready
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Order-Menu-View.fxml"));
        ////This preloads the next fxml
        Parent root = fxmlLoader.load();
        ////This grabs the controller being used in the current fxmlLoader
        OrderMenuController orderMenuController = fxmlLoader.getController();
        fxmlLoader.setController(orderMenuController);
        ////Sets employee attribute in the controller to the user here
        orderMenuController.setList(list);


        /*
        This will restart the order menu page after pressing Add to Cart
         */
        Stage window = (Stage) label.getScene().getWindow();
        Scene scene = new Scene(root,900,600);
        window.setTitle("Order Menu");
        window.setScene(scene);
        window.setResizable(false);
        window.show();


        for (FoodItems food : list) {
            System.out.println(food.getFoodName());
        }



    }



    public void buildYourOwnButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Build-Your-Own-View.fxml"));
        ////This preloads the next fxml
        Parent root = fxmlLoader.load();
        ////This grabs the controller being used in the current fxmlLoader
        BYOController byoController = fxmlLoader.getController();
        fxmlLoader.setController(byoController);
        ////Sets employee attribute in the controller to the user here
        byoController.setList(list);

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


    public void setList(List<FoodItems> list) {
        this.list = list;
    }

    public void finishOrder(ActionEvent actionEvent) throws IOException {
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
