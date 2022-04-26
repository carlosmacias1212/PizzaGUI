package food;

import management.Menu;

public class Drink {
    // drink variable creation:
    String drinkType;
    String size;
    private float price = 0;

    // constructor and getters and setters for "Drink":
    public Drink(String drinkType, String size) {
        if (drinkType.equalsIgnoreCase("coke")) {
            this.drinkType = drinkType;
        } else if (drinkType.equalsIgnoreCase("diet coke")) {
            this.drinkType = drinkType;
        } else if (drinkType.equalsIgnoreCase("mountain dew")) {
            this.drinkType = drinkType;
        } else if (drinkType.equalsIgnoreCase("sprite")) {
            this.drinkType = drinkType;
        }

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

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
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