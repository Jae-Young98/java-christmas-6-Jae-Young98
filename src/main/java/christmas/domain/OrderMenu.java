package christmas.domain;

import christmas.constant.ExceptionMessage;
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
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_EXCEPTION.getMessage());
        }
    }

    private void checkQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_EXCEPTION.getMessage());
        }
    }

    public int calculatePrice(int price) {
        return price * quantity;
    }

    public String getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }
}
