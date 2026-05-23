import java.util.*;
import menu.*;
import restaurant.Food;
import view.OutputView;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Food selectedFood = null;

    //OutView
    OutputView outputView = new OutputView();

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
    //1. 카테고리 선택
    while (true) {
      outputView.categoryMenu();

      try {
        category = sc.nextInt();
      } catch (InputMismatchException e){ //숫자 이외의 값 잡기
        outputView.reInput();
        sc.nextLine(); // 다시 입력하기 위해 버퍼 비워주기
        category = -1; // 찾아보니 해당인텓스가 없을때 -1을 개발자에게 의도를 드러내는 뜻(에러상태임을 전달)
        continue;
      }

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

    //2. 카테고리에서 고른 옵션으로 넘어가 음식 종류 선택
    int menuChoice = 0;
    while (true) {
      for (int i = 0; i < chosenList.size(); i++) {
        System.out.println((i + 1) + ". " + chosenList.get(i).getFoodName() + " (" + chosenList.get(i).getPrice() + "원)");
      }
      System.out.print("메뉴 번호를 고르세요: ");


      try {
        menuChoice = sc.nextInt();
      } catch (InputMismatchException e){ //숫자 이외의 값 잡기
        sc.nextLine(); // 다시 입력하기 위해 버퍼 비워주기
        menuChoice = -1;
        continue;
      }

      if (menuChoice >= 1 && menuChoice <= chosenList.size()) {
        break;
      }
      outputView.reInput();
    }

    Food baseFood = chosenList.get(menuChoice - 1);
    int option1 = 0;
    int option2 = 0;

    //2-1. 파스타 옵션
    if (category == 1) {
      while (true) {
        outputView.pastaOption1();

        try {
          option1 = sc.nextInt();
        } catch (InputMismatchException e){
          sc.nextLine();
          option1 = -1;
          continue;
        }
        if (option1 >= 1 && option1 <= 3) break;
        outputView.reInput();
      }

      while (true) {
        outputView.pastaOption2();

        try {
          option2 = sc.nextInt();
        } catch (InputMismatchException e){ //숫자 이외의 값 잡기
          sc.nextLine(); // 다시 입력하기 위해 버퍼 비워주기
          option1 = -1;
          continue;
        }

        if (option2 >= 1 && option2 <= 3) break;
        outputView.reInput();
      }

      //2-2. 스테이크 옵션
    } else if (category == 2) {
      while (true) {
        outputView.steakOption1();

        try {
          option1 = sc.nextInt();
        } catch (InputMismatchException e){ //숫자 이외의 값 잡기
          sc.nextLine(); // 다시 입력하기 위해 버퍼 비워주기
          option1 = -1;
          continue;
        }

        if (option1 >= 1 && option1 <= 2) break;
        outputView.reInput();
      }

      while (true) {
        outputView.steakOption2();

        try {
          option2 = sc.nextInt();
        } catch (InputMismatchException e){ //숫자 이외의 값 잡기
          sc.nextLine(); // 다시 입력하기 위해 버퍼 비워주기
          option1 = -1;
          continue;
        }

        if (option2 >= 1 && option2 <= 5) break;
        outputView.reInput();
      }
    }

    // instanceof 연산자 객체의 클래스확인, 상속 클래스 확인 등등(활용하면서 간단하게 넘어갔지만 나중에 정확하게 알아보기)
    if (baseFood instanceof TomatoPasta) selectedFood = new TomatoPasta(option1, option2);
    else if (baseFood instanceof CreamPasta) selectedFood = new CreamPasta(option1, option2);
    else if (baseFood instanceof OilPasta) selectedFood = new OilPasta(option1, option2);
    else if (baseFood instanceof PorkSteak) selectedFood = new PorkSteak(option1, option2);
    else if (baseFood instanceof BeefSteak) selectedFood = new BeefSteak(option1, option2);

    // 3. 최종 주문 확인
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