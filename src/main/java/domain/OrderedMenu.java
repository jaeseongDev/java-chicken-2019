package domain;

import java.util.Objects;

public class OrderedMenu {
    private static final int MIN_MENU_COUNT = 1;
    private static final int MAX_MENU_COUNT = 99;
    private Menu menu;
    private int count;

    public OrderedMenu(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
        validateOrderedMenuCount();
    }

    public int getCount() {
        return this.count;
    }

    public void addCount(int count) {
        int sum = this.count + count;
        if (sum < MIN_MENU_COUNT || sum > MAX_MENU_COUNT) {
            throw new IllegalArgumentException("[ERROR] 주문의 수량은 1에서 99까지만 가능합니다.");
        }
        this.count = sum;
    }

    private void validateOrderedMenuCount() {
        if (this.count < MIN_MENU_COUNT || this.count > MAX_MENU_COUNT) {
            throw new IllegalArgumentException("[ERROR] 주문의 수량은 1에서 99까지만 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderedMenu that = (OrderedMenu) o;
        return Objects.equals(menu, that.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu);
    }

    @Override
    public String toString() {
        return "OrderedMenu{" +
            "menu=" + menu +
            ", count=" + count +
            '}';
    }
}
