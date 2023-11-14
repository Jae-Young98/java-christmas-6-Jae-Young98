package christmas.domain;

import christmas.constant.ExceptionMessage;
import christmas.domain.enums.CategoryGroup;
import christmas.domain.enums.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final List<OrderMenu> order = new ArrayList<>();

    public void addMenu(OrderMenu orderMenu) {
        order.add(orderMenu);
    }

    public void check() {
        validate();
    }

    private void validate() {
        checkOnlyDrink();
        checkQuantities();
    }

    private void checkOnlyDrink() {
        if (CategoryGroup.containOnlyDrink(order)) {
            throw new IllegalArgumentException(ExceptionMessage.ONLY_DRINK_ORDER_EXCEPTION.getMessage());
        }
    }

    private void checkQuantities() {
        if (calculateAllQuantity() > 20) {
            throw new IllegalArgumentException(ExceptionMessage.MAX_QUANTITY_ORDER_EXCEPTION.getMessage());
        }
    }

    private int calculateAllQuantity() {
        return order.stream()
                .mapToInt(OrderMenu::getQuantity)
                .sum();
    }

    public int getAmountBeforeDiscount() {
        return order.stream()
                .mapToInt(this::calculateOrderMenuAmount)
                .sum();
    }

    private int calculateOrderMenuAmount(OrderMenu orderMenu) {
        return orderMenu.calculatePrice(Menu.getMenuPrice(orderMenu.getMenu()));
    }

    public boolean canJoinEvent() {
        return getAmountBeforeDiscount() >= 10000;
    }

    public boolean canGift() {
        return getAmountBeforeDiscount() >= 120000;
    }

    public List<OrderMenu> getOrder() {
        return Collections.unmodifiableList(order);
    }
}
