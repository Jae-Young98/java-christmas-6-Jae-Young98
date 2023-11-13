package christmas.utils;

public class InputValidator {
    private static final String DELIMITER_COMMA = ",";
    private static final String DIGIT_REGEX = "^[0-9]+$";

    public static void validateVisitDate(String number) {
        if (isNotDigit(number)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private static boolean isNotDigit(String number) {
        return !number.matches(DIGIT_REGEX);
    }

    public static void validateMenus(String menus) {
        isEmpty(menus);
        isEndWithDelimiter(menus);
    }

    public static void isEmpty(String menus) {
        if (menus.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력될 수 없습니다. 다시 입력해 주세요.");
        }
    }

    public static void isEndWithDelimiter(String menus) {
        if (menus.endsWith(DELIMITER_COMMA)) {
            throw new IllegalArgumentException("[ERROR] 입력은 구분자(,)로 끝날 수 없습니다. 다시 입력해 주세요.");
        }
    }
}