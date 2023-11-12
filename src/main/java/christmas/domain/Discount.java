package christmas.domain;

import christmas.domain.enums.CategoryGroup;
import christmas.domain.enums.Month;

import java.util.List;

public class Discount {
    private final VisitDate visitDate;
    private final Order order;

    public Discount(final VisitDate visitDate, final Order order) {
        this.visitDate = visitDate;
        this.order = order;
    }

    private int calculateDay() {
        int date = getDate();
        if (date <= 25) {
            return 1000 + (date - 1) * 100;
        }
        return 0;
    }

    private int calculateWeek() {
        Month month = Month.getDayType(getDay());
        List<OrderMenu> orderMenus = order.getOrder();
        if (month == Month.WEEKDAY) {
            return 2023 * CategoryGroup.calculateTotalQuantity(orderMenus, CategoryGroup.DESSERT);
        }
        return 0;
    }

    private int calculateWeekend() {
        Month month = Month.getDayType(getDay());
        List<OrderMenu> orderMenus = order.getOrder();
        if (month == Month.WEEKEND) {
            return 2023 * CategoryGroup.calculateTotalQuantity(orderMenus, CategoryGroup.MAIN);
        }
        return 0;
    }

    private int getDate() {
        return visitDate.getDate();
    }

    private String getDay() {
        return visitDate.getDay();
    }
}
