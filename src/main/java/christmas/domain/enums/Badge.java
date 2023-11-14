package christmas.domain.enums;

import java.util.Arrays;

public enum Badge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    START("별", 5000),
    NONE("없음", 0);

    private final String name;
    private final int minDiscountAmount;

    Badge(String name, int discountAmount) {
        this.name = name;
        this.minDiscountAmount = discountAmount;
    }

    public static Badge getBadge(final int allDiscountAmount) {
        return Arrays.stream(Badge.values())
                .filter(badge -> allDiscountAmount >= badge.minDiscountAmount)
                .findFirst()
                .orElse(NONE);
    }

    public String getName() {
        return name;
    }
}
