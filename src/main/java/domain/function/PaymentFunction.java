package domain.function;

import domain.table.Table;
import domain.menu.Menu;
import domain.menu.MenuQuantity;
import java.util.HashMap;
import java.util.List;
import view.InputView;
import view.OutputView;

public class PaymentFunction extends Function {
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

        final int paymentMethod = getInputPaymentMethod();
    }

    private int getInputPaymentMethod() {
        try {
            return Integer.parseInt(InputView.inputPaymentMethod());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputPaymentMethod();
        }
    }
}
