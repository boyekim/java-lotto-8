package lotto.application;

import lotto.application.config.AppConfig;
import lotto.domain.LottoAmount;
import lotto.domain.PurchasePrice;

public class LottoApplication {
    private final Printer printer;
    private final Reader reader;

    public LottoApplication(AppConfig appConfig) {
        printer = appConfig.printer();
        reader = appConfig.reader();
    }

    public void run() {
        PurchasePrice purchasePrice = readPurchasePrice();
        LottoAmount lottoAmount = LottoAmount.from(purchasePrice.getValue());
        printer.printPurchaseLottoAmount(lottoAmount.getValue());
    }

    private PurchasePrice readPurchasePrice() {
        printer.printPurchaseAmountRequest();
        try {
            return PurchasePrice.from(reader.read());
        } catch (IllegalArgumentException e) {
            printer.print(e.getMessage());
            return readPurchasePrice();
        }
    }
}
