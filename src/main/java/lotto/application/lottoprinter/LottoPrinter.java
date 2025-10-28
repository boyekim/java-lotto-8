package lotto.application.lottoprinter;

import lotto.application.Printer;

public class LottoPrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printPurchaseAmountRequest() {
        print("구입금액을 입력해 주세요.");
    }
}
