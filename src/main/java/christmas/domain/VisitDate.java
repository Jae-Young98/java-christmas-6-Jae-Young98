package christmas.domain;

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
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public String getDay() {
        LocalDate localDate = LocalDate.of(2023, 12, this.date);
        DayOfWeek day = localDate.getDayOfWeek();

        return day.toString();
    }

    public int getDate() {
        return date;
    }
}