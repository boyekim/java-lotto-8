package lotto.application.config;

import lotto.application.DivideStrategy;
import lotto.application.LottoApplication;
import lotto.application.NumberGenerator;
import lotto.application.Printer;
import lotto.application.Reader;
import lotto.application.lottodivider.LottoDivider;
import lotto.application.lottoprinter.LottoPrinter;
import lotto.application.lottoreader.LottoReader;
import lotto.application.randomnumbersgenerator.RandomNumbersGenerator;

public class AppConfig {

    public Printer printer() {
        return new LottoPrinter();
    }

    public Reader reader() {
        return new LottoReader();
    }

    public NumberGenerator numberGenerator() {
        return new RandomNumbersGenerator();
    }

    public DivideStrategy divideStrategy() {
        return new LottoDivider();
    }

    public LottoApplication lottoApplication() {
        return new LottoApplication(printer(), reader(), numberGenerator(), divideStrategy());
    }
}
