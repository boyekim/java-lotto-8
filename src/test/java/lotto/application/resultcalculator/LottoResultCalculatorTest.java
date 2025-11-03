package lotto.application.resultcalculator;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.prizelotto.FifthPrize;
import lotto.domain.prizelotto.FirstPrize;
import lotto.domain.prizelotto.FourthPrize;
import lotto.domain.prizelotto.Prize;
import lotto.domain.prizelotto.SecondPrize;
import lotto.domain.prizelotto.ThirdPrize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultCalculatorTest {

    @Test
    @DisplayName("수익률 계산을 검증한다.")
    void calculateProfit() {
        // given
        LottoResultCalculator calculator = new LottoResultCalculator();
        long purchasePrice = 8000;
        FirstPrize firstPrize = new FirstPrize();
        SecondPrize secondPrize = new SecondPrize();
        ThirdPrize thirdPrize = new ThirdPrize();
        FourthPrize fourthPrize = new FourthPrize();
        FifthPrize fifthPrize = new FifthPrize();
        fifthPrize.upCount();
        List<Prize> prizes = new ArrayList<>(List.of(
                firstPrize,
                secondPrize,
                thirdPrize,
                fourthPrize,
                fifthPrize
        ));

        // when
        double profit = calculator.calculateProfit(purchasePrice, prizes);
        String result = String.format("%.1f", profit);

        // then
        Assertions.assertThat(result).isEqualTo("62.5");
    }
}
