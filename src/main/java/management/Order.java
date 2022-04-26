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


    List<FoodItems> items = new ArrayList<FoodItems>();
    float orderTotal;
    String payment = "";
    String customerPhone;
    Boolean pickup;
    int orderID;

    public Order(String phone, Boolean pickup) {
        customerPhone = phone;
        this.pickup = pickup;

        JsonController controller = new JsonController();
        orderID = controller.orderList.size();

    }

    public Order() {

    }


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



    public boolean addToCart(List<FoodItems> add){
        for (FoodItems cart: add) {
            items.add(cart);
        }
        return true;
    }

    public void setCart(List<FoodItems> cart) {
        items = cart;

    }

    public boolean confirmOrder(){


        return true;
    }

    public void selectPaymentMethod(String userSelection){
        payment = userSelection;
    }

    public String[][] generateReceipt(){


        //create 2d array with rows as foodItem and 2 columns, column[0]-foodItemName, column[1]-foodItemPrice
        String[][] itemsPlusPrice = new String[items.size() + 2][3];

        String[][] receipt = new String[itemsPlusPrice.length + 2][3];


        receipt[0][0] = "Customer Phone:";
        receipt[0][1] = "";
        receipt[0][2] = this.customerPhone;

        receipt[1][0] = "Order Type: ";
        receipt[1][1] = "";
        receipt[1][2] = (this.pickup ? "pickup": "delivery");



        for(int i = 0; i < itemsPlusPrice.length - 2; i++) {

            itemsPlusPrice[i][0] = items.get(i).getFoodName();
            itemsPlusPrice[i][1] = items.get(i).getType();
            itemsPlusPrice[i][2] = "$" + items.get(i).getPrice();

        }

        itemsPlusPrice[items.size()][0] = "Order Total:";
        itemsPlusPrice[items.size()][1] = "";
        itemsPlusPrice[items.size()][2] = "$" + (orderTotal);



        if (payment.equals("credit")) {

            itemsPlusPrice[items.size() + 1][0] = "Sign Here: ";
            itemsPlusPrice[items.size() + 1][1] = "";
            itemsPlusPrice[items.size() + 1][2] = "_________________";
        }


        for (int i = 2; i < receipt.length; i++) {
            receipt[i][0] = itemsPlusPrice[i -2][0];
            receipt[i][1] = itemsPlusPrice[i - 2][1];
            receipt[i][2] = itemsPlusPrice[i - 2][2];
        }

        return receipt;



    }


    public void setOrderTotal() {
        orderTotal = calculatePrice();
    }
    public float calculatePrice(){
//        calculate total price for the order

        float p = 0;
        for (FoodItems f: items) {
            p += f.getPrice();
        }


        return p;

    }

    public float getOrderTotal() {
        return this.orderTotal;
    }

    public static boolean isPickup(String orderType){
        return orderType.equals("Pick-up");
    }

    public void setPayment(String card_payment) {
        this.payment = card_payment;
    }
}

