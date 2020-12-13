package domain;

import java.util.Arrays;

public enum MainFunction {
    ORDER("1") {
        @Override
        public void operate() {
            try {
                // TODO - 디버깅용
                System.out.println("ORDER 함수 실행");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                operate();
            }
        }
    },
    PAYMENT("2") {
        @Override
        public void operate() {
            try {
                // TODO - 디버깅용
                System.out.println("PAYMEMNT 함수 실행");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                operate();
            }
        }
    },
    QUIT("3") {
        @Override
        public void operate() {
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

    public abstract void operate();
}


