package menu;

import option.Pasta;

public class OilPasta extends Pasta {
    public OilPasta() {
        super("알리오 올리오", 7000);
    }
    public OilPasta(int noodleChoice, int noodleDonenessChoice) {
        super("알리오 올리오", 7000, noodleChoice, noodleDonenessChoice);
    }
}
