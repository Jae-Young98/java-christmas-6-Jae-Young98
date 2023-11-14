package christmas.domain;

import christmas.domain.enums.CategoryGroup;
import christmas.domain.enums.Month;

import java.util.List;
import java.util.stream.Stream;

public class Discount {
    private static final int NONE_PRICE = 0;
    private static final int CHRISTMAS = 25;
    private static final int START_CHRISTMAS_DISCOUNT_AMOUNT = -1000;
    private static final int DAY_DISCOUNT_AMOUNT = 100;
    private static final int UNIT_DISCOUNT_AMOUNT = -2023;
    private static final int SPECIAL_DISCOUNT_AMOUNT = -1000;
    private static final int GIFT_DISCOUNT_AMOUNT = -25000;

    private final VisitDate visitDate;
    private final Order order;

    public Discount(final VisitDate visitDate, final Order order) {
        this.visitDate = visitDate;
        this.order = order;
    }

    public int getAmountAfterDiscount() {
        int beforeDiscount = getAmountBeforeDiscount();
        if (order.canJoinEvent()) {
            return beforeDiscount + calculateAllDiscount();
        }
        return beforeDiscount;
    }

    public int getDiscountAmount() {
        if (!order.canJoinEvent()) {
            return NONE_PRICE;
        }

        return calculateAllDiscount() + calculateGift();
    }

    private int getAmountBeforeDiscount() {
        return order.getAmountBeforeDiscount();
    }

    private int calculateAllDiscount() {
        return calculateDay() + calculateWeek() + calculateWeekend() + calculateSpecial();
    }

    private int calculateDay() {
        int date = getDate();
        if (date <= CHRISTMAS) {
            return START_CHRISTMAS_DISCOUNT_AMOUNT - (date - 1) * DAY_DISCOUNT_AMOUNT;
        }
        return NONE_PRICE;
    }

    private int calculateWeek() {
        Month month = Month.getDayType(getDay());
        List<OrderMenu> orderMenus = order.getOrder();
        if (month == Month.WEEKDAY) {
            return UNIT_DISCOUNT_AMOUNT * CategoryGroup.calculateTotalQuantity(orderMenus, CategoryGroup.DESSERT);
        }
        return NONE_PRICE;
    }

    private int calculateWeekend() {
        Month month = Month.getDayType(getDay());
        List<OrderMenu> orderMenus = order.getOrder();
        if (month == Month.WEEKEND) {
            return UNIT_DISCOUNT_AMOUNT * CategoryGroup.calculateTotalQuantity(orderMenus, CategoryGroup.MAIN);
        }
        return NONE_PRICE;
    }

    private int calculateSpecial() {
        if (Month.isSpecial(visitDate.getDay()) || visitDate.isChristmas()) {
            return SPECIAL_DISCOUNT_AMOUNT;
        }
        return NONE_PRICE;
    }

    private int calculateGift() {
        if (order.canGift()) {
            return GIFT_DISCOUNT_AMOUNT;
        }
        return NONE_PRICE;
    }

    private int getDate() {
        return visitDate.getDate();
    }

    private String getDay() {
        return visitDate.getDay();
    }

    public List<Integer> getDiscountResult() {
        if (!order.canJoinEvent()) {
            return List.of();
        }

        return Stream.of(
                    calculateDay(),
                    calculateWeek(),
                    calculateWeekend(),
                    calculateSpecial(),
                    calculateGift())
                .toList();
    }
}
