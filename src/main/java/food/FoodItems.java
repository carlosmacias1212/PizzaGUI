package food;

public class FoodItems {
        String foodName;
        String size;
        float price;


        public void setFoodName(String food) {
            foodName = food;
        }

        public String getFoodName() {
            return foodName;
        }
        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public void setPrice(float p) {
            price = p;
        }

        public float getPrice() {
            return price;
        }

        public String toString(){
            System.out.println("Item: " + foodName);
            return "Price: " + price;
        }


}
