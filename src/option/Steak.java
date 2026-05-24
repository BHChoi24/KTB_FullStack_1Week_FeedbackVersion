package option;

import restaurant.Food;

public class Steak extends Food {

    public static final String[] STEAK_STYLES = {"챱스테이크", "통스테이크"};
    public static final String[] STEAK_DONENESS = {"레어", "미디움 레어", "미디움", "미디움 웰던", "웰던"};

    String steakStyle;
    String steakDoneness; // 굽기 정도

    //메뉴판용
    public Steak(String foodName, int price) {
        super(foodName, price);
    }

    public Steak(String foodName, int price, int styleChoice, int donenessChoice) {
        super(foodName, price);

        if (styleChoice >= 1 && styleChoice <= STEAK_STYLES.length) {
            this.steakStyle = STEAK_STYLES[styleChoice - 1];
        } else {
            this.steakStyle = "기본 통스테이크"; //나올일없긴해
        }

        if (donenessChoice >= 1 && donenessChoice <= STEAK_DONENESS.length) {
            this.steakDoneness = STEAK_DONENESS[donenessChoice - 1];
        } else {
            this.steakDoneness = "기본굽기(미디움)"; //나올일없긴해
        }
    }

    @Override
    public void cook() {
        super.cook();
        System.out.println("[옵션] 스타일: " + steakStyle + " | 굽기정도 : " + steakDoneness);
    }
}