package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;
import lotto.exception.LottoStateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    @DisplayName("메인 숫자를 통한 당첨 숫자 생성을 확인한다.")
    void mainNumber() {
        // given
        List<String> mainNumbers = List.of("1", "2", "3", "4", "5", "6");

        // when
        WinningNumbers winningNumbers = WinningNumbers.mainNumbersFrom(mainNumbers);

        // then
        assertThat(winningNumbers.getMainNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("당첨 숫자에 중복이 있을 경우 예외가 발생한다.")
    void duplicatedMainNumberException() {
        // given
        List<String> mainNumbers = List.of("1", "1", "2", "3", "4", "5");

        // when, then
        assertThatThrownBy(() -> WinningNumbers.mainNumbersFrom(mainNumbers))
                .isInstanceOf(LottoException.class)
                .hasMessage(LottoErrorCode.DUPLICATED_NUMBER_NOT_ALLOWED.getMessage())
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 숫자에 숫자가 아닌 문자가 있을 경우 예외가 발생한다.")
    void mainNumberNumberException() {
        // given
        List<String> mainNumbers = List.of("boye", "1", "2", "3", "4", "5");

        // when, then
        assertThatThrownBy(() -> WinningNumbers.mainNumbersFrom(mainNumbers))
                .isInstanceOf(LottoException.class)
                .hasMessage(LottoErrorCode.INVALID_NUMBER_FORMAT.getMessage())
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 숫자에 로또 범위가 아닌 숫자가 있을 경우 예외가 발생한다.")
    void outOfRangeMainNumberException() {
        // given
        List<String> mainNumbers = List.of("46", "1", "2", "3", "4", "5");
        int START_RANGE = 1;
        int END_RANGE = 45;

        // when, then
        assertThatThrownBy(() -> WinningNumbers.mainNumbersFrom(mainNumbers))
                .isInstanceOf(LottoException.class)
                .hasMessage(LottoErrorCode.INVALID_NUMBER_RANGE.getMessage(), START_RANGE, END_RANGE)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 숫자가 6개가 아닐 경우 예외가 발생한다.")
    void mainNumberCountException() {
        // given
        List<String> mainNumbers = List.of("1", "2", "3", "4", "5");
        int LOTTO_COUNT = 6;

        // when, then
        assertThatThrownBy(() -> WinningNumbers.mainNumbersFrom(mainNumbers))
                .isInstanceOf(LottoException.class)
                .hasMessage(LottoErrorCode.INVALID_LOTTO_NUMBER_COUNT.getMessage(), LOTTO_COUNT)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("보너스 숫자의 생성을 확인한다.")
    void makeBonusNumber() {
        // given
        List<String> mainNumbers = List.of("1", "2", "3", "4", "5", "6");
        String bonusNumber = "7";
        WinningNumbers winningNumbers = WinningNumbers.mainNumbersFrom(mainNumbers);

        // when
        WinningNumbers winningNumbersWithBonusNumber = winningNumbers.bonusNumberFrom(bonusNumber);

        // then
        assertThat(winningNumbersWithBonusNumber.getBonusNumber()).isEqualTo(7);
    }

    @Test
    @DisplayName("보너스 숫자가 이미 메인 숫자에 존재할 경우 예외가 발생한다.")
    void duplicatedBonusNumberException() {
        // given
        List<String> mainNumbers = List.of("1", "2", "3", "4", "5", "6");
        String bonusNumber = "1";
        WinningNumbers winningNumbers = WinningNumbers.mainNumbersFrom(mainNumbers);

        // when, then
        assertThatThrownBy(() -> winningNumbers.bonusNumberFrom(bonusNumber))
                .isInstanceOf(LottoException.class)
                .hasMessage(LottoErrorCode.DUPLICATED_NUMBER_NOT_ALLOWED.getMessage())
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("보너스 숫자가 숫자가 아닌 문자일 경우 예외가 발생한다.")
    void bonusNumberNumberException() {
        // given
        List<String> mainNumbers = List.of("1", "2", "3", "4", "5", "6");
        String bonusNumber = "boye";
        WinningNumbers winningNumbers = WinningNumbers.mainNumbersFrom(mainNumbers);

        // when, then
        assertThatThrownBy(() -> winningNumbers.bonusNumberFrom(bonusNumber))
                .isInstanceOf(LottoException.class)
                .hasMessage(LottoErrorCode.INVALID_NUMBER_FORMAT.getMessage())
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("보너스 숫자가 로또 숫자 범위를 벗어날 경우 예외가 발생한다.")
    void bonusNumberRangeException() {
        // given
        List<String> mainNumbers = List.of("1", "2", "3", "4", "5", "6");
        String bonusNumber = "46";
        WinningNumbers winningNumbers = WinningNumbers.mainNumbersFrom(mainNumbers);
        int START_RANGE = 1;
        int END_RANGE = 45;

        // when, then
        assertThatThrownBy(() -> winningNumbers.bonusNumberFrom(bonusNumber))
                .isInstanceOf(LottoException.class)
                .hasMessage(LottoErrorCode.INVALID_NUMBER_RANGE.getMessage(), START_RANGE, END_RANGE)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("보너스 숫자가 null일 경우 조회 시 예외가 발생한다.")
    void bonusNumberStateException() {
        // given
        List<String> mainNumbers = List.of("1", "2", "3", "4", "5", "6");
        WinningNumbers winningNumbers = WinningNumbers.mainNumbersFrom(mainNumbers);

        // when, then
        assertThatThrownBy(winningNumbers::getBonusNumber)
                .isInstanceOf(LottoStateException.class)
                .hasMessage(LottoErrorCode.BONUS_NUMBER_NOT_EXIST.getMessage())
                .hasMessageContaining("[ERROR]");
    }
}
