package domain;

import java.util.Arrays;

public enum PaymentMethod {
    CARD("1"),
    CASH("2");

    private String number;

    PaymentMethod(String number) {
        this.number = number;
    }

    public static PaymentMethod getPaymentMethodByNumber(String inputNumber) {
        return Arrays.stream(PaymentMethod.values())
            .filter(method -> method.number.equals(inputNumber))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
    }

    public String getNumber() {
        return number;
    }
}
