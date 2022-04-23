package food;

import management.Menu;

import java.util.List;

import static management.Menu.*;

public class Pizza extends FoodItems {

    String pizzaType;
    String size;

    public Pizza(String pizzaType, String size){
        if (size.equalsIgnoreCase(SMALL)) {
            this.pizzaType = pizzaType;
            this.size = size;
            price = Menu.getSmallSpecialtyPizza();
        }
        else if (size.equalsIgnoreCase(MEDIUM)){
            this.pizzaType = pizzaType;
            this.size = size;
            price = Menu.getMediumSpecialtyPizza();
        }
        else if (size.equalsIgnoreCase(LARGE)){
            this.pizzaType = pizzaType;
            this.size = size;
            price = Menu.getLargeSpecialtyPizza();
        }
        else if (size.equalsIgnoreCase(XLARGE)){
            this.pizzaType = pizzaType;
            this.size = size;
            price = Menu.getXtraLargeSpecialtyPizza();
        }

        setFoodName(pizzaType);
    }

    //This constructor is a constructor used in food.BYO so that PizzaType is not needed
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