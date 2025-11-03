package lotto.application;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Prizes;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningNumbers;
import lotto.domain.dto.LottoComparisonDto;
import lotto.domain.dto.LottoPurchaseDto;
import lotto.domain.prizelotto.Prize;

public class ResultApplication {

    private final ResultMetricCalculateStrategy resultMetricCalculateStrategy;
    private final Printer printer;
    private final Prizes prizes;

    public ResultApplication(
            ResultMetricCalculateStrategy resultMetricCalculateStrategy,
            Printer printer,
            Prizes prizes
    ) {
        this.resultMetricCalculateStrategy = resultMetricCalculateStrategy;
        this.printer = printer;
        this.prizes = prizes;
    }

    public void run(LottoComparisonDto lottoComparisonDto, LottoPurchaseDto lottoPurchaseDto) {
        Lottos lottos = lottoComparisonDto.lottos();
        WinningNumbers winningNumbers = lottoComparisonDto.winningNumbers();
        findPrizeToAllLotto(lottos, winningNumbers);
        prizes.sortByRank();
        printResult();
        PurchasePrice purchasePrice = lottoPurchaseDto.purchasePrice();
        double profit = resultMetricCalculateStrategy.calculateProfit(purchasePrice.getValue(), prizes.getValue());
        printProfit(profit);
    }

    private void findPrizeToAllLotto(Lottos lottos, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottos.getValue()) {
            int mainNumbersMatchCount = checkMatchCount(lotto, winningNumbers);
            boolean bonusNumberMatch = checkBonusNumberMatch(lotto, winningNumbers);
            findPrize(mainNumbersMatchCount, bonusNumberMatch);
        }
    }

    private void printProfit(double profit) {
        printer.printProfit(profit);
    }

    private void printResult() {
        printer.printWinningStatistics();
        List<Prize> allPrizes = prizes.getValue();
        for (Prize prize : allPrizes) {
            printer.printEachPrizeResult(prize);
        }
    }

    private void findPrize(int mainNumbersMatchCount, boolean bonusNumberMatch) {
        List<Prize> prizes = this.prizes.getValue();
        for (Prize prize : prizes) {
            if (prize.isSatisfyWinningRequirement(mainNumbersMatchCount, bonusNumberMatch)) {
                prize.upCount();
                return;
            }
        }
    }

    private int checkMatchCount(Lotto lotto, WinningNumbers winningNumbers) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            List<Integer> mainNumbers = winningNumbers.getMainNumbers();
            if (mainNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean checkBonusNumberMatch(Lotto lotto, WinningNumbers winningNumbers) {
        List<Integer> numbers = lotto.getNumbers();
        return numbers.contains(winningNumbers.getBonusNumber());
    }
}
