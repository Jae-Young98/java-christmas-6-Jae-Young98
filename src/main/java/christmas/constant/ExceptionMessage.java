package christmas.constant;

public enum ExceptionMessage {
    VISIT_DATE_EXCEPTION("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    EMPTY_INPUT_EXCEPTION("공백은 입력될 수 없습니다. 다시 입력해 주세요."),
    END_WITH_DELIMITER_EXCEPTION("입력은 구분자(,)로 끝날 수 없습니다. 다시 입력해 주세요."),
    INPUT_MENU_EXCEPTION("올바르지 않은 입력입니다. 다시 입력해 주세요."),
    INPUT_NOT_KOREAN_EXCEPTION("올바르지 않은 메뉴 입력입니다. 한글로 다시 입력해 주세요."),
    INVALID_ORDER_EXCEPTION("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    DUPLICATE_ORDER_EXCEPTION("메뉴 이름은 중복 될 수 없습니다. 다시 입력해 주세요."),
    ONLY_DRINK_ORDER_EXCEPTION("음료만 주문 할 수 없습니다. 다시 입력해 주세요."),
    MAX_QUANTITY_ORDER_EXCEPTION("한 번에 최대 20개까지만 주문할 수 있습니다. 다시 입력해 주세요.");

    private static final String HEADER = "[ERROR]";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format("%s %s", HEADER, message);
    }
}
