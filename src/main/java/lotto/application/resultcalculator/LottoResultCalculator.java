package lotto.application.resultcalculator;

import java.util.List;
import lotto.application.ResultMetricCalculateStrategy;
import lotto.domain.prizelotto.Prize;

public class LottoResultCalculator implements ResultMetricCalculateStrategy {

    @Override
    public double calculateProfit(long purchasePrice, List<Prize> prizes) {
        long total = 0;
        for (Prize prize : prizes) {
            total += prize.calculateTotalPrize();
        }
        return ((double) total / purchasePrice) * 100;
    }
}
