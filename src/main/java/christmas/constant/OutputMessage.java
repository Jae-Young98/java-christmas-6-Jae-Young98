package christmas.constant;

public enum OutputMessage {
    NEW_LINE(System.lineSeparator()),
    INTRODUCE_MESSAGE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!" + NEW_LINE.getMessage()),
    ORDER_TITLE("<주문 메뉴>"),
    ORDER_DETAIL("%s %d개"),
    AMOUNT_BEFORE_DISCOUNT_TITLE("<할인 전 총주문 금액>"),
    AMOUNT("%,d원"),
    GIFT_TITLE("<증정 메뉴>"),
    BENEFITS_TITLE("<혜택 내역>"),
    BENEFIT_AMOUNT("<총혜택 금액>"),
    AMOUNT_AFTER_DISCOUNT_TITLE("<할인 후 예상 결제 금액>"),
    BADGE_TITLE("<12월 이벤트 배지>");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
