package lotto.application;

import lotto.application.config.AppConfig;
import lotto.domain.PurchasePrice;

public class LottoApplication {
    private final Printer printer;
    private final Reader reader;

    public LottoApplication(AppConfig appConfig) {
        printer = appConfig.printer();
        reader = appConfig.reader();
    }

    public void run() {
        printer.printPurchaseAmountRequest();
        PurchasePrice purchasePrice = PurchasePrice.from(reader.read());
    }
}
