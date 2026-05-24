package role;

import java.util.*;
import menu.*;
import restaurant.Food;

//메뉴리스트 저장 클래스
public class MenuRepository {
    // 파스타와 스테이크 메뉴를 보관할 리스트 정의 (외부 변경 방지를 위해 private final)
    private final List<Food> pastaMenu = new ArrayList<>();
    private final List<Food> steakMenu = new ArrayList<>();

    // 메뉴판
    public MenuRepository() {
        //파스타
        pastaMenu.add(new TomatoPasta(0, 0));
        pastaMenu.add(new CreamPasta(0, 0));
        pastaMenu.add(new OilPasta(0, 0));
        //스테이크
        steakMenu.add(new PorkSteak(0, 0));
        steakMenu.add(new BeefSteak(0, 0));
    }
    //메뉴판 카테고리 1,2
    public List<Food> getMenusByCategory(int category) {
        if (category == 1) {
            return pastaMenu;
        } else if (category == 2) {
            return steakMenu;
        }
        return new ArrayList<>(); // 에러 방지를 위한 빈 리스트 반환
    }
}