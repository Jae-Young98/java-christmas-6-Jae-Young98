package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderMenuTest {
    @DisplayName("올바르지 않은 메뉴이름이면 예외를 발생 시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"양송이스프", "바베큐립", "해산물피스타"})
    void checkMenuName(String name) {
        assertThatThrownBy(() -> new OrderMenu(name, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("한 개 이상 주문하지 않으면 예외를 발생 시킨다.")
    @Test
    void checkQuantity() {
        assertThatThrownBy(() -> new OrderMenu("타파스", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
