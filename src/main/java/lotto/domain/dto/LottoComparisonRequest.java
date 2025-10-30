package lotto.domain.dto;

import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;

public record LottoComparisonRequest(
        Lottos lottos,
        WinningNumbers winningNumbers
) {

    public static LottoComparisonRequest of(Lottos lottos, WinningNumbers winningNumbers) {
        return new LottoComparisonRequest(lottos, winningNumbers);
    }
}
