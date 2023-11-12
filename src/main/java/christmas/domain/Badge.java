package christmas.domain;

public class Badge {
    public static String getBadge(final int discountAmount) {
        return makeBadge(discountAmount);
    }

    private static String makeBadge(final int discountAmount) {
        if (discountAmount >= 20000) {
            return "산타";
        }
        if (discountAmount >= 10000) {
            return "트리";
        }
        if (discountAmount >= 5000) {
            return "별";
        }
        return "없음";
    }
}
