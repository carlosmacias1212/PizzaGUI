package food;

import management.Menu;
import static management.Menu.*;
import java.util.List;

public class BYO extends FoodItems {
    // "Build Your Own" variables/attributes:
    String size;
    String crustType;
    String sauce;
    String cheese;
    List<String> toppings;

    // BYO overloaded constructor:
    public BYO(String sauce, String cheese, String size, String crustType, List<String> toppings) {
        if (size.equalsIgnoreCase(SMALL)) {
            this.size = size;
            price = Menu.getSmallSpecialtyPizza();
        }
        else if (size.equalsIgnoreCase(MEDIUM)){
            this.size = size;
            price = Menu.getMediumSpecialtyPizza();
        }
        else if (size.equalsIgnoreCase(LARGE)){
            this.size = size;
            price = Menu.getLargeSpecialtyPizza();
        }

        this.type = "custom";
        this.crustType = crustType;
        this.sauce = sauce;
        this.cheese = cheese;
        this.toppings = toppings;
        price = price + calcToppingPrice();

        setPrice(price);
        setFoodName("pizza");
    }

    // determines the total price for toppings for BYO:
    public float calcToppingPrice(){
        return (.50f * toppings.size());}

    // getters and setters for BYO:
    public String getPizzaType() {
        return type;
    }

    public String getCrustType() {
        return crustType;
    }

    public void setCrustType(String crustType) {
        this.crustType = crustType;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}