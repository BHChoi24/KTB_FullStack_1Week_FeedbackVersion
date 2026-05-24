package menu;

import option.Steak;

public class BeefSteak extends Steak {
    public BeefSteak() {
        super("비프 스테이크", 35000);
    }
    public BeefSteak(int styleChoice, int donenessChoice) {
        // 이름과 고정 가격은 기존 비프 스테이크의 정체성을 유지합니다.
        super("비프 스테이크", 35000, styleChoice, donenessChoice);
    }
}