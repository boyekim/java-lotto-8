package lotto.application.lottoprinter;

import java.util.List;
import lotto.application.Printer;
import lotto.domain.Lotto;
import lotto.domain.prizelotto.PrizeLotto;

public class LottoPrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printFormat(String format, Object... args) {
        System.out.printf(format, args);
    }

    @Override
    public void printNewLine() {
        System.out.println();
    }

    @Override
    public void printPurchaseAmountRequest() {
        print("구입금액을 입력해 주세요.");
    }

    @Override
    public void printPurchaseLottoAmount(long lottoAmount) {
        printNewLine();
        printFormat("%s개를 구매했습니다.", String.valueOf(lottoAmount));
        printNewLine();
    }

    @Override
    public void printAllBuyingLottos(List<Lotto> value) {
        for (Lotto lotto : value) {
            List<Integer> sortedNumbers = getSortedNumbers(lotto);
            List<String> numbers = convertNumbers(sortedNumbers);
            String joinedNumbers = String.join(",", numbers);
            print("[" + joinedNumbers + "]");
        }
    }

    @Override
    public void printWinningNumberRequest() {
        printNewLine();
        print("당첨 번호를 입력해 주세요.");
    }

    @Override
    public void printBonusNumberRequest() {
        printNewLine();
        print("보너스 번호를 입력해 주세요.");
    }

    @Override
    public void printEachPrizeResult(PrizeLotto prizeLotto) {
        String result = makeEachResult(prizeLotto);
        printFormat(
                result,
                prizeLotto.getMatchCount(),
                prizeLotto.getPrizeMoneyToPrint(),
                prizeLotto.getCount()
        );
        printNewLine();
    }

    @Override
    public void printWinningStatistics() {
        printNewLine();
        print("당첨 통계");
        print("---");
    }

    @Override
    public void printProfit(double profit) {
        printFormat("총 수익률은 %.1f%%입니다.", profit);
    }

    private String makeEachResult(PrizeLotto prizeLotto) {
        StringBuilder result = new StringBuilder("%s개 일치");
        if (prizeLotto.getRank() == 2) {
            result.append(", 보너스 볼 일치 (%s원) - %s개");
            return result.toString();
        }
        result.append(" (%s원) - %s개");
        return result.toString();
    }

    private List<Integer> getSortedNumbers(Lotto lotto) {
        List<Integer> copyOfLotto = List.copyOf(lotto.getNumbers());
        return copyOfLotto.stream()
                .sorted()
                .toList();
    }

    private static List<String> convertNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .toList();
    }
}
