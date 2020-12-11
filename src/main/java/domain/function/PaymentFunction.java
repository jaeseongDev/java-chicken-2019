package domain.function;

import domain.payment.PaymentMethod;
import domain.table.Table;
import domain.menu.Menu;
import domain.menu.MenuQuantity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class PaymentFunction extends Function {
    private static final int ZERO_CHICKEN_AMOUNT = 0;
    public PaymentFunction(List<Table> tables) {
        super(tables);
    }

    @Override
    public void operateFunction() {
        OutputView.printTables(tables);
        final int tableNumber = Integer.parseInt(InputView.inputTableNumber());
        final Table selectedTable = tables.stream()
            .filter(table -> table.isSelectedTable(tableNumber))
            .findFirst()
            .get();

        final HashMap<Menu, MenuQuantity> orderedMenuStatus = selectedTable.getMenuStatus();
        OutputView.printOrderedMenuStatus(orderedMenuStatus);

        final PaymentMethod paymentMethod = getInputPaymentMethod();
        final int chickenAmount = getChickenDiscountNumber(orderedMenuStatus);

        final double finalOrderAmount = selectedTable.getOrderAmount(chickenAmount, paymentMethod);
        OutputView.printFinalOrderAmount(finalOrderAmount);
        selectedTable.resetTable();
    }

    private PaymentMethod getInputPaymentMethod() {
        try {
            int paymentMethod = Integer.parseInt(InputView.inputPaymentMethod());
            return new PaymentMethod(paymentMethod);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputPaymentMethod();
        }
    }

    private int getChickenDiscountNumber(HashMap<Menu, MenuQuantity> orderedMenuStatus) {
        int chickenAmount = ZERO_CHICKEN_AMOUNT;
        for (Map.Entry<Menu, MenuQuantity> entry : orderedMenuStatus.entrySet()) {
            Menu menu = entry.getKey();
            MenuQuantity menuQuantity = entry.getValue();
            if (menu.isChicken()) {
                chickenAmount += menuQuantity.getMenuQuantity();
            }
        }
        return chickenAmount;
    }
}
