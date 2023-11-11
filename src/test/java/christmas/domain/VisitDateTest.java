package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class VisitDateTest {
    @DisplayName("날짜 입력이 범위 내이면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 23, 31, 11})
    void ableDate(int date) {
        assertThatNoException().isThrownBy(() -> new VisitDate(date));
    }

    @DisplayName("날짜 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 32, 33})
    void disableDate(int date) {
        assertThatThrownBy(() -> new VisitDate(date))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @DisplayName("입력받은 날짜를 요일로 바꾼다.")
    @Test
    void dateToDay() {
        // given
        VisitDate visitDate = new VisitDate(25);
        String expectedDay = "MONDAY";

        // when, then
        assertThat(visitDate.getDay()).isEqualTo(expectedDay);
    }
}
