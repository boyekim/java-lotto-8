package lotto.application;

import java.util.List;
import lotto.domain.prizelotto.PrizeLotto;

public interface ResultMetricCalculateStrategy {

    double calculateProfit(long purchasePrice, List<PrizeLotto> allPrizeLotto);
}
