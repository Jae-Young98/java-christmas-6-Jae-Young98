package christmas.controller;

import christmas.domain.Badge;
import christmas.domain.Discount;
import christmas.domain.Order;
import christmas.domain.OrderMenu;
import christmas.domain.VisitDate;
import christmas.domain.enums.DiscountMessage;
import christmas.domain.enums.Menu;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;
import java.util.Map;

public class EventController {
    private final InputView inputView;
    private final OutputView outputView;
    private VisitDate visitDate;
    private Order order;

    public EventController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        initialize();
        makeResult();
    }

    private void initialize() {
        inputView.showGreeting();
        visitDate = getVisitDate();
        order = getOrder();
        showOrderStatus();
    }

    private void makeResult() {
        Discount discount = new Discount(visitDate, order);
        showBenefitResult(discount);
        showBenefitAmount(discount);
        showAfterDiscountAmount(discount);
    }

    private VisitDate getVisitDate() {
        try {
            int date = inputVisitDate();
            return new VisitDate(date);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getVisitDate();
        }
    }

    private int inputVisitDate() {
        try {
            return inputView.inputVisitDate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputVisitDate();
        }
    }

    private Order getOrder() {
        try {
            Order order = new Order();

            Map<String, Integer> inputMenus = getMenus();
            inputMenus.forEach((name, count) -> {
                order.addMenu(new OrderMenu(name, count));
            });

            order.check();
            return order;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getOrder();
        }
    }

    private Map<String, Integer> getMenus() {
        try {
            return inputView.inputMenus();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMenus();
        }
    }

    private void showOrderStatus() {
        outputView.showIntroduce(visitDate.getDate());
        outputView.showOrderMenus(order.getOrder());
        outputView.showAmountBeforeDiscount(order.getAmountBeforeDiscount());
        showGift();
    }

    private void showGift() {
        String gift = Menu.NONE.getName();
        if (order.canGift()) {
            gift = Menu.CHAMPAGNE.getName() + " 1개";
        }
        outputView.showGiftStatus(gift);
    }

    private void showBenefitResult(Discount discount) {
        List<String> result = DiscountMessage.getDiscountResult(discount);
        outputView.printBenefits(result);
    }

    private void showBenefitAmount(Discount discount) {
        outputView.printBenefitAmount(discount.getDiscountAmount());
    }

    private void showAfterDiscountAmount(Discount discount) {
        outputView.printAfterDiscountAmount(discount.getAmountAfterDiscount());
    }
}
