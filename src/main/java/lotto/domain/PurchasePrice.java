package lotto.domain;

import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;

public class PurchasePrice {

    public static final int DIVISOR_UNIT = 1000;

    private final Long value;

    private PurchasePrice(Long value) {
        this.value = value;
    }

    public static PurchasePrice from(String input) {
        Long price = validateAndParse(input);
        validateIsDivisible(price);
        return new PurchasePrice(price);
    }

    private static void validateIsDivisible(Long price) {
        if (price % DIVISOR_UNIT != 0) {
            throw new LottoException(LottoErrorCode.INVALID_PURCHASE_FORMAT, DIVISOR_UNIT);
        }
    }

    private static Long validateAndParse(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new LottoException(LottoErrorCode.INVALID_NUMBER_FORMAT);
        }
    }

    public Long getValue() {
        return value;
    }
}
