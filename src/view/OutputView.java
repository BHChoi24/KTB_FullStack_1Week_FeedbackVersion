package view;

public class OutputView {

    public void categoryMenu(){
        System.out.println("=== 레스토랑 키오스크 시스템 ===");
        System.out.println("1. 파스타 라인업");
        System.out.println("2. 스테이크 라인업");
        System.out.print("원하시는 카테고리 번호를 누르세요: ");
    }

    public void pastaOption1(){
        System.out.println("\n--- [옵션 1] 면 종류 선택 ---");
        System.out.println("1. 스파게티 면 | 2. 링귀니 면 | 3. 부카티니 면");
        System.out.print("번호 입력: ");

    }public void pastaOption2(){
        System.out.println("\n--- [옵션 2] 면 익힘 정도 선택 ---");
        System.out.println("1. 단단하게 | 2. 보통 | 3. 부드럽게");
        System.out.print("번호 입력: ");
    }

    public void steakOption1(){
        System.out.println("\n--- [옵션 1] 스테이크 스타일 선택 ---");
        System.out.println("1. 챱스테이크 | 2. 통스테이크");
        System.out.print("번호 입력: ");
    }
    public void steakOption2(){
        System.out.println("\n--- [옵션 2] 고기 굽기 정도 선택 ---");
        System.out.println("1. 레어 | 2. 미디움 레어 | 3. 미디움 | 4. 미디움 웰던 | 5. 웰던");
        System.out.print("번호 입력: ");
    }

    public void reInput(){
        System.out.println("\n잘못된 값입니다. 다시 입력해주세요\n");
    }
}
