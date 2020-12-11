package domain.table;

import domain.menu.Menu;
import domain.menu.MenuQuantity;
import domain.payment.OrderAmount;
import domain.payment.PaymentMethod;
import java.util.HashMap;

public class Table {
    private static final int ZERO_ORDER_AMOUNT = 0;
    private final int number;
    private boolean paymentStatus;
    private HashMap<Menu, MenuQuantity> menuStatus = new HashMap<>();
    private OrderAmount orderAmount = OrderAmount.ZERO;

    public Table(final int number) {
        this.number = number;
        this.paymentStatus = true;
    }

    public HashMap<Menu, MenuQuantity> getMenuStatus() {
        return menuStatus;
    }

    public void addOrderMenu(Menu menu, int menuCount) {
        setPaymentStatus();
        if (menuStatus.containsKey(menu)) {
            menuStatus.put(menu, menuStatus.get(menu).addMenuQuantity(menuCount));
            orderAmount = addOrderedAmount(menu, menuCount);
            return;
        }
        menuStatus.put(menu, new MenuQuantity(menuCount));
        orderAmount = addOrderedAmount(menu, menuCount);
    }

    private void setPaymentStatus() {
        paymentStatus = false;
    }

    private OrderAmount addOrderedAmount(Menu menu, int menuCount) {
        return orderAmount.add(menuCount * menu.getPrice());
    }

    public boolean isSelectedTable(int tableNumber) {
        return this.number == tableNumber;
    }

    public boolean isPaymentCompleted() {
        return paymentStatus;
    }

    public double getOrderAmount(int chickenAmount, PaymentMethod paymentMethod) {
        return orderAmount.getOrderAmount(chickenAmount, paymentMethod);
    }

    public void resetTable() {
        orderAmount = OrderAmount.ZERO;
        paymentStatus = true;
        menuStatus = new HashMap<>();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
