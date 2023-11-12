package christmas.utils;

public class InputValidator {
    private static final String DIGIT_REGEX = "^[0-9]+$";

    public static void validateNumber(String number) {
        if (isNotDigit(number)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다. 다시 입력해 주세요.");
        }
    }

    private static boolean isNotDigit(String number) {
        return !number.matches(DIGIT_REGEX);
    }
}
