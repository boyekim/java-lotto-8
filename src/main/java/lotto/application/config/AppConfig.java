package lotto.application.config;

import lotto.application.Printer;
import lotto.application.lottoprinter.LottoPrinter;

public class AppConfig {

    public Printer printer() {
        return new LottoPrinter();
    }
}
