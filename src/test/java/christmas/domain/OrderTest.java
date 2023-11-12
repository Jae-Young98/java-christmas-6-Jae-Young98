package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderTest {
    private Order order;

    @BeforeEach
    void init() {
        order = new Order();
    }

    @DisplayName("올바른 주문시 예외가 발생하지 않는다.")
    @Test
    void validate() {
        // given
        OrderMenu menu1 = new OrderMenu("해산물파스타", 2);
        OrderMenu menu2 = new OrderMenu("샴페인", 1);
        order.addMenu(menu1);
        order.addMenu(menu2);

        // when, then
        assertThatNoException().isThrownBy(() -> order.check());
    }

    @DisplayName("음료만 주문시 예외를 발생 시킨다.")
    @Test
    void checkOnlyDrink() {
        // given
        OrderMenu menu1 = new OrderMenu("제로콜라", 2);
        OrderMenu menu2 = new OrderMenu("샴페인", 1);
        order.addMenu(menu1);
        order.addMenu(menu2);

        // when, then
        assertThatThrownBy(() -> order.check())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음료만 주문");
    }

    @DisplayName("최대 주문 개수를 초과할 경우 예외를 발생 시킨다.")
    @Test
    void checkQuantities() {
        // given
        OrderMenu menu1 = new OrderMenu("티본스테이크", 15);
        OrderMenu menu2 = new OrderMenu("바비큐립", 6);
        order.addMenu(menu1);
        order.addMenu(menu2);

        // when, then
        assertThatThrownBy(() -> order.check())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 한 번에 최대 20개까지만 주문할 수 있습니다. 다시 입력해 주세요.");
    }

    @DisplayName("할인 전 총주문 금액 계산")
    @Test
    void getAmountBeforeDiscount() {
        // given
        OrderMenu menu1 = new OrderMenu("바비큐립", 3);
        OrderMenu menu2 = new OrderMenu("타파스", 2);
        order.addMenu(menu1);
        order.addMenu(menu2);

        // when
        int amount = order.getAmountBeforeDiscount();

        assertThat(amount).isEqualTo(173000);
    }

    @DisplayName("총 주문 금액이 10000원 미만이면 이벤트 참여가 불가능하다.")
    @Test
    void canJoinEvent() {
        // given
        OrderMenu menu1 = new OrderMenu("아이스크림", 1);
        OrderMenu menu2 = new OrderMenu("제로콜라", 1);
        order.addMenu(menu1);
        order.addMenu(menu2);

        // when
        boolean canEvent = order.canJoinEvent();

        // then
        assertThat(canEvent).isFalse();
    }
}
