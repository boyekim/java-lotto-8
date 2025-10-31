package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAmountTest {

    @Test
    @DisplayName("로또의 수량 계산을 확인한다.")
    void calculateLottoAmount() {
        // given
        long purchasePrice = 8000;

        // when
        LottoAmount lottoAmount = LottoAmount.from(purchasePrice);

        // then
        assertThat(lottoAmount.getValue()).isEqualTo(purchasePrice / PurchasePrice.DIVISOR_UNIT);
    }

}
