package christmas.view;

import christmas.constant.OutputMessage;
import christmas.domain.OrderMenu;

import java.util.List;

import static christmas.constant.OutputMessage.AMOUNT;
import static christmas.constant.OutputMessage.AMOUNT_AFTER_DISCOUNT_TITLE;
import static christmas.constant.OutputMessage.AMOUNT_BEFORE_DISCOUNT_TITLE;
import static christmas.constant.OutputMessage.BADGE_TITLE;
import static christmas.constant.OutputMessage.BENEFITS_TITLE;
import static christmas.constant.OutputMessage.BENEFIT_AMOUNT;
import static christmas.constant.OutputMessage.GIFT_TITLE;
import static christmas.constant.OutputMessage.NEW_LINE;
import static christmas.constant.OutputMessage.ORDER_DETAIL;

public class OutputView {
    public void showIntroduce(int date) {
        System.out.printf(OutputMessage.INTRODUCE_MESSAGE.getMessage(), date);
        System.out.println();
    }

    public void showOrderMenus(List<OrderMenu> orderMenus) {
        StringBuilder orderDetails = new StringBuilder();
        System.out.println(OutputMessage.ORDER_TITLE.getMessage());

        for (OrderMenu orderMenu : orderMenus) {
            orderDetails.append(String.format(ORDER_DETAIL.getMessage(), orderMenu.getMenu(), orderMenu.getQuantity()))
                    .append(NEW_LINE.getMessage());
        }

        System.out.print(orderDetails);
        System.out.println();
    }

    public void showAmountBeforeDiscount(int amount) {
        System.out.println(AMOUNT_BEFORE_DISCOUNT_TITLE.getMessage());
        System.out.printf(String.format(AMOUNT.getMessage(), amount));
        System.out.println();
        System.out.println();
    }

    public void showGiftStatus(String gift) {
        System.out.println(GIFT_TITLE.getMessage());
        System.out.println(gift);
        System.out.println();
    }

    public void printBenefits(List<String> result) {
        System.out.println(BENEFITS_TITLE.getMessage());
        for (String resultMessage : result) {
            System.out.println(resultMessage);
        }
        System.out.println();
    }

    public void printBenefitAmount(int amount) {
        System.out.println(BENEFIT_AMOUNT.getMessage());
        System.out.printf(String.format(AMOUNT.getMessage(), amount));
        System.out.println();
        System.out.println();
    }

    public void printAmountAfterDiscount(int amount) {
        System.out.println(AMOUNT_AFTER_DISCOUNT_TITLE.getMessage());
        System.out.printf(String.format(AMOUNT.getMessage(), amount));
        System.out.println();
        System.out.println();
    }

    public void printBadge(String badge) {
        System.out.println(BADGE_TITLE.getMessage());
        System.out.println(badge);
    }
}