package lotto.model;

import lotto.exception.ErrorCode;

public class BonusNumber {
    private final static int MIN = 1;
    private final static int MAX = 45;
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, WinnerNumber winnerNumber) {
        validate(bonusNumber, winnerNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber, WinnerNumber winnerNumber) {
        if (bonusNumber < MIN || bonusNumber > MAX) {
            throw new IllegalArgumentException(ErrorCode.BONUS_NUMBER_OUT_OF_RANGE.getMessage());
        }
        if (winnerNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.BONUS_NUMBER_NO_DUPLICATE.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
