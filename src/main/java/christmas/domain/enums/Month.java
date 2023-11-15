package christmas.domain.enums;

import java.util.Arrays;
import java.util.List;

public enum Month {
    WEEKDAY(Arrays.asList("SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY")),
    WEEKEND(Arrays.asList("FRIDAY", "SATURDAY")),
    SPECIAL(Arrays.asList("SUNDAY", "CHRISTMAS")),
    NONE(List.of());

    private final List<String> week;

    Month(List<String> week) {
        this.week = week;
    }

    public static Month getDayType(String day) {
        return Arrays.stream(values())
                .filter(month -> month.containDay(day))
                .findFirst()
                .orElse(NONE);
    }

    public static boolean isSpecial(String day) {
        return SPECIAL.week.contains(day);
    }

    private boolean containDay(String day) {
        return week.contains(day);
    }
}
