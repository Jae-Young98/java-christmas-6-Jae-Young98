package christmas.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConverterTest {
    @DisplayName("구분자(-)로 나눈 문자열 배열의 길이가 2가 아니면 예외를 발생시킨다.")
    @Test
    void validateLength() {
        // given
        List<String> input = Arrays.asList("양송이수프-2", "타파스-");

        // when, then
        assertThatThrownBy(() -> Converter.convertMap(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 올바르지 않은 입력입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴 이름이 한글이 아니면 예외를 발생시킨다.")
    @Test
    void validateMenu() {
        // given
        List<String> input = Arrays.asList("양송이soup-2", "타파스-5");

        // when, then
        assertThatThrownBy(() -> Converter.convertMap(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 올바르지 않은 메뉴 입력입니다. 한글로 다시 입력해 주세요.");
    }

    @DisplayName("개수가 숫자가 아니면 예외를 발생시킨다.")
    @Test
    void validateCount() {
        // given
        List<String> input = Arrays.asList("양송이수프-두개", "타파스-5");

        // when, then
        assertThatThrownBy(() -> Converter.convertMap(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("중복된 메뉴라면 예외를 발생시킨다.")
    @Test
    void validateDuplicate() {
        // given
        List<String> input = Arrays.asList("양송이수프-3", "타파스-5", "양송이수프-1");

        // when, then
        assertThatThrownBy(() -> Converter.convertMap(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 메뉴 이름은 중복 될 수 없습니다. 다시 입력해 주세요.");
    }
}
