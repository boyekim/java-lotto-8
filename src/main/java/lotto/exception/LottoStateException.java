package lotto.exception;

public class LottoStateException extends IllegalStateException {

    private final String errorCode;

    public LottoStateException(LottoErrorCode errorCode, Object... args) {
        super(String.format(errorCode.getMessage(), args));
        this.errorCode = errorCode.getMessage();
    }
}
