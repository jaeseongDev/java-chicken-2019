import domain.MainFunction;
import domain.Table;
import domain.TableRepository;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Machine {
    public void start() {
        try {
            tryToStart();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            start();
        }
    }

    private void tryToStart() {
        while (true) {
            final List<Table> tables = TableRepository.tables();
            OutputView.printMainMenus();
            String functionNumber = InputView.inputFunctionNumber();
            if (functionNumber.equals(MainFunction.QUIT.getNumber())) {
                break;
            }
            MainFunction.getMainFunctionByNumber(functionNumber).operate(tables);
        }
    }
}
