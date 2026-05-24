import java.util.*;
import menu.*;
import restaurant.Food;
import role.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Food selectedFood = null;

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    MenuRepository menuRepository = new MenuRepository();
    Validator validator = new Validator();
    OrderService orderService = new OrderService();

    int category = 0;
    List<Food> chosenList = null;

    //1. 카테고리 선택
    while (true) {
      outputView.categoryMenu(); // 카테고리 메뉴 출력

      category = inputView.readCategoryNumber(); // 카테고리 번호 입력
      // 입력 에러(-1)가 감지되면 루프 상단으로 복귀
      if (category == -1) {
        outputView.reInput(); // 다시입력 출력
        continue;
      }
      // 입력값이 1, 2인지 판단을 Validator확인
      if (validator.isValidCategory(category)) {
        //해당하는 메뉴판 목록을 조회해옴
        chosenList = menuRepository.getMenusByCategory(category);
        break;
      }
      outputView.reInput();
    }


    //2. 카테로그-> 메뉴에서 음식 선택
    int menuChoice = 0;
    while (true) {
      // 카테고리 선택후 메뉴 출력
      outputView.menuBoard(chosenList);
      // 메뉴 음식 입력
      menuChoice = inputView.readMenuChoice();
      // 숫자가 아닌 입력 예외(-1) 검사
      if (menuChoice == -1) {
        outputView.reInput();
        continue;
      }
      //숫자 범위 검사 (고른 숫자가 1이상, 메뉴크기 이하)
      if (menuChoice >= 1 && menuChoice <= chosenList.size()) {
        break;
      }
      outputView.reInput();
    }

    Food baseFood = chosenList.get(menuChoice - 1); //메뉴고른거 넣기, 인덱스때문에 -1
    int option1 = 0;
    int option2 = 0;

    //2-1. 파스타 옵션의 음식
    if (category == 1) {
      while (true) {
        int maxRange = outputView.pastaOption1();
        option1 = inputView.readOptionNumber();
        if (option1 == -1) { //오류값 -1 반환했을때 방어막1
          outputView.reInput();
          continue;
        }
        if (option1 >= 1 && option1 <= maxRange) break; //여기서도 -1 걸러지지만 범위내의 값인지 한번더 확인 방어막2
        outputView.reInput();
      }
      while (true) {
        int maxRange = outputView.pastaOption2();
        option2 = inputView.readOptionNumber();
        if (option2 == -1) {
          outputView.reInput();
          continue;
        }
        if (option2 >= 1 && option2 <= maxRange) break;
        outputView.reInput();
      }

      // 2-2. 스테이크 옵션 선택 영역
    } else if (category == 2) {
      while (true) {
        int maxRange = outputView.steakOption1();
        option1 = inputView.readOptionNumber();
        if (option1 == -1) {
          outputView.reInput();
          continue;
        }
        if (option1 >= 1 && option1 <= maxRange) break;
        outputView.reInput();
      }
      while (true) {
        int maxRange = outputView.steakOption2();
        option2 = inputView.readOptionNumber();

        if (option2 == -1) {
          outputView.reInput();
          continue;
        }
        if (option2 >= 1 && option2 <= maxRange) break;
        outputView.reInput();
      }
    }

    //다양성으로 해결
    if (baseFood instanceof TomatoPasta) selectedFood = new TomatoPasta(option1, option2);
    else if (baseFood instanceof CreamPasta) selectedFood = new CreamPasta(option1, option2);
    else if (baseFood instanceof OilPasta) selectedFood = new OilPasta(option1, option2);
    else if (baseFood instanceof PorkSteak) selectedFood = new PorkSteak(option1, option2);
    else if (baseFood instanceof BeefSteak) selectedFood = new BeefSteak(option1, option2);




    // 3. 최종 주문 확인
    if (selectedFood != null) {
      outputView.printReceipt(selectedFood); // 🔴 한 줄로 명확하게 제어
    }
    sc.close();
  }
}