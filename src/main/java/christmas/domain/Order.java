package christmas.domain;

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
            throw new IllegalArgumentException("[ERROR] 음료만 주문 할 수 없습니다. 다시 입력해 주세요.");
        }
    }

    private void checkQuantities() {
        if (calculateAllQuantity() > 20) {
            throw new IllegalArgumentException("[ERROR] 한 번에 최대 20개까지만 주문할 수 있습니다. 다시 입력해 주세요.");
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

    public List<OrderMenu> getOrder() {
        return Collections.unmodifiableList(order);
    }
}
