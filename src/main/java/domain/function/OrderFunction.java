package domain.function;

import domain.menu.Menu;
import domain.Table;
import java.util.List;
import view.InputView;
import view.OutputView;

public class OrderFunction extends Function {
    private final List<Menu> menus;
    public OrderFunction(List<Table> tables, List<Menu> menus) {
        super(tables);
        this.menus = menus;
    }

    @Override
    public void operateFunction() {
        OutputView.printTables(tables);
        final int tableNumber = Integer.parseInt(InputView.inputTableNumber());
        final Table selectedTable = tables.stream()
            .filter(table -> table.isSelectedTable(tableNumber))
            .findFirst()
            .get();

        OutputView.printMenus(menus);
        final int menuNumber = Integer.parseInt(InputView.inputMenuNumber());
        final Menu selectedMenu = menus.stream()
            .filter(menu -> menu.isSeletedMenu(menuNumber))
            .findFirst()
            .get();
        addSelectedOrderMenu(selectedTable, selectedMenu);
    }

    private void addSelectedOrderMenu(Table selectedTable, Menu selectedMenu) {
        try {
            final int menuQuantity = Integer.parseInt(InputView.inputMenuQuantity());
            selectedTable.addOrderMenu(selectedMenu, menuQuantity);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            addSelectedOrderMenu(selectedTable, selectedMenu);
        }
    }
}
