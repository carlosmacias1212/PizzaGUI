package food;

import management.Menu;

import static management.Menu.*;

public class Drink extends FoodItems {
    String size;

    //    Sets the drink type, size, and the price
    public Drink(String drinkType, String size) {
        if (drinkType.equalsIgnoreCase(COKE)) {
            this.type = drinkType;
        } else if (drinkType.equalsIgnoreCase(DIET_COKE)) {
            this.type = drinkType;
        } else if (drinkType.equalsIgnoreCase(DR_PEPPER)) {
            this.type = drinkType;
        } else if (drinkType.equalsIgnoreCase(SPRITE)) {
            this.type = drinkType;
        } else if (drinkType.equalsIgnoreCase(BEER)){
            this.type = drinkType;
        }

        setFoodName("drink");

        if (size.equalsIgnoreCase(SMALL)) {
            this.size = size;
            price = Menu.getSmallDrink();

        } else if (size.equalsIgnoreCase(MEDIUM)) {
            this.size = size;
            price = Menu.getMediumDrink();
        } else if (size.equalsIgnoreCase(LARGE)) {
            this.size = size;
            price = Menu.getLargeDrink();
        }
    }

    public Drink(String drinkType) {
        if (drinkType.equalsIgnoreCase(COKE)) {
            this.type = drinkType;
        } else if (drinkType.equalsIgnoreCase(DIET_COKE)) {
            this.type = drinkType;
        } else if (drinkType.equalsIgnoreCase(DR_PEPPER)) {
            this.type = drinkType;
        } else if (drinkType.equalsIgnoreCase(SPRITE)) {
            this.type = drinkType;
        }
        setFoodName("drink");
    }

    public String getDrinkType() {
        return type;
    }

    public void setDrinkType(String drinkType) {
        this.type = drinkType;
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