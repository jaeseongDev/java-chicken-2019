import view.InputView;
import view.OutputView;

public class Machine {
    public void start() {
        try {
            OutputView.printMainMenus();
            int functionNumber = getInputFunctionNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            start();
        }
    }

    private int getInputFunctionNumber() {
        try {
            String input = InputView.inputFunctionNumber();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 존재하는 기능의 값만 입력하셔야 합니다.");
        }
    }
}
