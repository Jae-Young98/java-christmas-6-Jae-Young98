package christmas.domain.enums;

import christmas.domain.Discount;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public enum DiscountMessage {
    CHRISTMAS(0, "크리스마스 디데이 할인: "),
    WEEK(1, "평일 할인: "),
    WEEKEND(2, "주말 할인: "),
    SPECIAL(3, "특별 할인: "),
    GIFT(4, "증정 이벤트: "),
    NONE(5, "없음");

    private final int index;
    private final String message;

    DiscountMessage(int index, String message) {
        this.index = index;
        this.message = message;
    }

    public int getIndex() {
        return index;
    }

    public String getMessage() {
        return message;
    }
}
