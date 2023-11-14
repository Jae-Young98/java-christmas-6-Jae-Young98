package christmas.utils;

import christmas.constant.ExceptionMessage;

public class InputValidator {
    private static final String DELIMITER_COMMA = ",";
    private static final String DIGIT_REGEX = "^[0-9]+$";

    public static void validateVisitDate(String number) {
        if (isNotDigit(number)) {
            throw new IllegalArgumentException(ExceptionMessage.VISIT_DATE_EXCEPTION.getMessage());
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
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_INPUT_EXCEPTION.getMessage());
        }
    }

    public static void isEndWithDelimiter(String menus) {
        if (menus.endsWith(DELIMITER_COMMA)) {
            throw new IllegalArgumentException(ExceptionMessage.END_WITH_DELIMITER_EXCEPTION.getMessage());
        }
    }
}