package food;

import management.Menu;
import java.util.List;

public class Pizza {
    // pizza variable creation:
    String pizzaType;
    String size;
    private float price = 0;

    public Pizza(){
    }

    // constructor and getters and setters for "Pizza":
    public Pizza(String pizzaType, String size){
        if (size.equalsIgnoreCase("small")) {
            this.pizzaType = pizzaType;
            this.size = size;
            price = Menu.getSmallSpecialtyPizza();
        }
        else if (size.equalsIgnoreCase("medium")){
            this.pizzaType = pizzaType;
            this.size = size;
            price = Menu.getMediumSpecialtyPizza();
        }
        else if (size.equalsIgnoreCase("large")){
            this.pizzaType = pizzaType;
            this.size = size;
            price = Menu.getLargeSpecialtyPizza();
        }
    }

    // this constructor is used in food.BYO so that PizzaType is not needed:
    public Pizza(String size){
        this.size = size;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}