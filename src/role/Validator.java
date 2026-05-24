package role;

//Validator 뜻 : 확인자, 검증자 (validation 확인 + er)
public class Validator {

    //카테고리 1,2번 확인하고반환
    public boolean isValidCategory(int category) {
        return category == 1 || category == 2;
    }

    /**
     * 선택한 메뉴 번호가 존재하는 범위 내의 숫자인지 검사
     * @param choice 사용자가 입력한 번호
     * @param maxRange 해당 메뉴판 리스트의 최대 크기(size)
     */
    //메뉴 선택
    public boolean isValidMenuChoice(int choice, int maxRange) {
        return choice >= 1 && choice <= maxRange;
    }

    //파스타 하위 옵션 번호 검사 (1~3 범위 확인)
    public boolean isValidPastaOption(int option) {
        return option >= 1 && option <= 3;
    }

    //스테이크 스타일 옵션 번호 검사 (1~2 범위 확인)
    public boolean isValidSteakStyleOption(int option) {
        return option >= 1 && option <= 2;
    }

    //스테이크 굽기 옵션 번호 검사 (1~5 범위 확인)
    public boolean isValidSteakDonenessOption(int option) {
        return option >= 1 && option <= 5;
    }
}