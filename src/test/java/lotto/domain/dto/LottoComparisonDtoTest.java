package lotto.domain.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoComparisonDtoTest {

    @Test
    @DisplayName("구매 로또와 당첨 숫자를 담은 dto 생성시 구매 로또 정보의 정상 저장을 확인한다.")
    void lottosAtRequest() {
        // given
        Lotto lottoA = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Lotto lottoB = Lotto.from(List.of(7, 8, 9, 10, 11, 12));
        Lottos lottos = Lottos.from(List.of(lottoA, lottoB));
        WinningNumbers beforeBonusNumber = WinningNumbers.mainNumbersFrom(List.of("3", "4", "5", "6", "7", "8"));
        WinningNumbers winningNumbers = beforeBonusNumber.bonusNumberFrom("9");

        // when
        LottoComparisonDto lottoComparisonDto = LottoComparisonDto.of(lottos, winningNumbers);
        Lottos savedLottos = lottoComparisonDto.lottos();

        // then
        assertThat(savedLottos.getValue())
                .extracting(Lotto::getNumbers)
                .containsExactly(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(7, 8, 9, 10, 11, 12)
                );
    }

    @Test
    @DisplayName("구매 로또와 당첨 숫자를 담은 dto 생성시 구매 로또 정보의 정상 저장을 확인한다.")
    void winningNumbersAtRequest() {
        // given
        Lotto lottoA = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Lotto lottoB = Lotto.from(List.of(7, 8, 9, 10, 11, 12));
        Lottos lottos = Lottos.from(List.of(lottoA, lottoB));
        WinningNumbers beforeBonusNumber = WinningNumbers.mainNumbersFrom(List.of("3", "4", "5", "6", "7", "8"));
        WinningNumbers winningNumbers = beforeBonusNumber.bonusNumberFrom("9");

        // when
        LottoComparisonDto lottoComparisonDto = LottoComparisonDto.of(lottos, winningNumbers);
        WinningNumbers savedWinningNumbers = lottoComparisonDto.winningNumbers();

        // then
        assertThat(savedWinningNumbers)
                .extracting(WinningNumbers::getMainNumbers, WinningNumbers::getBonusNumber)
                .containsExactly(List.of(3, 4, 5, 6, 7, 8), 9);
    }
}
