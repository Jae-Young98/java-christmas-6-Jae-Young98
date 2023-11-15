package christmas.domain.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BadgeTest {
    @DisplayName("총혜택 금액이 5천 원 미만이면 배지를 받지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1300, -2500, -4999})
    void noneBadge(int amount) {
        assertThat(Badge.getBadge(amount).getName()).isEqualTo("없음");
    }

    @DisplayName("총혜택 금액이 5천 원 이상이면 '별' 배지를 받는다.")
    @ParameterizedTest
    @ValueSource(ints = {-5000, -5432, -9999})
    void starBadge(int amount) {
        assertThat(Badge.getBadge(amount).getName()).isEqualTo("별");
    }

    @DisplayName("총혜택 금액이 1만 원 이상이면 '트리' 배지를 받는다.")
    @ParameterizedTest
    @ValueSource(ints = {-10000, -10001, -19999, -18352})
    void treeBadge(int amount) {
        assertThat(Badge.getBadge(amount).getName()).isEqualTo("트리");
    }

    @DisplayName("총혜택 금액이 2만 원 이상이면 '산타' 배지를 받는다.")
    @ParameterizedTest
    @ValueSource(ints = {-20000, -20001, -99999})
    void santaBadge(int amount) {
        assertThat(Badge.getBadge(amount).getName()).isEqualTo("산타");
    }
}
