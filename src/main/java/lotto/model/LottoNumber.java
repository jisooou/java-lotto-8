package lotto.model;

import lotto.exception.ErrorCode;

public class LottoNumber {
    public final static int MIN = 1;
    public final static int MAX = 45;
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
}
