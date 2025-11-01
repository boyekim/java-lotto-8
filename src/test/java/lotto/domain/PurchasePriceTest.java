package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasePriceTest {

    @Test
    @DisplayName("구매 금액이 1000으로 나누어 떨어질때 정상 동작을 확인한다.")
    void divideByThousand() {
        // given
        String input = "3000";
        PurchasePrice purchasePrice = PurchasePrice.from(input);

        // when
        Long result = purchasePrice.getValue();

        // then
        assertThat(result).isEqualTo(3000);
    }

    @Test
    @DisplayName("구매 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    void divideByThousandException() {
        // given
        String input = "5700";

        // when, then
        assertThatThrownBy(() -> PurchasePrice.from(input))
                .isInstanceOf(LottoException.class)
                .hasMessage(LottoErrorCode.INVALID_PURCHASE_FORMAT.getMessage(), 1000)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("구매 금액에 숫자가 입력되지 않으면 예외가 발생한다.")
    void purchasePriceNumberException() {
        // given
        String input = "1000boye";

        // when, then
        assertThatThrownBy(() -> PurchasePrice.from(input))
                .isInstanceOf(LottoException.class)
                .hasMessage(LottoErrorCode.INVALID_NUMBER_FORMAT.getMessage())
                .hasMessageContaining("[ERROR]");
    }
}
