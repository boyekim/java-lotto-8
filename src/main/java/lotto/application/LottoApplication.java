package lotto.application;

import lotto.application.config.AppConfig;

public class LottoApplication {
    private final Printer printer;

    public LottoApplication(AppConfig appConfig) {
        this.printer = appConfig.printer();
    }

    public void run() {
        printer.printPurchaseAmountRequest();
    }
}
