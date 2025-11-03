package lotto.exception;

public enum ErrorCode {
    LOTTO_NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_OUT_OF_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_NO_DUPLICATE("[ERROR] 로또 번호는 중복될 수 없습니다."),
    PURCHASE_PRICE_NOT_NUMBER("[ERROR] 구매 금액에는 문자열이 들어갈 수 없습니다."),
    PURCHASE_PRICE_OUT_OF_RANGE("[ERROR] 구매 금액은 0 이하일 수 없습니다."),
    PURCHASE_PRICE_OUT_OF_UNIT("[ERROR] 구매 금액은 1,000원 단위여야 합니다."),
    BONUS_NUMBER_NO_DUPLICATE("[ERROR] 보너스 번호와 로또 번호는 중복될 수 없습니다."),
    BONUS_NUMBER_OUT_OF_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
