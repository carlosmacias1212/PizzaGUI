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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import management.Order;
import management.Menu;
import management.Staff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static list.JsonController.*;
import static management.Menu.*;

public class OrderMenuController {

    private Staff employee;
    private Order newOrder;
    @FXML
    private Label currentUser;
    @FXML
    private Label currentCustomer;
    @FXML
    private Label orderType;
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
    public ToggleGroup dSize;

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

    public ToggleButton xlarge;
    public ToggleButton wings;
    public ToggleButton breadSticks;
    public ToggleButton garlicKnots;
    public ToggleButton bonelessWings;


    public ToggleButton sdrink;

    public ToggleButton mdrink;

    public ToggleButton ldrink;

    public ToggleButton coke;
    public ToggleButton dietCoke;
    public ToggleButton sprite;
    public ToggleButton drPepper;


    @FXML
    public Label label;
    @FXML
    private Text errorText;

    public void addToOrder(ActionEvent actionEvent) throws IOException {

        if (sideGroup.getSelectedToggle() == null && drinkGroup.getSelectedToggle() == null && sizeGroup.getSelectedToggle() == null && PizzaTypes.getSelectedToggle() == null) {
            errorText.setText("Please select an item before adding to order");
        }

        else {

            FoodItems newPizza;
            FoodItems side;
            FoodItems drink;

            String size = "";
            String pizzaType = "";
            String sideType;
            String drinkType;
            String drinkSize = "";

            if (pep.equals(PizzaTypes.getSelectedToggle())) {
                pizzaType = PEPPERONI;
            } else if (cheese.equals(PizzaTypes.getSelectedToggle())) {
                pizzaType = CHEESE;
            } else if (veggie.equals(PizzaTypes.getSelectedToggle())) {
                pizzaType = VEGGIE;
            } else if (sausage.equals(PizzaTypes.getSelectedToggle())) {
                pizzaType = SAUSAGE;
            } else if (marinara.equals(PizzaTypes.getSelectedToggle())) {
                pizzaType = MARINARA;
            } else if (supreme.equals(PizzaTypes.getSelectedToggle())) {
                pizzaType = SUPREME;
            }

            if (small.equals(sizeGroup.getSelectedToggle())) {
                size = SMALL;
                foodList.add(new Pizza(pizzaType, size));
            } else if (medium.equals(sizeGroup.getSelectedToggle())) {
                System.out.println("med");
                size = MEDIUM;
                foodList.add(new Pizza(pizzaType, size));
            } else if (large.equals(sizeGroup.getSelectedToggle())) {
                size = LARGE;
                foodList.add(new Pizza(pizzaType, size));
                System.out.println(foodList.get(0).getType());
            } else if (xlarge.equals(sizeGroup.getSelectedToggle())) {
                size = XLARGE;
                foodList.add(new Pizza(pizzaType, size));
                System.out.println(foodList.get(0).getType());

            }

            if (breadSticks.equals(sideGroup.getSelectedToggle())) {
                System.out.println("yea");
                sideType = BREAD_STICKS;
            } else if (garlicKnots.equals(sideGroup.getSelectedToggle())) {
                sideType = GARLIC_KNOTS;
            } else if (wings.equals(sideGroup.getSelectedToggle())) {
                sideType = WINGS;
            } else if (bonelessWings.equals(sideGroup.getSelectedToggle())) {
                sideType = BONELESS_WINGS;
            } else {
                sideType = "";
            }

            if (coke.equals(drinkGroup.getSelectedToggle())) {
                drinkType = COKE;
            } else if (dietCoke.equals(drinkGroup.getSelectedToggle())) {
                drinkType = DIET_COKE;
            } else if (drPepper.equals(drinkGroup.getSelectedToggle())) {
                drinkType = DR_PEPPER;
            } else if (sprite.equals(drinkGroup.getSelectedToggle())) {
                drinkType = SPRITE;
            } else {
                drinkType = "";
            }

            if (sdrink.equals(dSize.getSelectedToggle())) {
                drinkSize = "small";
                foodList.add(new Drink(drinkType, drinkSize));

            } else if (mdrink.equals(dSize.getSelectedToggle())) {
                drinkSize = "medium";
                foodList.add(new Drink(drinkType, drinkSize));

            } else if (ldrink.equals(dSize.getSelectedToggle())) {
                drinkSize = "large";
                foodList.add(new Drink(drinkType, drinkSize));
            }


            switch (sideType) {
                case "bread sticks" -> {
                    side = new Side(BREAD_STICKS);
                    foodList.add(side);
                }
                case "garlic knots" -> {
                    side = new Side(GARLIC_KNOTS);
                    foodList.add(side);
                }
                case "wings" -> {
                    side = new Side(WINGS);
                    foodList.add(side);
                }
                case "boneless wings" -> {
                    side = new Side(BONELESS_WINGS);
                    foodList.add(side);
                }
            }


            /*
            switch (drinkType) {
                case "coke" -> {
                    drink = new Drink(COKE);
                    foodList.add(drink);
                }
                case "diet coke" -> {
                    drink = new Drink(DIET_COKE);
                    foodList.add(drink);
                }
                case "dr. pepper" -> {
                    drink = new Drink(DR_PEPPER);
                    foodList.add(drink);
                }
                case "sprite" -> {
                    drink = new Drink(SPRITE);
                    foodList.add(drink);
                }
            }

             */




            resetToggles();


//        for (FoodItems item : foodList) {
//            if(item.getFoodName() != null)
//            {
//                System.out.println(item.getFoodName());
//            }
//        }
        }

    }

    public void resetToggles() throws IOException {
        ////This get the fxml loader ready
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Order-Menu-View.fxml"));
        ////This preloads the next fxml
        Parent root = fxmlLoader.load();
        ////This grabs the controller being used in the current fxmlLoader
        OrderMenuController orderMenuController = fxmlLoader.getController();
        fxmlLoader.setController(orderMenuController);

        ////Sets employee attribute in the controller to the user here
        orderMenuController.setFoodList(foodList);
        orderMenuController.setEmployee(employee);
        orderMenuController.setCurrentCustomer(currentCustomer);
        orderMenuController.setOrderType(orderType);
        orderMenuController.displayName();

        System.out.println(currentUser.getText());
        System.out.println(currentCustomer.getText());
        System.out.println(orderType.getText());



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
        byoController.setEmployee(getEmployee());
        byoController.setCurrentUser(getCurrentUser());
        byoController.displayName();

        Stage window = (Stage) label.getScene().getWindow();
        Scene scene = new Scene(root,900,600);
        window.setTitle("Build Your Own");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public void goBackToStaffView(ActionEvent actionEvent) throws IOException {

        if(isManager()){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Manager-View.fxml"));
            Parent root = fxmlLoader.load();
            StaffViewController staffViewController = fxmlLoader.getController();
            fxmlLoader.setController(staffViewController);

            staffViewController.setEmployee(employee);
            staffViewController.displayName();

            Stage window = (Stage) label.getScene().getWindow();

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

            staffViewController.setEmployee(employee);
            staffViewController.displayName();

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


    public void setFoodList(List<FoodItems> foodList) {
        this.foodList = foodList;
    }

    public void finishOrder(ActionEvent actionEvent) throws IOException {



        if(foodList.size() == 0){
            errorText.setText("Order is Empty");
        }

        else {
            newOrder = new Order(currentCustomer.getText(), Order.isPickup(orderType.getText()));
            newOrder.setOrderTotal();
            newOrder.addToCart(foodList);
            System.out.println(foodList.get(0).getType());
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Checkout-View.fxml"));
            Parent root = fxmlLoader.load();
            CheckoutController checkoutController = fxmlLoader.getController();
            fxmlLoader.setController(checkoutController);

            checkoutController.setEmployee(getEmployee());
            checkoutController.setFoodList(getFoodList());
            checkoutController.setOrder(getOrder());
            checkoutController.setCurrentUser(getCurrentUser());
            checkoutController.displayName();
            checkoutController.start();


            Stage window = (Stage) label.getScene().getWindow();
            Scene scene = new Scene(root, 900, 600);
            window.setTitle("Checkout");
            window.setScene(scene);
            window.setResizable(false);
            window.show();
        }
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

    public void displayName(){
        currentUser.setText("Hello, " + employee.employeeType);
//        currentCustomer.setText("Cust: " + currentCustomer.getText());
//        orderType.setText(orderType.getText() + " Order");

    }

    public List<FoodItems> getFoodList(){
        return foodList;
    }
    public Staff getEmployee() {
        return employee;
    }

    public void setEmployee(Staff employee) {
        this.employee = employee;
    }

    public Label getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Label currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public void setOrderType(Label orderType){
        this.orderType = orderType;
    }

    public Order getNewOrder() {
        return newOrder;
    }

    public void setNewOrder(Order newOrder) {
        this.newOrder = newOrder;
    }

    public Label getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Label currentUser) {
        this.currentUser = currentUser;
    }

    public Staff getStaff(){
        return this.employee;
    }

    public Order getOrder(){
        return this.newOrder;
    }

}
