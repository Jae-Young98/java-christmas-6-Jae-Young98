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


    public static List<String> getDiscountResult(Discount discount) {
        List<String> resultMessage = new ArrayList<>();
        List<Integer> result = discount.getDiscountResult();
        if (isNoneDiscount(result)) {
            resultMessage.add(NONE.getMessage());
            return resultMessage;
        }

        return IntStream.range(0, result.size())
                .filter(index -> result.get(index) != 0)
                .mapToObj(index -> DiscountMessage.values()[index].getMessage() + result.get(index) + "원")
                .toList();
    }

    private static boolean isNoneDiscount(List<Integer> result) {
        return result.size() == 0;
    }

    public int getIndex() {
        return index;
    }

    public String getMessage() {
        return message;
    }
}
