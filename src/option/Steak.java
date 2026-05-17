package option;

import restaurant.Food;

public class Steak extends Food {
    String steakStyle;
    String steakDoneness; // 굽기 정도

    public Steak(String foodName, int price, int styleChoice, int donenessChoice) {
        // 조부모 클래스인 Food에게 고정 메뉴명과 고정 가격을 안전하게 전달
        super(foodName, price);

        if (styleChoice == 1) {
            this.steakStyle = "챱스테이크";
        } else if (styleChoice == 2) {
            this.steakStyle = "통스테이크";
        } else {
            this.steakStyle = "기본 통스테이크";
        }

        if (donenessChoice == 1) {
            this.steakDoneness = "레어";
        } else if (donenessChoice == 2) {
            this.steakDoneness = "미디움 레어";
        } else if (donenessChoice == 3) {
            this.steakDoneness = "미디움";
        } else if (donenessChoice == 4) {
            this.steakDoneness = "미디움 웰던";
        } else if (donenessChoice == 5) {
            this.steakDoneness = "웰던";
        } else {
            this.steakDoneness = "기본굽기(미디움)";
        }
    }

    @Override
    public void cook() {
        super.cook();

        // 손님이 옵션 출력
        System.out.println("[옵션] 스타일: " + steakStyle + " | 굽기정도 : " + steakDoneness);
    }
}