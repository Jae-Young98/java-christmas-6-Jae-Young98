package christmas.domain;

import christmas.constant.ExceptionMessage;
import christmas.domain.enums.CategoryGroup;
import christmas.domain.enums.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private static final int MAX_ORDER_QUANTITY = 20;
    private static final int MIN_JOIN_EVENT_AMOUNT = 10000;
    private static final int CAN_RECEIVE_GIFT_AMOUNT = 120000;

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
        if (calculateAllQuantity() > MAX_ORDER_QUANTITY) {
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
        return getAmountBeforeDiscount() >= MIN_JOIN_EVENT_AMOUNT;
    }

    public boolean canGift() {
        return getAmountBeforeDiscount() >= CAN_RECEIVE_GIFT_AMOUNT;
    }

    public List<OrderMenu> getOrder() {
        return Collections.unmodifiableList(order);
    }
}
