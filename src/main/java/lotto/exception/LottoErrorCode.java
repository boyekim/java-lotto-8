package lotto.exception;

public enum LottoErrorCode {
    INVALID_NUMBER_FORMAT("숫자가 입력되어야 합니다."),
    INVALID_PURCHASE_FORMAT("구입 금액은 %s(으)로 나누어져야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 %s개여야 합니다."),
    DUPLICATED_NUMBER_NOT_ALLOWED("중복된 번호가 존재합니다."),
    INVALID_NUMBER_RANGE("로또 번호는 %s이상 %s이하 여야 합니다."),
    ;

    private static final String PREFIX = "[ERROR] ";

    private final String message;

    LottoErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
