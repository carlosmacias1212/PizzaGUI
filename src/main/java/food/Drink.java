package food;

import management.Menu;

public class Drink extends FoodItems {
    String size;

    //    Sets the drink type, size, and the price
    public Drink(String drinkType, String size) {
        if (drinkType.equalsIgnoreCase("coke")) {
            this.type = drinkType;
        } else if (drinkType.equalsIgnoreCase("dietCoke")) {
            this.type = drinkType;
        } else if (drinkType.equalsIgnoreCase("mountainDew")) {
            this.type = drinkType;
        } else if (drinkType.equalsIgnoreCase("sprite")) {
            this.type = drinkType;
        }

        setFoodName("drink");

        if (size.equalsIgnoreCase("small")) {
            this.size = size;
            price = Menu.getSmallDrink();

        } else if (size.equalsIgnoreCase("medium")) {
            this.size = size;
            price = Menu.getMediumDrink();
        } else if (size.equalsIgnoreCase("large")) {
            this.size = size;
            price = Menu.getLargeDrink();
        }
    }

    public Drink(String drinkType) {
        if (drinkType.equalsIgnoreCase("coke")) {
            this.type = drinkType;
        } else if (drinkType.equalsIgnoreCase("dietCoke")) {
            this.type = drinkType;
        } else if (drinkType.equalsIgnoreCase("mountainDew")) {
            this.type = drinkType;
        } else if (drinkType.equalsIgnoreCase("sprite")) {
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