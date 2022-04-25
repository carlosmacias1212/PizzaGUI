package controllers.pizzagui;

import food.FoodItems;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class BYOController implements Initializable {

    ArrayList<String> toppings = new ArrayList<>(Arrays.asList("Pepperoni", "Sausage", "Chicken","Mushrooms",
                                                                             "Ham","Onion","Green Peppers"));
    String top1 = "";
    String top2 = "";
    String top3 = "";
    String top4 = "";

    public ToggleButton handTossed;
    public ToggleGroup crustType;
    public ToggleButton pan;
    public ToggleButton stuffed;
    public ToggleButton lightSauce;
    public ToggleGroup sauceType;
    public ToggleButton regularCheese;
    public ToggleGroup cheeseType;
    public ToggleButton lightCheese;
    public ToggleButton xtraCheese;
    public ToggleButton regularSauce;
    public ToggleButton xtraSauce;
    public ToggleGroup crustTypes;
    public ToggleGroup sauceTypes;
    public ToggleGroup cheeseAmount;
    public ToggleGroup cheeseAmount1;
    public ChoiceBox<String> topping1;
    public ChoiceBox<String> topping2;
    public ChoiceBox<String> topping3;
    public ChoiceBox<String> topping4;

    private List<FoodItems> list = new ArrayList<>();
    private Label customerPhoneNum;


    @FXML
    public Label label;

    public void logOutButton(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) label.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle("PieHackers Pizza Restaurant!");
        window.setScene(scene);
        window.setResizable(false);
        window.show();

    }

    public void addToOrder(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Order-Menu-View.fxml"));
        ////This preloads the next fxml
        Parent root = fxmlLoader.load();
        ////This grabs the controller being used in the current fxmlLoader
        OrderMenuController orderMenuController = fxmlLoader.getController();
        fxmlLoader.setController(orderMenuController);
        ////Sets employee attribute in the controller to the user here
        orderMenuController.setFoodList(list);


        Stage window = (Stage) label.getScene().getWindow();
        Scene scene = new Scene(root,900,600);
        window.setTitle("Staff View");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
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

    public void setList(List<FoodItems> list) {
        this.list = list;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        topping1.getItems().addAll(toppings);
        topping2.getItems().addAll(toppings);
        topping3.getItems().addAll(toppings);
        topping4.getItems().addAll(toppings);

        topping1.setOnAction(this::addTopping1);
    }

    public void addTopping1(ActionEvent event){
        top1 = topping1.getValue();
    }
    public void addTopping2(ActionEvent event){
        top2 = topping1.getValue();
    }
    public void addTopping3(ActionEvent event){
        top3 = topping1.getValue();
    }
    public void addTopping4(ActionEvent event){
        top4 = topping1.getValue();
    }

}
