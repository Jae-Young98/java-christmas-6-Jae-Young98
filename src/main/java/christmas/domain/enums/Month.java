package christmas.domain.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Month {
    WEEKDAY(Arrays.asList("SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY")),
    WEEKEND(Arrays.asList("FRIDAY", "SATURDAY")),
    SPECIAL(Arrays.asList("SUNDAY", "CHRISTMAS")),
    NONE(Collections.EMPTY_LIST);

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

    private boolean containDay(String day) {
        return week.contains(day);
    }
}
