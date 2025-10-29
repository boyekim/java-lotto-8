package lotto.domain;

public class LottoAmount {

    private static final int DIVISOR_UNIT = 1000;

    private final long value;

    private LottoAmount(long value) {
        this.value = value;
    }

    public static LottoAmount from(long purchasePrice) {
        long lottoAmount = purchasePrice / DIVISOR_UNIT;
        return new LottoAmount(lottoAmount);
    }

    public long getValue() {
        return value;
    }
}
