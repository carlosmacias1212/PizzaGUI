package management;

import customer_info.Customer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import food.Drink;
import food.FoodItems;
import food.Pizza;
import food.Side;
import list.JsonController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    // instantiates a list of food items to store customer order specifications:
    public List<FoodItems> items = new ArrayList<FoodItems>();

    // order variables/attributes:
    float orderTotal;
    String payment = "";
    String customerPhone;
    Boolean pickup;
    int orderID;

    // order overloaded constructor:
    public Order(String phone, Boolean pickup) {
        customerPhone = phone;
        this.pickup = pickup;

        JsonController controller = new JsonController();
        orderID = controller.orderList.size();

    }

    public Order() {
    }

    // getters and setters for order:
    public String getCustomerPhoneNumber() {
        return customerPhone;
    }
    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhone = customerPhoneNumber;
    }
    public float getPrice() {
        return orderTotal;
    }
    public void setPrice() {
        this.orderTotal = calculatePrice();
    }
    public List<FoodItems> getCart() {
        return items;
    }
    public Boolean getOrderType() {
        return pickup;
    }
    public void setOrderType(Boolean orderType) {
        this.pickup = orderType;
    }
    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    // adds food items into the system's cart:
    public boolean addToCart(List<FoodItems> add){
        for (FoodItems cart: add) {
            items.add(cart);
        }
        return true;
    }

    // returns true to confirm customer orders:
    public boolean confirmOrder(){
        return true;
    }

    // sets payment type to the specified customer payment method selection:
    public void selectPaymentMethod(String userSelection){

        payment = userSelection;
    }

    // generates customer receipt from order(s):
    public String[][] generateReceipt(){

        String[][] itemsPlusPrice = new String[items.size() + 2][2];

        for(int i = 0; i < itemsPlusPrice.length - 2; i++) {

            itemsPlusPrice[i][0] = items.get(i).getFoodName();
            itemsPlusPrice[i][1] = String.valueOf(items.get(i).getPrice());
        }

        itemsPlusPrice[items.size()][0] = "Order Total:";
        itemsPlusPrice[items.size()][1] = String.valueOf(orderTotal);

        if (payment.equals("credit")) {

            itemsPlusPrice[items.size() + 1][0] = "Sign Here: ";
            itemsPlusPrice[items.size() + 1][1] = "_________";
        }
        return itemsPlusPrice;
    }

    // sets the total price for a customer's order:
    public void setOrderTotal() {
        orderTotal = calculatePrice();
    }

    // determines the total price for a customer's order:
    public float calculatePrice(){

        float p = 0;
        for (FoodItems f: items) {
            p += f.getPrice();
        }
        return p;
    }

    // getters and setters for order:
    public String getPayment() { return payment; }

    public void setPayment(String payment) { this.payment = payment; }

    // indicates whether if a customer order is for pick-up or delivery:
    public static boolean isPickup(String orderType){
        return orderType.equals("Pick-up");
    }
}