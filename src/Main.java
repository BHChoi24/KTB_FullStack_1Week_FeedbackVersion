import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import menu.*;
import restaurant.Food;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Food selectedFood = null;

    // 가게 메뉴판 등록 (List 활용(추후 더 이해하기))
    List<Food> pastaMenu = new ArrayList<>();
    pastaMenu.add(new TomatoPasta(0, 0));
    pastaMenu.add(new CreamPasta(0, 0));
    pastaMenu.add(new OilPasta(0, 0));

    List<Food> steakMenu = new ArrayList<>();
    steakMenu.add(new PorkSteak(0, 0));
    steakMenu.add(new BeefSteak(0, 0));

    //카테고리 메뉴
    int category = 0;
    List<Food> chosenList = null;

    //예외수 일때 반복하기위해서 사용함
    while (true) {
      System.out.println("=== 레스토랑 키오스크 시스템 ===");
      System.out.println("1. 파스타 라인업");
      System.out.println("2. 스테이크 라인업");
      System.out.print("원하시는 카테고리 번호를 누르세요: ");
      category = sc.nextInt();

      if (category == 1) {
        System.out.println("\n--- 파스타 메뉴 선택 ---");
        chosenList = pastaMenu;
        break;
      } else if (category == 2) {
        System.out.println("\n--- 스테이크 메뉴 선택 ---");
        chosenList = steakMenu;
        break;
      }
      System.out.println("잘못된 카테고리 번호입니다. 다시 선택해주세요.\n");
    }

    int menuChoice = 0;
    while (true) {
      for (int i = 0; i < chosenList.size(); i++) {
        System.out.println((i + 1) + ". " + chosenList.get(i).getFoodName() + " (" + chosenList.get(i).getPrice() + "원)");
      }
      System.out.print("메뉴 번호를 고르세요: ");
      menuChoice = sc.nextInt();

      if (menuChoice >= 1 && menuChoice <= chosenList.size()) {
        break;
      }
      System.out.println("존재하지 않는 메뉴 번호입니다. 다시 골라주세요.\n");
    }

    Food baseFood = chosenList.get(menuChoice - 1);
    int option1 = 0;
    int option2 = 0;

    if (category == 1) {
      while (true) {
        System.out.println("\n--- [옵션 1] 면 종류 선택 ---");
        System.out.println("1. 스파게티 면 | 2. 링귀니 면 | 3. 부카티니 면");
        System.out.print("번호 입력: ");
        option1 = sc.nextInt();

        if (option1 >= 1 && option1 <= 3) break;
        System.out.println("없는 선택지입니다. 1~3번 사이로 다시 입력하세요.");
      }

      while (true) {
        System.out.println("\n--- [옵션 2] 면 익힘 정도 선택 ---");
        System.out.println("1. 단단하게 | 2. 보통 | 3. 부드럽게");
        System.out.print("번호 입력: ");
        option2 = sc.nextInt();

        if (option2 >= 1 && option2 <= 3) break;
        System.out.println("없는 선택지입니다. 1~3번 사이로 다시 입력하세요.");
      }

    } else if (category == 2) {
      while (true) {
        System.out.println("\n--- [옵션 1] 스테이크 스타일 선택 ---");
        System.out.println("1. 챱스테이크 | 2. 통스테이크");
        System.out.print("번호 입력: ");
        option1 = sc.nextInt();

        if (option1 >= 1 && option1 <= 2) break;
        System.out.println("없는 선택지입니다. 1~2번 사이로 다시 입력하세요.");
      }

      while (true) {
        System.out.println("\n--- [옵션 2] 고기 굽기 정도 선택 ---");
        System.out.println("1. 레어 | 2. 미디움 레어 | 3. 미디움 | 4. 미디움 웰던 | 5. 웰던");
        System.out.print("번호 입력: ");
        option2 = sc.nextInt();

        if (option2 >= 1 && option2 <= 5) break;
        System.out.println("없는 선택지입니다. 1~5번 사이로 다시 입력하세요.");
      }
    }

    // instanceof 연산자 객체의 클래스확인, 상속 클래스 확인 등등(활용하면서 간단하게 넘어갔지만 나중에 정확하게 알아보기)
    if (baseFood instanceof TomatoPasta) selectedFood = new TomatoPasta(option1, option2);
    else if (baseFood instanceof CreamPasta) selectedFood = new CreamPasta(option1, option2);
    else if (baseFood instanceof OilPasta) selectedFood = new OilPasta(option1, option2);
    else if (baseFood instanceof PorkSteak) selectedFood = new PorkSteak(option1, option2);
    else if (baseFood instanceof BeefSteak) selectedFood = new BeefSteak(option1, option2);

    // 최종 주문 확인
    if (selectedFood != null) {
      System.out.println("\n====================================");
      System.out.println("[주문서 출력] 선택하신 메뉴 정보");
      System.out.println("메뉴명: " + selectedFood.getFoodName());
      System.out.println("금  액: " + selectedFood.getPrice() + "원");
      selectedFood.cook();
      System.out.println("====================================");
    }

    sc.close();
  }
}