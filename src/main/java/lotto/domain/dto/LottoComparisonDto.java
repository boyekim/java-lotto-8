package lotto.domain.dto;

import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;

public record LottoComparisonDto(
        Lottos lottos,
        WinningNumbers winningNumbers
) {

    public static LottoComparisonDto of(Lottos lottos, WinningNumbers winningNumbers) {
        return new LottoComparisonDto(lottos, winningNumbers);
    }
}
