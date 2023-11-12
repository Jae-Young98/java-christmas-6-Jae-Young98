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
        int dayDiscount = calculateDay();
        int weekDiscount = calculateWeek();
        int weekendDiscount = calculateWeekend();
        int specialDiscount = calculateSpecial();
        int christmasDiscount = calculateChristmas();
        return beforeDiscount - dayDiscount - weekDiscount - weekendDiscount - specialDiscount - christmasDiscount;
    }

    private int getAmountBeforeDiscount() {
        return order.getAmountBeforeDiscount();
    }

    private int calculateAllDiscount() {
        return calculateDay() + calculateWeek() + calculateSpecial() + calculateChristmas();
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
}
