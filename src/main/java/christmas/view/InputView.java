package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.Converter;
import christmas.utils.InputValidator;
import java.util.List;
import java.util.Map;

public class InputView {
    public void showGreeting() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public int inputVisitDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        InputValidator.validateVisitDate(input);

        return Integer.parseInt(input);
    }

    public Map<String, Integer> inputMenus() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine();
        InputValidator.validateMenus(input);
        List<String> menus = Converter.convertList(input);
        return Converter.convertMap(menus);
    }
}
