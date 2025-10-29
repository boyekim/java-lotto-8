package lotto.application;

import lotto.application.config.AppConfig;
import lotto.domain.LottoAmount;
import lotto.domain.PurchasePrice;

public class PurchaseApplication {
    private final Printer printer;
    private final Reader reader;
    private final LottoApplication lottoApplication;

    public PurchaseApplication(AppConfig appConfig) {
        printer = appConfig.printer();
        reader = appConfig.reader();
        lottoApplication = appConfig.lottoApplication();
    }

    public void run() {
        PurchasePrice purchasePrice = readPurchasePrice();
        LottoAmount lottoAmount = LottoAmount.from(purchasePrice.getValue());
        printer.printPurchaseLottoAmount(lottoAmount.getValue());
        lottoApplication.run(lottoAmount);
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
