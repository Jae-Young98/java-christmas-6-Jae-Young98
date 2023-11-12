package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscountTest {

    private final Order order = new Order();
    private final Order onlyAppetizerOrder = new Order();

    @BeforeEach
    void setOrder() {
        order.addMenu(new OrderMenu("티본스테이크", 3));
        order.addMenu(new OrderMenu("아이스크림", 1));
        onlyAppetizerOrder.addMenu(new OrderMenu("양송이수프", 5));
    }

    @DisplayName("평일이면 디저트 메뉴를 1개당 2023원 할인한다.")
    @ParameterizedTest
    @ValueSource(ints = {26, 27, 28})
    void discountDessert(int date) {
        // given
        VisitDate visitDate = new VisitDate(date);
        Discount discount = new Discount(visitDate, order);

        // when
        int expectedAmount = 167977;
        int resultAmount = discount.getAmountAfterDiscount();

        // then
        assertThat(resultAmount).isEqualTo(expectedAmount);
    }

    @DisplayName("주말이면 메인 메뉴를 1개당 2023원 할인한다.")
    @ParameterizedTest
    @ValueSource(ints = {29, 30})
    void discountMain(int date) {
        // given
        VisitDate visitDate = new VisitDate(date);
        Discount discount = new Discount(visitDate, order);

        // when
        int expectedAmount = 163931;
        int resultAmount = discount.getAmountAfterDiscount();

        // then
        assertThat(resultAmount).isEqualTo(expectedAmount);
    }

    @DisplayName("특별 할인날에는 총 주문 금액에서 1000원 할인한다.")
    @Test
    void discountSpecial() {
        // given
        VisitDate visitDate = new VisitDate(31);
        Discount discount = new Discount(visitDate, onlyAppetizerOrder);

        // when
        int expectedAmount = 29000;
        int resultAmount = discount.getAmountAfterDiscount();

        // then
        assertThat(resultAmount).isEqualTo(expectedAmount);
    }

    @DisplayName("크리스마스에는 디데이 할인과 특별할인이 적용된다.")
    @Test
    void discountChristmas() {
        // given
        VisitDate visitDate = new VisitDate(25);
        Discount discount = new Discount(visitDate, onlyAppetizerOrder);

        // when
        int expectedAmount = 25600;
        int resultAmount = discount.getAmountAfterDiscount();

        // then
        assertThat(resultAmount).isEqualTo(expectedAmount);
    }

    @DisplayName("평일 디데이 이벤트 기간에는 디데이 할인과 평일 할인이 적용된다.")
    @Test
    void discountWeekAndDDay() {
        // given
        VisitDate visitDate = new VisitDate(20);
        Discount discount = new Discount(visitDate, order);

        // when
        int expectedAmount = 165077;
        int resultAmount = discount.getAmountAfterDiscount();

        // then
        assertThat(resultAmount).isEqualTo(expectedAmount);
    }

    @DisplayName("주말 디데이 이벤트 기간에는 디데이 할인과 주말 할인이 적용된다.")
    @Test
    void discountWeekendAndDDay() {
        // given
        VisitDate visitDate = new VisitDate(23);
        Discount discount = new Discount(visitDate, order);

        // when
        int expectedAmount = 160731;
        int resultAmount = discount.getAmountAfterDiscount();

        // then
        assertThat(resultAmount).isEqualTo(expectedAmount);
    }

    @DisplayName("크리스마스에는 디데이 할인과 특별 할인, 평일 할인이 적용된다.")
    @Test
    void discountAllAtChristmas() {
        // given
        VisitDate visitDate = new VisitDate(25);
        Discount discount = new Discount(visitDate, order);

        // when
        int expectedAmount = 163577;
        int resultAmount = discount.getAmountAfterDiscount();

        // then
        assertThat(resultAmount).isEqualTo(expectedAmount);
    }
}
