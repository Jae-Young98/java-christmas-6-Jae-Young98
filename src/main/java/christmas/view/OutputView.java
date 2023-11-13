package christmas.view;

import christmas.domain.OrderMenu;
import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private final DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public void showIntroduce(int date) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", date);
        System.out.println();
        System.out.println();
    }

    public void showOrderMenus(List<OrderMenu> orderMenus) {
        System.out.println("<주문 메뉴>");
        orderMenus.forEach(orderMenu -> System.out.println(orderMenu.getMenu() + " " + orderMenu.getQuantity() + "개"));
        System.out.println();
    }

    public void showAmountBeforeDiscount(int amount) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(String.format("%,d원", amount));
        System.out.println();
    }

    public void showGiftStatus(String gift) {
        System.out.println("<증정 메뉴>");
        System.out.println(gift);
        System.out.println();
    }

    public void printBenefits(List<String> result) {
        System.out.println("<혜택 내역>");
        for (String resultMessage : result) {
            System.out.println(resultMessage);
        }
        System.out.println();
    }

    public void printBenefitAmount(int amount) {
        System.out.println("<총혜택 금액>");
        System.out.println(String.format("%,d원", amount));
        System.out.println();
    }

    public void printAfterDiscountAmount(int amount) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(String.format("%,d원", amount));
        System.out.println();
    }
}
