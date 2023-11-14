package christmas.domain;

import christmas.constant.ExceptionMessage;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class VisitDate {
    private static final int YEAR = 2023;
    private static final int DECEMBER = 12;
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;
    private static final int CHRISTMAS = 25;

    private final int date;

    public VisitDate(int date) {
        validateRange(date);
        this.date = date;
    }

    private void validateRange(int date) {
        if (date < MIN_DATE || date > MAX_DATE) {
            throw new IllegalArgumentException(ExceptionMessage.VISIT_DATE_EXCEPTION.getMessage());
        }
    }

    public String getDay() {
        LocalDate localDate = LocalDate.of(YEAR, DECEMBER, date);
        DayOfWeek day = localDate.getDayOfWeek();

        return day.toString();
    }

    public boolean isChristmas() {
        return date == CHRISTMAS;
    }

    public int getDate() {
        return date;
    }
}
