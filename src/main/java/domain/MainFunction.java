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
            System.out.println("ORDER 함수 실행");

            OutputView.printTables(tables);
            final int tableNumber = getInputTableNumber();
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

    public abstract void operate(List<Table> tables);
}


