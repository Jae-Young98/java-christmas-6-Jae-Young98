package christmas.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Converter {
    private static final String STRING_REGEX = "^[ㄱ-ㅎ가-힣]*$";
    private static final String DIGIT_REGEX = "^[0-9]+$";
    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_DASH = "-";

    public static List<String> convertList(String menus) {
        return Arrays.asList(menus.split(DELIMITER_COMMA));
    }

    public static Map<String, Integer> convertMap(List<String> menus) {
        return makeMap(menus);
    }

    private static Map<String, Integer> makeMap(List<String> menus) {
        Map<String, Integer> map = new HashMap<>();

        for (String str : menus) {
            String[] splitMenu = str.split(DELIMITER_DASH);
            validateSplitMenu(splitMenu);
            String menu = splitMenu[0].trim();
            int count = Integer.parseInt(splitMenu[1].trim());
            validateDuplicate(map, menu);
            map.put(menu, count);
        }

        return map;
    }

    private static void validateSplitMenu(String[] splitMenu) {
        validateLength(splitMenu);
        validateMenu(splitMenu);
        validateCount(splitMenu);
    }

    private static void validateLength(String[] splitMenu) {
        if (wrongLength(splitMenu)) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 입력입니다. 다시 입력해 주세요.");
        }
    }

    private static boolean wrongLength(String[] splitMenu) {
        return splitMenu.length != 2;
    }

    private static void validateMenu(String[] splitMenu) {
        String menu = splitMenu[0].trim();
        if (isNotString(menu)) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 메뉴 입력입니다. 한글로 다시 입력해 주세요.");
        }
    }

    private static void validateCount(String[] splitMenu) {
        String count = splitMenu[1].trim();
        if (isNotDigit(count)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static boolean isNotString(String menu) {
        return !menu.matches(STRING_REGEX);
    }

    private static boolean isNotDigit(String number) {
        return !number.matches(DIGIT_REGEX);
    }

    private static void validateDuplicate(Map<String, Integer> map, String name) {
        if (hasDuplicate(map, name)) {
            throw new IllegalArgumentException("[ERROR] 메뉴 이름은 중복 될 수 없습니다. 다시 입력해 주세요.");
        }
    }

    private static boolean hasDuplicate(Map<String, Integer> map, String name) {
        return map.containsKey(name);
    }
}
