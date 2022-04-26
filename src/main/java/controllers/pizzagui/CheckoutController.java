package controllers.pizzagui;

import food.BYO;

import food.Drink;
import food.FoodItems;
import food.Pizza;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import management.Order;
import management.Staff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckoutController {

    public VBox cartList;
    private Staff employee;
    private Order order;
    @FXML
    private Label currentUser;
    private List<FoodItems> cart = new ArrayList<>();

    private Label totalPrice;

    private List<FoodItems> cartView = new ArrayList<FoodItems>();

    private ArrayList<Label> entries = new ArrayList<Label>();

    private ArrayList<Integer> quantities = new ArrayList<Integer>();


    public Button back;
    public Button pay;







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

                if (item.getType().equals("custom")) {
                    type = "▶Custom";
                    Label t = new Label(type);
                    t.setStyle("-fx-font-style: bold");

                    String sauce = "\n  -" + ((BYO) item).getSauce();
                    String cheese = "\n  -" + ((BYO) item).getCheese();
                    String crust = "\n  -" + ((BYO) item).getCrustType();
                    size = ((BYO) item).getSize();
                    String topping = "\n  -toppings: ";
                    for (String top: ((BYO) item).getToppings()) {
                        topping += "\n   " + top;
                    }


                    System.out.println(((BYO) item).getSauce());
                    desc = t.getText() + " " + size + sauce + cheese + crust + topping;

                } else {
                    type = "▶"+item.getType();
                    size = ( (Pizza) item).getSize();

                    desc = type + " " + size;

                }

                cartView.add(item);
                quantities.add(1);
                entries.add(new Label(desc));



            } else if (item.getFoodName().equals("side")) {
                String type = "▶"+item.getType();
                cartView.add(item);
                quantities.add(1);
                entries.add(new Label(type));

            } else if (item.getFoodName().equals("drink")) {
                String type = "▶"+item.getType();
                String size = ((Drink) item).getSize();
                desc = type + " " + size;
                cartView.add(item);
                quantities.add(1);
                entries.add(new Label(desc));
            }
        }

    }
    //Only want one label per specific type of food item (ex. small cheese)
    private Boolean isRepeat(FoodItems foodType) {
        for (FoodItems f: cartView) {
            if (foodType.getFoodName().equals("pizza") && f.getFoodName().equals("pizza")) {
                if (foodType.getType().equals("custom") && f.getType().equals("custom")) {
                    if (sameCustom((BYO) f, (BYO) foodType)) {

                        int i = cartView.indexOf(f);
                        int q = quantities.get(i) + 1;
                        quantities.set(i, q);
                        return true;
                    }
                } else if (f.getType().equals(foodType.getType())){

                    Pizza p1 = (Pizza) f;
                    Pizza p2 = (Pizza) foodType;
                    if (p1.getType().equals(p2.getType()) && p1.getSize().equals(p2.getSize())) {
                        int i = cartView.indexOf(f);
                        int q = quantities.get(i) + 1;
                        quantities.set(i, q);
                        return true;
                    }
                }
            } else if (foodType.getFoodName().equals("side") && f.getFoodName().equals("side")) {
                if (f.getType().equals(foodType.getType())) {
                    int i = cartView.indexOf(f);
                    int q = quantities.get(i) + 1;
                    quantities.set(i, q);
                    return true;
                }
            } else if (foodType.getFoodName().equals("drink") && f.getFoodName().equals("drink")) {
                if (f.getType().equals(foodType.getType())) {
                    if (((Drink) f).getSize().equals(((Drink) foodType).getSize())) {
                        int i = cartView.indexOf(f);
                        int q = quantities.get(i) + 1;
                        quantities.set(i, q);
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



   public float cartTotal() {
       float priceTotal = 0;
       for (FoodItems f: cart) {
           priceTotal += f.getPrice();
       }

       return priceTotal;
   }

   public void start() {


        populateLabels();


        Label pizza = new Label("PIZZAS:");
        pizza.setStyle("-fx-font-size:13pt; -fx-font-family:'Arial Rounded MT Bold'");
        cartList.getChildren().add(pizza);


        for (Label p: entries) {

            int i = entries.indexOf(p);
            if (cartView.get(i).getFoodName().equals("pizza")) {

                HBox hbox = entry(p);
                hbox.setStyle("-fx-background-color: lightgrey");
                cartList.getChildren().add(hbox);
            }

        }

        Label Sides = new Label("SIDES:");
       Sides.setStyle("-fx-font-size:13pt; -fx-font-family:'Arial Rounded MT Bold'");
       cartList.getChildren().add(Sides);

        for (Label s: entries) {

            int i = entries.indexOf(s);
            if (cartView.get(i).getFoodName().equals("side")) {

                HBox hbox = entry(s);
                hbox.setStyle("-fx-background-color: lightgrey");
                cartList.getChildren().add(hbox);
            }
        }


        Label Drinks = new Label("DRINKS:");
       Drinks.setStyle("-fx-font-size:13pt; -fx-font-family:'Arial Rounded MT Bold'");
       cartList.getChildren().add(Drinks);

        for (Label d: entries) {
            int i = entries.indexOf(d);
            if (cartView.get(i).getFoodName().equals("drink")) {

                HBox hbox = entry(d);
                hbox.setStyle("-fx-background-color: lightgrey; -fx-border-radius:50px");
                cartList.getChildren().add(hbox);
            }
        }

        Separator seperator = new Separator();
        seperator.setOrientation(Orientation.HORIZONTAL);
        cartList.getChildren().add(seperator);

        HBox subtotal = total();
        cartList.getChildren().add(subtotal);
    }

    private HBox total() {
        HBox layout = new HBox();
        layout.setAlignment(Pos.CENTER);

        Label total = new Label("Order Total: $");
        total.setStyle("-fx-font-size: 15pt;");


        float priceTotal = cartTotal();
        this.totalPrice = new Label(String.valueOf(priceTotal));
        totalPrice.setStyle("-fx-font-size: 14pt; -fx-font-family: 'Arial Rounded MT Bold'");

        layout.getChildren().addAll(total, this.totalPrice);
        return layout;

    }

    private HBox entry(Label food) {

        HBox layout = new HBox();
        layout.setAlignment(Pos.CENTER_LEFT);

        food.setPrefWidth(400);
        food.setStyle("-fx-font-size:15pt; -fx-padding:5px");

        int i = entries.indexOf(food);
        int q = quantities.get(i);
        String quant = String.valueOf(q);
        Label quantity = new Label(quant);
        quantity.setStyle("-fx-padding: 5px");

        Button minusButton = new Button("-");
        minusButton.setStyle("-fx-background-color: orange; -fx-border-style: solid");
        minusButton.setShape(new Circle(1.5));
        minusButton.setUserData(cartView.get(i).getType());
        minusButton.setOnAction(e -> {
            String name = (String) ((Node) e.getSource()).getUserData();

            for (FoodItems f: cart) {

                if (f.getType().equals(name)) {


                    for (FoodItems list: cartView) {
                        if (list.getType().equals(name)) {
                            int j = cartView.indexOf(list);
                            int qminus = (quantities.get(j) > 0 ? ( quantities.get(j) - 1 ): 0);
                            quantities.set(j, qminus);
                            cart.remove(f);
                            quantity.setText(String.valueOf(qminus));
                            this.totalPrice.setText(String.valueOf(cartTotal()));


                        }
                    }

                }
            }
        });

        Button plusButton = new Button("+");
        plusButton.setStyle("-fx-background-color: orange; -fx-border-style: solid");
        plusButton.setShape(new Circle(1.5));
        plusButton.setUserData(cartView.get(i).getType());
        plusButton.setOnAction(e -> {
            String name = (String) ((Node) e.getSource()).getUserData();
            for (FoodItems f: cart) {
                if (f.getType().equals(name)) {

                    for (FoodItems list: cartView) {
                        if (list.getType().equals(name)) {
                            int j = cartView.indexOf(list);
                            int qplus = quantities.get(j) + 1;
                            quantities.set(j, qplus);
                            cart.add(f);
                            quantity.setText(String.valueOf(qplus));

                            this.totalPrice.setText(String.valueOf(cartTotal()));

                        }
                    }

                }
            }
        });

        float amount = cartView.get(i).getPrice();
        String p = "$ " + amount;
        Label price = new Label(p);

        layout.getChildren().addAll(food, minusButton, quantity, plusButton, price);
        return layout;
    }

    public void goToConfirm(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Confirmation-View.fxml"));
        Parent root = fxmlLoader.load();
        ConfirmationController confirmationController = fxmlLoader.getController();
//        fxmlLoader.setController(confirmationController);

        confirmationController.setEmployee(getEmployee());
        confirmationController.setTotalPrice(getTotalPrice());
        confirmationController.setOrder(getOrder());
        confirmationController.setFoodList(getFoodList());
        confirmationController.setCurrentUser(getCurrentUser());

        confirmationController.displayName();


//        Stage window = (Stage) (Node)totalPrice.getScene().getWindow();
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        Scene scene = new Scene(root,900,600);
        window.setTitle("Confirmation View");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    private Label getTotalPrice() {
        return this.totalPrice;
    }


    public void goBackToOrderMenu(ActionEvent actionEvent) throws IOException {

        if(isManager()){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Order-Menu-View.fxml"));
            Parent root = fxmlLoader.load();
            OrderMenuController orderMenuController = fxmlLoader.getController();
            fxmlLoader.setController(orderMenuController);

            orderMenuController.setEmployee(employee);
            orderMenuController.setFoodList(cart);
            orderMenuController.setNewOrder(order);
            orderMenuController.setCurrentUser(currentUser);
            orderMenuController.displayName();


            Stage window = (Stage) currentUser.getScene().getWindow();

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
            orderMenuController.setFoodList(cart);
            orderMenuController.setNewOrder(order);
            orderMenuController.setCurrentUser(currentUser);

            orderMenuController.displayName();

            Stage window = (Stage) cartList.getScene().getWindow();

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
        Stage window = (Stage) cartList.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(viewName));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle(viewName);
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
        return cart;
    }

    public void setFoodList(List<FoodItems> foodList) {
        this.cart = foodList;
    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Label getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Label currentUser) {
        this.currentUser = currentUser;
    }

    public void setTotalPrice(Label price) {
        this.totalPrice = price;
    }
}
