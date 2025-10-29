package lotto.application.lottoprinter;

import java.util.List;
import lotto.application.Printer;
import lotto.domain.Lotto;

public class LottoPrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printFormat(String format, String message) {
        System.out.printf(format, message);
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
