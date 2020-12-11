package domain;

import java.util.HashMap;

public class Table {
    private final int number;
    private HashMap<Menu, Integer> menuStatus = new HashMap<>();

    public Table(final int number) {
        this.number = number;
    }

    public void addOrderMenu(Menu menu, int menuCount) {
        if (menuStatus.containsKey(menu)) {
            menuStatus.put(menu, menuStatus.get(menu) + menuCount);
            return;
        }
        menuStatus.put(menu, menuCount);
    }

    public boolean isSelectedTable(int tableNumber) {
        return this.number == tableNumber;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
