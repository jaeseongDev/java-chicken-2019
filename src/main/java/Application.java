import domain.function.Function;
import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        OutputView.printFunctions();

        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();
        POS pos = new POS(tables, menus);
        final int functionNumber = getInputFunctionNumber();
        final Function selectedFunction = pos.selectFunction(functionNumber);

        OutputView.printTables(tables);

        final int tableNumber = Integer.parseInt(InputView.inputTableNumber());

        OutputView.printMenus(menus);
    }

    private static int getInputFunctionNumber() {
        try {
            final int functionNumber = Integer.parseInt(InputView.inputFunctionNumber());
            validateFunctionNumber(functionNumber);
            return functionNumber;
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력하셔야 합니다.");
            return getInputFunctionNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputFunctionNumber();
        }
    }

    private static void validateFunctionNumber(int functionNumber) {
        if (functionNumber > 3 || functionNumber < 1) {
            throw new IllegalArgumentException("입력한 기능 목록이 존재하지 않습니다. 1부터 3까지의 숫자만 입력 가능합니다.");
        }
    }
}
