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


    private Label totalPrice;
    private Staff employee;
    //This employee is passed through add to cart scenes and byo scenes and checkout scene.
    private Order newOrder;
    //This order is passed from Order Menu Controller to check out after pressing add to cart.
    private List<FoodItems> foodList = new ArrayList<>();
    //This array list holds the food that has been added to the cart. Transfers between scenes.
    @FXML
    private Label currentUser;
    @FXML
    private Label currentCustomer;
    @FXML
    private Label orderType;

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
                size = MEDIUM;
                foodList.add(new Pizza(pizzaType, size));
            } else if (large.equals(sizeGroup.getSelectedToggle())) {
                size = LARGE;
                foodList.add(new Pizza(pizzaType, size));
            } else if (xlarge.equals(sizeGroup.getSelectedToggle())) {
                size = XLARGE;
                foodList.add(new Pizza(pizzaType, size));
            }

            if (breadSticks.equals(sideGroup.getSelectedToggle())) {
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

            if(dSize.getSelectedToggle() != null) {

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

            resetToggles();

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
        orderMenuController.setFoodList(getFoodList());
        orderMenuController.setEmployee(getEmployee());
        orderMenuController.setCurrentCustomer(getCurrentCustomer());
        orderMenuController.setOrderType(getOrderType());
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
        byoController.setList(getFoodList());
        byoController.setEmployee(getEmployee());

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

            staffViewController.setEmployee(getEmployee());
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
            checkoutController.setTotalPrice(getTotalPrice());
            checkoutController.start();
            checkoutController.displayName();

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
        window.setTitle("PieHackers Pizza Restaurant!");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public void displayName(){
        currentUser.setText("Hello, " + employee.employeeType);

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

    public Label getOrderType(){
        return this.orderType;
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

    public Label getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Label totalPrice) {
        this.totalPrice = totalPrice;
    }
}
