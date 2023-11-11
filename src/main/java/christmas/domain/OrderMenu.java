package christmas.domain;

import christmas.domain.enums.Menu;

public class OrderMenu {
    private final String menu;
    private final int quantity;

    public OrderMenu(String menu, int quantity) {
        validate(menu, quantity);
        this.menu = menu;
        this.quantity = quantity;
    }

    private void validate(String menu, int quantity) {
        checkMenuName(menu);
        checkQuantity(quantity);
    }

    private void checkMenuName(String menu) {
        if (!Menu.isContainMenu(menu)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void checkQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public String getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }
}
