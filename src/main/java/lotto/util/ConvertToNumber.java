package lotto.util;

import lotto.exception.ErrorCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertToNumber {
    private static final String DELIMITER = ",";

    public ConvertToNumber() {
    }

    public static List<Integer> parse(String input) {
        try {
            return Arrays.stream(input.split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_NOT_NUMBER.getMessage());
        }
    }
}
