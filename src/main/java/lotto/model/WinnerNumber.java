package lotto.model;

import lotto.exception.ErrorCode;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerNumber {
    private static final int WINNER_SIZE = 6;
    private final List<Integer> numbers;

    public WinnerNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != WINNER_SIZE) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_OUT_OF_SIZE.getMessage());
        }
        if (numbers.stream().distinct().count() != WINNER_SIZE) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NO_DUPLICATE.getMessage());
        }
        for (int number : numbers) {
            if (number < LottoNumber.getMin() || number > LottoNumber.getMax()) {
                throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
