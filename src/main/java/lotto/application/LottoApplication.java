package lotto.application;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.domain.dto.LottoPurchaseDto;
import lotto.domain.dto.LottoComparisonRequest;
import lotto.exception.LottoException;

public class LottoApplication {

    private final Printer printer;
    private final Reader reader;
    private final NumberGenerator numberGenerator;
    private final DivideStrategy divideStrategy;

    public LottoApplication(
            Printer printer,
            Reader reader,
            NumberGenerator numberGenerator,
            DivideStrategy divideStrategy
    ) {
        this.printer = printer;
        this.reader = reader;
        this.numberGenerator = numberGenerator;
        this.divideStrategy = divideStrategy;
    }

    public LottoComparisonRequest run(LottoPurchaseDto lottoPurchaseDto) {
        LottoAmount lottoAmount = lottoPurchaseDto.lottoAmount();
        List<Lotto> allLotto = makeLottos(lottoAmount.getValue(), new ArrayList<>());
        Lottos lottos = Lottos.from(allLotto);
        printer.printAllBuyingLottos(lottos.getValue());
        WinningNumbers winningNumbers = makeWinningNumbers();
        return LottoComparisonRequest.of(lottos, winningNumbers);
    }

    private List<Lotto> makeLottos(long remainLottoAmount, List<Lotto> allLotto) {
        if (remainLottoAmount == 0) {
            return allLotto;
        }
        List<Integer> lottoNumbers = numberGenerator.generate();
        Lotto lotto = Lotto.from(lottoNumbers);
        allLotto.add(lotto);
        return makeLottos(remainLottoAmount - 1, allLotto);
    }

    private WinningNumbers makeWinningNumbers() {
        WinningNumbers winningNumbersBeforeBonusNumber = makeWinningMainNumbers();
        return makeWinningBonusNumber(winningNumbersBeforeBonusNumber);
    }

    private WinningNumbers makeWinningBonusNumber(WinningNumbers winningNumbers) {
        try {
            printer.printBonusNumberRequest();
            String bonusNumberInput = reader.read();
            return winningNumbers.bonusNumberFrom(bonusNumberInput);
        } catch (LottoException e) {
            printer.print(e.getMessage());
            return makeWinningBonusNumber(winningNumbers);
        }
    }

    private WinningNumbers makeWinningMainNumbers() {
        try {
            printer.printWinningNumberRequest();
            String winningNumberInput = reader.read();
            List<String> numbers = divideStrategy.divideByDelimiter(winningNumberInput);
            return WinningNumbers.mainNumbersFrom(numbers);
        } catch (LottoException e) {
            printer.print(e.getMessage());
            return makeWinningMainNumbers();
        }
    }
}
