package christmas.domain;

import christmas.constant.ExceptionMessage;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class VisitDate {
    private final int date;

    public VisitDate(int date) {
        validateRange(date);
        this.date = date;
    }

    private void validateRange(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(ExceptionMessage.VISIT_DATE_EXCEPTION.getMessage());
        }
    }

    public String getDay() {
        LocalDate localDate = LocalDate.of(2023, 12, date);
        DayOfWeek day = localDate.getDayOfWeek();

        return day.toString();
    }

    public boolean isChristmas() {
        return date == 25;
    }

    public int getDate() {
        return date;
    }
}
