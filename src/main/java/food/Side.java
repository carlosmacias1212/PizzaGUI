package food;

import management.Menu;
import static management.Menu.*;

public class Side extends FoodItems {
    // side variable/attribute:
    String sideSelection;

    // side overloaded constructor:
    public Side(String sideSelection){
        if(sideSelection.equalsIgnoreCase(WINGS)){
            this.type = sideSelection;
            price = Menu.getWings();
        }
        else if(sideSelection.equalsIgnoreCase(BREAD_STICKS)){
            this.type = sideSelection;
            price = Menu.getBreadSticks();
        }
        else if(sideSelection.equalsIgnoreCase(GARLIC_KNOTS)){
            this.type = sideSelection;
            price = Menu.getGarlicKnots();
        }
        else if(sideSelection.equalsIgnoreCase(BONELESS_WINGS)){
            this.type = sideSelection;
            price = Menu.getBonelessWings();
        }

        setFoodName("side");
    }

    // getters and setters for side:
    public String getSideSelection() {
        return sideSelection;
    }

    public void setSideSelection(String sideSelection) {
        this.sideSelection = sideSelection;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}