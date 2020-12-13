package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Table {
    private static final int MENUS_SIZE_IN_NOT_ORDERED_TABLE = 0;
    private final int number;
    private List<OrderedMenu> orderedMenus = new ArrayList<>();

    public Table(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public List<OrderedMenu> getOrderedMenus() {
        return orderedMenus;
    }

    public void orderMenu(OrderedMenu menu) {
        for (OrderedMenu orderedMenu : orderedMenus) {
            if (orderedMenu.equals(menu)) {
                orderedMenu.addCount(menu.getCount());
                return;
            }
        }
        this.orderedMenus.add(menu);
    }

    public double getFinalAmountPrice(PaymentMethod method) {
        double finalAmountPrice = getAmountPrice();
        if (method.equals(PaymentMethod.CASH)) {
            finalAmountPrice *= 0.95;
        }
        int discountPrice = (orderedChickenCount() / 10) * 10000;
        finalAmountPrice -= discountPrice;
        return finalAmountPrice;
    }

    private int getAmountPrice() {
        int sum = 0;
        for (OrderedMenu orderedMenu : orderedMenus) {
            sum += orderedMenu.getCount() *  orderedMenu.getMenu().getPrice();
        }
        return sum;
    }

    public boolean isOrderedTable() {
        return orderedMenus.size() > MENUS_SIZE_IN_NOT_ORDERED_TABLE;
    }

    public int orderedChickenCount() {
        int sum = 0;
        for (OrderedMenu orderedMenu : orderedMenus) {
            if (orderedMenu.getMenu().isChicken()) {
                sum += orderedMenu.getCount();
            }
        }
        return sum;
    }

    public void resetTable() {
        orderedMenus = new ArrayList<>();
    }

    // TODO - 실제 완성 때에는 이 함수 사용하기
//    @Override
//    public String toString() {
//        return Integer.toString(number);
//    }

    // TODO - 디버깅용
    @Override
    public String toString() {
        return "Table{" +
            "number=" + number +
            ", orderedMenus=" + orderedMenus +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Table table = (Table) o;
        return number == table.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
