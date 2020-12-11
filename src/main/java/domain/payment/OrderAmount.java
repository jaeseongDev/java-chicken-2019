package domain.payment;

public class OrderAmount {
    private static final int ZERO_ORDER_AMOUNT = 0;

    public static OrderAmount ZERO = new OrderAmount(ZERO_ORDER_AMOUNT);

    private final int orderAmount;

    public OrderAmount(int orderAmount) {
        validateOrderAmount(orderAmount);

        this.orderAmount = ZERO_ORDER_AMOUNT;
    }

    private void validateOrderAmount(int orderAmount) {
        if (orderAmount < ZERO_ORDER_AMOUNT) {
            throw new IllegalArgumentException("주문 금액이 0원보다 작을 수 없습니다.");
        }
    }

    public OrderAmount add(int addOrderAmount) {
        return new OrderAmount(this.orderAmount + addOrderAmount);
    }

    public int getOrderAmount() {
        return orderAmount;
    }
}
