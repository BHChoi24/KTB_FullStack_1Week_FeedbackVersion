package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private final Scanner sc = new Scanner(System.in);

    private int readNextInt() {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            sc.nextLine(); // 버퍼에 남아있는 문자열 제거
            return -1;     // 찾아보니 -1이 사용자에게 에러 상태를 나타내는 것이라고 해서 반영
        }
    }

    // 카테고리 번호 입력 위임
    public int readCategoryNumber() {
        return readNextInt();
    }

    // 메뉴 번호 입력 위임
    public int readMenuChoice() {
        return readNextInt();
    }

    // 하위 옵션 번호 입력 위임
    public int readOptionNumber() {
        return readNextInt();
    }
}