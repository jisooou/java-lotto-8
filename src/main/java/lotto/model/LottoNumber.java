package lotto.model;

import lotto.exception.ErrorCode;

public class LottoNumber {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validate(int lottoNumber) {
        if (lottoNumber < MIN || lottoNumber > MAX) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    public static int getMin() {
        return MIN;
    }

    public static int getMax() {
        return MAX;
    }
}
