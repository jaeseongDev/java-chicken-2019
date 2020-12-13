package domain;

import java.util.Arrays;
import java.util.List;
import view.InputView;
import view.OutputView;

public enum MainFunction {
    ORDER("1") {
        @Override
        public void operate(List<Table> tables) {
            // TODO - 디버깅용
            System.out.println(TableRepository.tables());

            final List<Menu> menus = MenuRepository.menus();

            OutputView.printTables(tables);
            final int tableNumber = getInputTableNumber();
            Table table = TableRepository.findByNumber(tableNumber);

            OutputView.printMenus(menus);
            final int menuNumber = getInputMenuNumber();
            Menu menu = MenuRepository.findByNumber(menuNumber);
            final int menuCount = getInputMenuCount();
            table.orderMenu(new OrderedMenu(menu, menuCount));

            // TODO - 디버깅용
            System.out.println(TableRepository.tables());
        }
    },
    PAYMENT("2") {
        @Override
        public void operate(List<Table> tables) {
            // TODO - 디버깅용
            System.out.println("PAYMEMNT 함수 실행");

            OutputView.printTables(tables);
            final int tableNumber = getInputTableNumber();
            Table table = TableRepository.findByNumber(tableNumber);
            if (!table.isOrderedTable()) {
                throw new IllegalArgumentException("[ERROR] 주문하지 않은 테이블이어서 결제가 불가능합니다.");
            }

            OutputView.printOrderedMenus(table);

            String paymentMethodNumber = InputView.inputPaymentMethodNumber(table);
            PaymentMethod paymentMethod =
                PaymentMethod.getPaymentMethodByNumber(paymentMethodNumber);
            double finalAmountPrice = table.getFinalAmountPrice(paymentMethod);
            OutputView.printFinalAmountPrice(finalAmountPrice);
            TableRepository.resetTable(table);
        }
    },
    QUIT("3") {
        @Override
        public void operate(List<Table> tables) {
            // TODO - 디버깅용
            System.out.println("프로그램 종료");
        }
    };

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
            return menuCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하셔야 합니다.");
        }
    }

    public abstract void operate(List<Table> tables);
}


