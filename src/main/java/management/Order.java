package management;

import customer_info.Customer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import food.Drink;
import food.Pizza;
import food.Side;
import list.JsonController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {

    // order variable creation:
    Customer customer;
    String customerPhoneNumber;
    Pizza pizza;

    // lists to hold menu items:
    List<Pizza> pizzaList = new ArrayList<>();
    List<Side> sideList = new ArrayList<>();
    List<Drink> drinkList = new ArrayList<>();
    float price = 0f;

    // if true = pickup, if false = deliver:
    Boolean orderType;
    int orderID;
    // static order counter updated in the constructor for every new order:
    public static int nextOrderID = 1;

    // management.Order overloaded constructor:
    public Order(Customer customer, Boolean orderType) {
        this.customer = customer;
        this.customerPhoneNumber = customer.getPhoneNumber();
        this.orderType = orderType;
        orderID = nextOrderID;
        nextOrderID++;
    }

    // getters and setters for customer:
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    // getters and setters for menu items:
    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(Pizza pizza) {
        pizzaList.add(pizza);
        price += pizza.getPrice();
    }

    public List<Side> getSideList() {
        return sideList;
    }

    public void setSideList(Side side) {
        sideList.add(side);
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(Drink drink) {
        drinkList.add(drink);
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // getters and setters for customer orders:
    public Boolean getOrderType() {
        return orderType;
    }

    public void setOrderType(Boolean orderType) {
        this.orderType = orderType;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getNextOrderID() {
        return nextOrderID;
    }

    public void setNextOrderID(int nextOrderID) {
        Order.nextOrderID = nextOrderID;
    }

    // adds menu items in the cart:
    public boolean addToCart( boolean side, boolean drink) {
        return true;
    }

    // verifies customer order:
    public boolean confirmOrder(){
        return true;
    }

    // specifies customer payment method
    public String selectPaymentMethod(String userSelection){
        return userSelection;
    }

    // generates a receipt based on the customer's order:
    public void generateReceipt(){
    }

    // creates new customer orders within the system
    public static boolean createNewOrder(Customer customer, boolean orderType) throws IOException {

        Order order = new Order(customer, orderType);

        // re-writes the json file to add the new customer
        JsonController.orderList.add(order);

        JsonController.serializeAnOrderList(order);

        return true;
    }

    // adds the selected pizza into the pizzaList:
    public void addPizza(String pizzaType, String size) {
        pizzaList.add(new Pizza(pizzaType, size));
    }

    public void addSide(String sideSelection) {
        sideList.add(new Side(sideSelection));
    }

    // adds the selected drink into the drinkList:
    public void addDrink(String drink, String size) {
        drinkList.add(new Drink(drink, size));
    }

    // determines the total price for a customer order:
    public void calculatePrice(){
    }
}