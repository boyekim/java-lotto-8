package lotto.application.resultcalculator;

import java.util.List;
import lotto.application.ResultMetricCalculateStrategy;
import lotto.domain.prizelotto.PrizeLotto;

public class LottoResultCalculator implements ResultMetricCalculateStrategy {

    @Override
    public double calculateProfit(long purchasePrice, List<PrizeLotto> allPrizeLotto) {
        long total = 0;
        for (PrizeLotto prizeLotto : allPrizeLotto) {
            total += prizeLotto.calculateTotalPrize();
        }
        return ((double) total / purchasePrice) * 100;
    }
}
