package lotto.exception;

public enum ErrorCode {
    LOTTO_NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호는 1~45 사이어야 합니다."),
    LOTTO_OUT_OF_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_NO_DUPLICATE("[ERROR] 로또 번호는 중복될 수 없습니다.");


    private final String message;

    ErrorCode(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
