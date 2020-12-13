import domain.MainFunction;
import domain.Table;
import domain.TableRepository;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Machine {
    public void start() {
        try {
            final List<Table> tables = TableRepository.tables();
            OutputView.printMainMenus();
            String functionNumber = InputView.inputFunctionNumber();
            MainFunction.getMainFunctionByNumber(functionNumber).operate(tables);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            start();
        }
    }
}
