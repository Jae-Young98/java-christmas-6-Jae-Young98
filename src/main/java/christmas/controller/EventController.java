package christmas.controller;

import christmas.domain.Order;
import christmas.domain.OrderMenu;
import christmas.domain.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class EventController {
    private final InputView inputView;
    private final OutputView outputView;

    public EventController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        initialize();
    }

    private void initialize() {
        inputView.showGreeting();
        VisitDate visitDate = getVisitDate();
        Order order = getOrder();
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
}
