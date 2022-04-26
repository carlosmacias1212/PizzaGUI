package food;

public class FoodItems {
    // food item variables/attributes:
    String foodName;
    String type;
    float price;

    // getters and setters for food items:
    public void setFoodName(String food) {
        foodName = food;
    }
    public String getFoodName() {
        return foodName;
    }
    public void setPrice(float p) {
        price = p;
    }
    public float getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    // returns a string displaying the current food item/price:
    public String toString(){
            System.out.println("Item: " + foodName);
            return "Price: " + price;
        }
}