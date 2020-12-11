package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputFunctionNumber() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextLine();
    }

    public static String inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextLine();
    }

    public static String inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return scanner.nextLine();
    }

    public static String inputMenuQuantity() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return scanner.nextLine();
    }

    public static String inputPaymentMethod() {
        System.out.println("## 신용 카드는 1번, 현금은 2번");
        return scanner.nextLine();
    }
}
