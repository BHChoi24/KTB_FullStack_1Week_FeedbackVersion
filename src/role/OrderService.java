package role;

import menu.*;
import restaurant.Food;

public class OrderService {

    /**
     * 사용자가 선택한 기본 음식(baseFood)의 실제 하위 타입을 판별하여
     * 사용자가 입력한 최종 옵션을 주입한 완성된 요리 객체를 생성 및 반환함
     * (Main에 있던 instanceof 조건문들을 이 안으로 격리)
     */
    public Food createSelectedFood(Food baseFood, int option1, int option2) {
        if (baseFood instanceof TomatoPasta) return new TomatoPasta(option1, option2);
        if (baseFood instanceof CreamPasta) return new CreamPasta(option1, option2);
        if (baseFood instanceof OilPasta) return new OilPasta(option1, option2);
        if (baseFood instanceof PorkSteak) return new PorkSteak(option1, option2);
        if (baseFood instanceof BeefSteak) return new BeefSteak(option1, option2);
        return null; // 매칭 실패 시 안전을 위해 null 반환
    }
}