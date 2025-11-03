package lotto.domain.dto;

import lotto.domain.LottoAmount;
import lotto.domain.PurchasePrice;

public record LottoPurchaseDto(
        long lottoAmount,
        long purchasePrice
) {

    public static LottoPurchaseDto of(LottoAmount lottoAmount, PurchasePrice purchasePrice) {
        return new LottoPurchaseDto(lottoAmount.getValue(), purchasePrice.getValue());
    }
}
