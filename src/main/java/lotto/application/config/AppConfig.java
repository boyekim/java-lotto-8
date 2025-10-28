package lotto.application.config;

import lotto.application.Printer;
import lotto.application.Reader;
import lotto.application.lottoprinter.LottoPrinter;
import lotto.application.lottoreader.LottoReader;

public class AppConfig {

    public Printer printer() {
        return new LottoPrinter();
    }

    public Reader reader() {
        return new LottoReader();
    }
}
