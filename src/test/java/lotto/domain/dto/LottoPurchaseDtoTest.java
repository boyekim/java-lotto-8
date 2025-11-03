package lotto.domain.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoAmount;
import lotto.domain.PurchasePrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseDtoTest {

    @Test
    @DisplayName("로또 구매 정보를 담은 dto 생성을 확인한다.")
    void lottoAmountRequest() {
        // given
        PurchasePrice purchasePrice = PurchasePrice.from("5000");
        LottoAmount lottoAmount = LottoAmount.from(5000);

        // when
        LottoPurchaseDto lottoPurchaseDto = LottoPurchaseDto.of(lottoAmount, purchasePrice);

        // then
        assertThat(lottoPurchaseDto)
                .extracting(
                        request -> lottoAmount.getValue(),
                        request -> purchasePrice.getValue())
                .isEqualTo(List.of(5L, 5000L));
    }
}
