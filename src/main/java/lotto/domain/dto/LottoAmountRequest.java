package lotto.domain.dto;

import lotto.domain.LottoAmount;
import lotto.domain.PurchasePrice;

public record LottoAmountRequest(
        LottoAmount lottoAmount,
        PurchasePrice purchasePrice
) {

    public static LottoAmountRequest from(LottoAmount lottoAmount, PurchasePrice purchasePrice) {
        return new LottoAmountRequest(lottoAmount, purchasePrice);
    }
}
