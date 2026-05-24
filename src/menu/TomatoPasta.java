package menu;

import option.Pasta;

public class TomatoPasta extends Pasta {
    public TomatoPasta() {
        super("토마토 파스타", 9500);
    }
    public TomatoPasta(int noodleChoice, int noodleDonenessChoice) {
        super("토마토 파스타", 9500, noodleChoice, noodleDonenessChoice);
    }
}
