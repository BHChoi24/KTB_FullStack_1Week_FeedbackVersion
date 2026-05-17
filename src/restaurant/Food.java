package restaurant;

public class Food {
    String foodName;
    int price;

    public Food(String foodName, int price){
        this.foodName = foodName;
        this.price = price;
    }
    public void cook() {
        System.out.println("요리 접수");
    }
    //메뉴량 총 가격 반환
    public String getFoodName(){
        return foodName;
    }
    public int getPrice(){
        return price;
    }

}