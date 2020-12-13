import domain.Menu;
import domain.MenuRepository;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        while (true) {
            Machine machine = new Machine();
            machine.start();

            final List<Menu> menus = MenuRepository.menus();
            OutputView.printMenus(menus);
        }
    }
}
