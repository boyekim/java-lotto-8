package lotto.application;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PrizeLottos;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningNumbers;
import lotto.domain.dto.LottoComparisonRequest;
import lotto.domain.prizelotto.PrizeLotto;

public class ResultApplication {

    private final Printer printer;
    private final PrizeLottos prizeLottos;

    public ResultApplication(Printer printer, PrizeLottos prizeLottos) {
        this.printer = printer;
        this.prizeLottos = prizeLottos;
    }

    public void run(LottoComparisonRequest lottoComparisonRequest, PurchasePrice purchasePrice) {
        Lottos lottos = lottoComparisonRequest.lottos();
        WinningNumbers winningNumbers = lottoComparisonRequest.winningNumbers();
        for (Lotto lotto : lottos.getValue()) {
            int mainNumbersMatchCount = checkMatchCount(lotto, winningNumbers);
            boolean bonusNumberMatch = checkBonusNumberMatch(lotto, winningNumbers);
            findPrize(mainNumbersMatchCount, bonusNumberMatch);
        }
        prizeLottos.sortByRank();
        printResult();
        double profit = calculateProfit(purchasePrice);
        printProfit(profit);
    }

    private void printProfit(double profit) {
        printer.printProfit(profit);
    }

    private double calculateProfit(PurchasePrice purchasePrice) {
        List<PrizeLotto> allPrizeLotto = prizeLottos.getValue();
        long total = 0;
        for (PrizeLotto prizeLotto : allPrizeLotto) {
            total += prizeLotto.calculateTotalPrize();
        }
        return ((double) total / purchasePrice.getValue()) * 100;
    }

    private void printResult() {
        printer.printWinningStatistics();
        List<PrizeLotto> allPrizeLotto = prizeLottos.getValue();
        for (PrizeLotto prizeLotto : allPrizeLotto) {
            printer.printEachPrizeResult(prizeLotto);
        }
    }

    private void findPrize(int mainNumbersMatchCount, boolean bonusNumberMatch) {
        List<PrizeLotto> prizelottos = prizeLottos.getValue();
        for (PrizeLotto prizelotto : prizelottos) {
            if (prizelotto.isSatisfyWinningRequirement(mainNumbersMatchCount, bonusNumberMatch)) {
                prizelotto.upCount();
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
