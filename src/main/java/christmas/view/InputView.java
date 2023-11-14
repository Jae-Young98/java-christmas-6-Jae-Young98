package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.Converter;
import christmas.utils.InputValidator;

import java.util.List;
import java.util.Map;

import static christmas.constant.InputMessage.GREETING_MESSAGE;
import static christmas.constant.InputMessage.INPUT_MENU_MESSAGE;
import static christmas.constant.InputMessage.INPUT_VISIT_DATE_MESSAGE;

public class InputView {
    public void showGreeting() {
        System.out.println(GREETING_MESSAGE.getMessage());
    }

    public int inputVisitDate() {
        System.out.println(INPUT_VISIT_DATE_MESSAGE.getMessage());

        String input = Console.readLine();
        InputValidator.validateVisitDate(input);

        return Integer.parseInt(input);
    }

    public Map<String, Integer> inputMenus() {
        System.out.println(INPUT_MENU_MESSAGE.getMessage());

        String input = Console.readLine();
        InputValidator.validateMenus(input);
        List<String> menus = Converter.convertList(input);

        return Converter.convertMap(menus);
    }
}
