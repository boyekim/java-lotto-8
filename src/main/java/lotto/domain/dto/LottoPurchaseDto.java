package lotto.domain.dto;

import lotto.domain.LottoAmount;
import lotto.domain.PurchasePrice;

public record LottoPurchaseDto(
        LottoAmount lottoAmount,
        PurchasePrice purchasePrice
) {

    public static LottoPurchaseDto of(LottoAmount lottoAmount, PurchasePrice purchasePrice) {
        return new LottoPurchaseDto(lottoAmount, purchasePrice);
    }
}
