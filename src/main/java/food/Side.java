package food;

import management.Menu;

public class Side extends FoodItems {
    String sideSelection;

    public Side(String sideSelection){
        if(sideSelection.equalsIgnoreCase("wings")){
            this.type = sideSelection;
            price = Menu.getWings();
        }
        else if(sideSelection.equalsIgnoreCase("breadSticks")){
            this.type = sideSelection;
            price = Menu.getBreadSticks();
        }
        else if(sideSelection.equalsIgnoreCase("garlicKnots")){
            this.type = sideSelection;
            price = Menu.getGarlicKnots();
        }
        else if(sideSelection.equalsIgnoreCase("bonelessWings")){
            this.type = sideSelection;
            price = Menu.getBonelessWings();
        }

        setFoodName("side");
    }

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