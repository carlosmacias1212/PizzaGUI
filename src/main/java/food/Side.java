package food;

import management.Menu;

public class Side {
    // side variable creation:
    String sideSelection;
    private float price = 0;
    private float wings = 1.00f;

    // constructor and getters and setters for "Side":
    public Side(String sideSelection){
        if(sideSelection.equalsIgnoreCase("wings")){
            this.sideSelection = sideSelection;
            price = Menu.getWings();
        }
        else if(sideSelection.equalsIgnoreCase("breadSticks")){
            this.sideSelection = sideSelection;
            price = Menu.getBreadSticks();
        }
        else if(sideSelection.equalsIgnoreCase("garlicKnots")){
            this.sideSelection = sideSelection;
            price = Menu.getGarlicKnots();
        }
        else if(sideSelection.equalsIgnoreCase("bonelessWings")){
            this.sideSelection = sideSelection;
            price = Menu.getBonelessWings();
        }
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

    public float getWings() {
        return wings;
    }

    public void setWings(float wings) {
        this.wings = wings;
    }
}