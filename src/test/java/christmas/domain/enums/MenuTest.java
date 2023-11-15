package christmas.domain.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest {
    @DisplayName("메뉴 이름에 따라 가격을 반환한다.")
    @Test
    void getMenuPrice() {
        // given
        String menuName = "티본스테이크";

        // when
        int expectedPrice = 55000;
        int resultPrice = Menu.getMenuPrice(menuName);

        // then
        assertThat(resultPrice).isEqualTo(expectedPrice);
    }

    @DisplayName("입력받은 메뉴명이 실제 메뉴와 일치하지 않으면 false 를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"티븐스테이크", "해신물파스타", "레드외인"})
    void isContainMenuFalse(String menuName) {
        assertThat(Menu.isContainMenu(menuName)).isFalse();
    }

    @DisplayName("입력받은 메뉴명이 실제 메뉴와 일치하면 true 를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크", "초코케이크", "타파스"})
    void isContainMenuTrue(String menuName) {
        assertThat(Menu.isContainMenu(menuName)).isTrue();
    }
}