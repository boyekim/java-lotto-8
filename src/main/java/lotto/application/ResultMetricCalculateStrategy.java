package lotto.application;

import java.util.List;
import lotto.domain.prizelotto.Prize;

public interface ResultMetricCalculateStrategy {

    double calculateProfit(long purchasePrice, List<Prize> prizes);
}
