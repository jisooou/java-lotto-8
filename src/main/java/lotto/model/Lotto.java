package lotto.model;

import lotto.exception.ErrorCode;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_OUT_OF_SIZE.getMessage());
        }
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NO_DUPLICATE.getMessage());
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers.stream()
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return getLottoNumbers().toString();
    }
}