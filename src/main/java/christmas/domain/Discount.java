package christmas.domain;

import christmas.domain.enums.CategoryGroup;
import christmas.domain.enums.Month;

import java.util.ArrayList;
import java.util.List;

public class Discount {
    private final VisitDate visitDate;
    private final Order order;

    public Discount(final VisitDate visitDate, final Order order) {
        this.visitDate = visitDate;
        this.order = order;
    }

    public int getAmountAfterDiscount() {
        int beforeDiscount = getAmountBeforeDiscount();
        return beforeDiscount - calculateAllDiscount();
    }

    private int getAmountBeforeDiscount() {
        return order.getAmountBeforeDiscount();
    }

    public int getDiscountAmount() {
        return calculateAllDiscount() + calculateGift();
    }

    private int calculateAllDiscount() {
        return calculateDay() + calculateWeek() + calculateWeekend() + calculateSpecial() + calculateChristmas();
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

    private int calculateSpecial() {
        if (Month.isSpecial(visitDate.getDay())) {
            return 1000;
        }
        return 0;
    }

    private int calculateChristmas() {
        if (visitDate.isChristmas()) {
            return 1000;
        }
        return 0;
    }

    private int getDate() {
        return visitDate.getDate();
    }

    private String getDay() {
        return visitDate.getDay();
    }

    public int calculateGift() {
        if (order.canGift()) {
            return 25000;
        }
        return 0;
    }

    public List<Integer> getDiscountResult() {
        List<Integer> result = new ArrayList<>();
        result.add(calculateDay());
        result.add(calculateWeek());
        result.add(calculateWeekend());
        result.add(calculateSpecial());
        result.add(calculateChristmas());
        result.add(calculateGift());

        return result;
    }
}
