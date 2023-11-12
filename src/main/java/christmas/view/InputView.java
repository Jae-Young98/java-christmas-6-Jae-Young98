package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.InputValidator;

public class InputView {
    public void showGreeting() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public int inputVisitDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        InputValidator.validateNumber(input);

        return Integer.parseInt(input);
    }
}
