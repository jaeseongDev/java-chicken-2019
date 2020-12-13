package view;

import domain.Menu;
import domain.OrderedMenu;
import domain.PaymentMethod;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_WHEN_ORDERED = "└ ₩ ┘";

    public static void printMainMenus() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
        printEmptyLine();
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
        printEmptyLine();
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printBottomLine(List<Table> tables) {
        for (Table table : tables) {
            if (table.isOrderedTable()) {
                System.out.print(BOTTOM_LINE_WHEN_ORDERED);
                continue;
            }
            System.out.print(BOTTOM_LINE);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
        printEmptyLine();
    }

    public static void printOrderedMenus(Table table) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        List<OrderedMenu> orderedMenus = table.getOrderedMenus();
        for (OrderedMenu orderedMenu : orderedMenus) {
            String menuName = orderedMenu.getMenu().getName();
            int menuCount = orderedMenu.getCount();
            int price = menuCount * orderedMenu.getMenu().getPrice();
            System.out.println(menuName + " " + menuCount + " " + price);
        }
        printEmptyLine();
    }

    public static void printFinalAmountPrice(double price) {
        System.out.println("## 최종 결제할 금액");
        System.out.println((int) price + "원");
        printEmptyLine();
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
