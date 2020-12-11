package domain.function;

import domain.Menu;
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

        OutputView.printMenus(menus);
        final int menuNumber = Integer.parseInt(InputView.inputMenuNumber());
    }
}
