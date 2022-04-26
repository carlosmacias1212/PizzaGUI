package food;

import management.Menu;

import java.util.List;

public class BYO extends FoodItems {
    String size;
    String crustType;
    String sauce;
    String cheese;
    List<String> toppings;

    public BYO(String sauce, String cheese, String size, String crustType, List<String> toppings) {
        if (size.equalsIgnoreCase("small")) {
            this.size = size;
            price = Menu.getSmallSpecialtyPizza();
        }
        else if (size.equalsIgnoreCase("medium")){
            this.size = size;
            price = Menu.getMediumSpecialtyPizza();
        }
        else if (size.equalsIgnoreCase("large")){
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

    public float calcToppingPrice(){
        return (.50f * toppings.size());}

    public String getPizzaType() {
        return type;
    }

    public String getSize() { return size;}

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


    public void setSize(String size) {
        this.size = size;
    }
}


