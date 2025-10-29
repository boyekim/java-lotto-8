package lotto.exception;

public class LottoException extends IllegalArgumentException {

    private final String errorCode;

    public LottoException(LottoErrorCode errorCode, Object... args) {
        super(String.format(errorCode.getMessage(), args));
        this.errorCode = errorCode.getMessage();
    }
}
