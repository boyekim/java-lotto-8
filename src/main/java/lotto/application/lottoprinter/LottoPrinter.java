package lotto.application.lottoprinter;

import lotto.application.Printer;

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
    }
}
