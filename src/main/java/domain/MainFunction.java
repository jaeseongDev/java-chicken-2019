package domain;

import java.util.Arrays;
import java.util.List;
import view.InputView;
import view.OutputView;

public enum MainFunction {
    ORDER("1") {
        @Override
        public void operate(List<Table> tables) {
            final List<Menu> menus = MenuRepository.menus();

            // TODO - 디버깅용
            System.out.println("ORDER 함수 실행");

            OutputView.printTables(tables);
            final int tableNumber = getInputTableNumber();

            OutputView.printMenus(menus);
            final int menuNumber = getInputMenuNumber();
            final int menuCount = getInputMenuCount();

        }
    },
    PAYMENT("2") {
        @Override
        public void operate(List<Table> tables) {
            // TODO - 디버깅용
            System.out.println("PAYMEMNT 함수 실행");

//            OutputView.printTables(tables);
//            final int tableNumber = InputView.inputTableNumber();
        }
    },
    QUIT("3") {
        @Override
        public void operate(List<Table> tables) {
            // TODO - 디버깅용
            System.out.println("프로그램 종료");
        }
    };

    private static final int MIN_MENU_COUNT = 1;
    private static final int MAX_MENU_COUNT = 99;
    private String number;

    MainFunction(String number) {
        this.number = number;
    }

    public static MainFunction getMainFunctionByNumber(String inputNumber) {
        return Arrays.stream(MainFunction.values())
            .filter(function -> function.number.equals(inputNumber))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
    }

    private static int getInputMenuNumber() {
        try {
            String input = InputView.inputMenuNumber();
            int menuNumber = Integer.parseInt(input);
            MenuRepository.findByNumber(menuNumber);
            return menuNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하셔야 합니다.");
        }
    }

    private static int getInputTableNumber() {
        try {
            String input = InputView.inputTableNumber();
            int tableNumber = Integer.parseInt(input);
            TableRepository.findByNumber(tableNumber);
            return tableNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하셔야 합니다.");
        }
    }

    private static int getInputMenuCount() {
        try {
            String input = InputView.inputMenuCount();
            int menuCount = Integer.parseInt(input);
            if (menuCount < MIN_MENU_COUNT || menuCount > MAX_MENU_COUNT) {
                throw new IllegalArgumentException("[ERROR] 주문의 수량은 1에서 99까지만 가능합니다.");
            }
            return menuCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하셔야 합니다.");
        }
    }

    public abstract void operate(List<Table> tables);
}


