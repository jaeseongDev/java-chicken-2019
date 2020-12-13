package view;

import domain.Table;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputTableNumber() {
        System.out.println("## 테이블을 선택하세요.");
        String input = scanner.nextLine();
        printEmptyLine();
        return input;
    }

    public static String inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        String input = scanner.nextLine();
        printEmptyLine();
        return input;
    }

    public static String inputMenuCount() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        String input = scanner.nextLine();
        printEmptyLine();
        return input;
    }

    public static String inputFunctionNumber() {
        System.out.println("## 원하는 기능을 선택하세요.");
        String input = scanner.nextLine();
        printEmptyLine();
        return input;
    }

    public static String inputPaymentMethodNumber(Table table) {
        System.out.println("## " + table.getNumber() + "번 테이블의 결제를 진행하빈다.");
        System.out.println("## 신용 카드는 1번, 현금은 2번");
        String input = scanner.nextLine();
        printEmptyLine();
        return input;
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
