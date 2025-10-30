package lotto.domain.dto;

import lotto.domain.LottoAmount;

public record LottoAmountRequest(
        LottoAmount lottoAmount
) {

    public static LottoAmountRequest from(LottoAmount lottoAmount) {
        return new LottoAmountRequest(lottoAmount);
    }
}
