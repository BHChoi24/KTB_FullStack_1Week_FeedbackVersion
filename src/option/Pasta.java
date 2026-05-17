package option;

import restaurant.Food;

public class Pasta extends Food {

    String noodleType;
    String noodleDoneness;

    public Pasta(String foodName, int price, int noodleChoice, int noodleDonenessChoice) {
        super(foodName, price);

        if(noodleChoice == 1){
            this.noodleType = "스파케티";
        } else if (noodleChoice == 2){
            this.noodleType = "링귀니";
        } else if (noodleChoice == 3){
            this. noodleType = "부카디니";
        } else {
            this.noodleType = "기본 면 스파케티";
        }

        if (noodleDonenessChoice == 1){
            this.noodleDoneness = "단단하게 (알단테)";
        } else if (noodleChoice == 2){
            this.noodleDoneness = "보통 (단테)";
        } else if (noodleChoice == 3){
            this.noodleDoneness = "부드렵게 (벤코토)";
        } else {
            this.noodleDoneness = "기본 익힘(보통)"; // 1,2,3 외의 값이 들어올 때를 대비한 else
        }

    }
    @Override
    public void cook(){
        super.cook();
        System.out.println("[옵션] 면 종류 : " + noodleType + " | 익힘 정도 ; " + noodleDoneness);
    }
}