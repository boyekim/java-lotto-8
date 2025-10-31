package lotto.application.config;

import java.util.ArrayList;
import java.util.List;
import lotto.application.DivideStrategy;
import lotto.application.LottoApplication;
import lotto.application.NumberGenerator;
import lotto.application.Printer;
import lotto.application.PurchaseApplication;
import lotto.application.Reader;
import lotto.application.ResultApplication;
import lotto.application.ResultMetricCalculateStrategy;
import lotto.application.ScenarioApplication;
import lotto.application.lottodivider.LottoDivider;
import lotto.application.lottoprinter.LottoPrinter;
import lotto.application.lottoreader.LottoReader;
import lotto.application.randomnumbersgenerator.RandomNumbersGenerator;
import lotto.application.resultcalculator.LottoResultCalculator;
import lotto.domain.PrizeLottos;
import lotto.domain.prizelotto.FifthPrize;
import lotto.domain.prizelotto.FirstPrize;
import lotto.domain.prizelotto.FourthPrize;
import lotto.domain.prizelotto.PrizeLotto;
import lotto.domain.prizelotto.SecondPrize;
import lotto.domain.prizelotto.ThirdPrize;

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

    public ResultMetricCalculateStrategy resultMetricCalculateStrategy() {
        return new LottoResultCalculator();
    }

    public PurchaseApplication purchaseApplication() {
        return new PurchaseApplication(printer(), reader());
    }

    public LottoApplication lottoApplication() {
        return new LottoApplication(printer(), reader(), numberGenerator(), divideStrategy());
    }

    public ResultApplication resultApplication() {
        return new ResultApplication(resultMetricCalculateStrategy(), printer(), prizeLottos());
    }

    public ScenarioApplication scenarioApplication() {
        return new ScenarioApplication(purchaseApplication(), lottoApplication(), resultApplication());
    }

    public PrizeLottos prizeLottos() {
        List<PrizeLotto> prizeLottos = List.of(
                new FirstPrize(),
                new SecondPrize(),
                new ThirdPrize(),
                new FourthPrize(),
                new FifthPrize()
        );
        return PrizeLottos.from(new ArrayList<>(prizeLottos));
    }
}
