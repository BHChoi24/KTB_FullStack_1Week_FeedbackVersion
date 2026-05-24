package role;

import restaurant.Food;
import java.util.List;

public class OutputView {

    private final String[] pastaNoodles = {"스파게티 면", "링귀니 면", "부카티니 면"};
    private final String[] pastaDoneness = {"단단하게", "보통", "부드럽게"};
    private final String[] steakStyles = {"챱스테이크", "통스테이크"};
    private final String[] steakDoneness = {"레어", "미디움 레어", "미디움", "미디움 웰던", "웰던"};

    //실행 첫화면 카테고리
    public void categoryMenu(){
        System.out.println("=== 레스토랑 키오스크 시스템 ===");
        System.out.println("1. 파스타 라인업");
        System.out.println("2. 스테이크 라인업");
        System.out.print("원하시는 카테고리 번호를 누르세요: ");
    }
    //카테고리의 메뉴
    public void menuBoard(List<Food> chosenList) {
        // 1. 전달받은 리스트의 크기만큼 반복하며 메뉴명과 가격 출력
        for (int i = 0; i < chosenList.size(); i++) {
            System.out.println((i + 1) + ". " + chosenList.get(i).getFoodName() + " (" + chosenList.get(i).getPrice() + "원)");
        }
        System.out.print("메뉴 번호를 고르세요: ");
    }

    public int pastaOption1(){
        System.out.println("\n--- [옵션 1] 면 종류 선택 ---");
        for (int i = 0; i < pastaNoodles.length; i++) {
            System.out.print((i + 1) + ". " + pastaNoodles[i]); //메뉴 양만큼 출력
            if (i < pastaNoodles.length - 1) System.out.print(" | "); //마지막 부분은 |출력 안되도록
        }
        System.out.print("\n번호 입력: ");
        return pastaNoodles.length;
    }

    public int pastaOption2() {
        System.out.println("\n--- [옵션 2] 면 익힘 정도 선택 ---");
        for (int i = 0; i < pastaDoneness.length; i++) {
            System.out.print((i + 1) + ". " + pastaDoneness[i]);
            if (i < pastaDoneness.length - 1) System.out.print(" | ");
        }
        System.out.print("\n번호 입력: ");
        return pastaDoneness.length;
    }

    // [스테이크 옵션 1] 출력 및 크기 반환
    public int steakOption1() {
        System.out.println("\n--- [옵션 1] 스테이크 스타일 선택 ---");
        for (int i = 0; i < steakStyles.length; i++) {
            System.out.print((i + 1) + ". " + steakStyles[i]);
            if (i < steakStyles.length - 1) System.out.print(" | ");
        }
        System.out.print("\n번호 입력: ");
        return steakStyles.length; // 🔴 배열의 크기(2)를 동적으로 반환!
    }

    // [스테이크 옵션 2] 출력 및 크기 반환
    public int steakOption2() {
        System.out.println("\n--- [옵션 2] 고기 굽기 정도 선택 ---");
        for (int i = 0; i < steakDoneness.length; i++) {
            System.out.print((i + 1) + ". " + steakDoneness[i]);
            if (i < steakDoneness.length - 1) System.out.print(" | ");
        }
        System.out.print("\n번호 입력: ");
        return steakDoneness.length; // 🔴 배열의 크기(5)를 동적으로 반환!
    }

    public void reInput(){
        System.out.println("\n잘못된 값입니다. 다시 입력해주세요\n");
    }

    public void printReceipt(Food selectedFood) {
        System.out.println("\n====================================");
        System.out.println("[주문서 출력] 선택하신 메뉴 정보");
        System.out.println("메뉴명: " + selectedFood.getFoodName());
        System.out.println("금  액: " + selectedFood.getPrice() + "원");

        // 다형성에 의해 각 자식 클래스(TomatoPasta, BeefSteak 등)의 cook()이 실행됨
        selectedFood.cook();

        System.out.println("====================================");
    }
}
