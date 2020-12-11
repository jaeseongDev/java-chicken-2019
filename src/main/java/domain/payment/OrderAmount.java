package domain.payment;

public class OrderAmount {
    private static final int ZERO_ORDER_AMOUNT = 0;
    private static final int CHICKEN_DISCOUNT_UNIT = 10;

    public static OrderAmount ZERO = new OrderAmount(ZERO_ORDER_AMOUNT);

    private final double orderAmount;

    public OrderAmount(double orderAmount) {
        validateOrderAmount(orderAmount);

        this.orderAmount = ZERO_ORDER_AMOUNT;
    }

    private void validateOrderAmount(double orderAmount) {
        if (orderAmount < ZERO_ORDER_AMOUNT) {
            throw new IllegalArgumentException("주문 금액이 0원보다 작을 수 없습니다.");
        }
    }

    public OrderAmount add(double addOrderAmount) {
        return new OrderAmount(this.orderAmount + addOrderAmount);
    }

    public double getOrderAmount(int chickenAmount, PaymentMethod paymentMethod) {
        final int discountAmount = (chickenAmount / CHICKEN_DISCOUNT_UNIT) * 10000;
        if (paymentMethod.isCash()) {
            return ((this.orderAmount - discountAmount) * 0.95);
        }
        return this.orderAmount - discountAmount;
    }
}
