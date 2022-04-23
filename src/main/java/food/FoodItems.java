package food;

public class FoodItems {
    String foodName;
    String type;
    float price;

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
}
