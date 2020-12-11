package domain.payment;

public class PaymentMethod {
    private static final int CREDIT_CARD = 1;
    private static final int CASH = 2;
    private final int paymentMethod;

    public PaymentMethod(int paymentMethod) {
        validatePaymentMethod(paymentMethod);
        this.paymentMethod = paymentMethod;
    }

    private void validatePaymentMethod(int paymentMethod) {
        if (paymentMethod != CREDIT_CARD && paymentMethod != CASH) {
            throw new IllegalArgumentException("올바른 결제 방법의 번호를 입력해주세요.");
        }
    }

    public boolean isCash() {
        return paymentMethod == CASH;
    }
}
