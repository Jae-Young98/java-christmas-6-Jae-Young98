package christmas.domain.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MonthTest {
    @DisplayName("입력받은 요일이 평일이면 WEEKDAY 를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY"})
    void isWeekDay(String day) {
        assertThat(Month.getDayType(day)).isEqualTo(Month.WEEKDAY);
    }

    @DisplayName("입력받은 요일이 주말이면 WEEKEND 를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"FRIDAY", "SATURDAY"})
    void isWeekend(String day) {
        assertThat(Month.getDayType(day)).isEqualTo(Month.WEEKEND);
    }

    @DisplayName("입력받은 요일이 특별할인 날이면 true 를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"SUNDAY", "CHRISTMAS"})
    void isSpecial(String day) {
        assertThat(Month.isSpecial(day)).isTrue();
    }
}
