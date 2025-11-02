package lotto.model;

import lotto.exception.ErrorCode;

public class PurchasePrice {
    private static final int UNIT = 1000;
    private final int amount;

    public PurchasePrice(String amount) {
        int money = convertToNum(amount);
        validate(money);
        this.amount = money;
    }

    private int convertToNum(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.PURCHASE_PRICE_NOT_NUMBER.getMessage());
        }
    }

    private void validate(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ErrorCode.PURCHASE_PRICE_OUT_OF_RANGE.getMessage());
        }
        if (money % UNIT != 0) {
            throw new IllegalArgumentException(ErrorCode.PURCHASE_PRICE_OUT_OF_UNIT.getMessage());
        }
    }

    public int getAmount() {
        return amount;
    }

    public int getCount() {
        return amount / UNIT;
    }
}
