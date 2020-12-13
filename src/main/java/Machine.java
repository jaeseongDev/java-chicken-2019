import domain.MainFunction;
import view.InputView;
import view.OutputView;

public class Machine {
    public void start() {
        try {
            OutputView.printMainMenus();
            String functionNumber = InputView.inputFunctionNumber();
            MainFunction.getMainFunctionByNumber(functionNumber).operate();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            start();
        }
    }
}
