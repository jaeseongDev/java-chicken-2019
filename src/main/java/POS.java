import domain.function.TerminateFunction;
import domain.menu.Menu;
import domain.function.Function;
import domain.table.Table;
import domain.function.OrderFunction;
import domain.function.PaymentFunction;
import java.util.ArrayList;
import java.util.List;

public class POS {
    private final List<Table> tables;
    private final List<Function> functions = new ArrayList<>();

    public POS(List<Table> tables, List<Menu> menus) {
        this.tables = tables;
        this.functions.add(new OrderFunction(tables, menus));
        this.functions.add(new PaymentFunction(tables));
        this.functions.add(new TerminateFunction(tables));
    }

    public Function selectFunction(int functionNumber) {
        int functionIndex = functionNumber - 1;
        return functions.get(functionIndex);
    }
}
