package lotto.application;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.prizelotto.PrizeLotto;

public interface Printer {

    void print(String message);

    void printFormat(String format, Object... args);

    void printNewLine();

    void printPurchaseAmountRequest();

    void printPurchaseLottoAmount(long lottoAmount);

    void printAllBuyingLottos(List<Lotto> value);

    void printWinningNumberRequest();

    void printBonusNumberRequest();

    void printEachPrizeResult(PrizeLotto prizeLotto);

    void printWinningStatistics();

    void printProfit(double profit);
}
