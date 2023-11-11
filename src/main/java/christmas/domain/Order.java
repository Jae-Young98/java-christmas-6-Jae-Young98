package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<OrderMenu> order = new ArrayList<>();

    public void addMenu(OrderMenu orderMenu) {
        order.add(orderMenu);
    }
}
