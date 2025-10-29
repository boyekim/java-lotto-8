package lotto.application;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.Lottos;

public class LottoApplication {

    private final Printer printer;
    private final NumberGenerator numberGenerator;

    public LottoApplication(Printer printer, NumberGenerator numberGenerator) {
        this.printer = printer;
        this.numberGenerator = numberGenerator;
    }

    public void run(LottoAmount lottoAmount) {
        List<Lotto> allLotto = makeLottos(lottoAmount.getValue(), new ArrayList<>());
        Lottos lottos = Lottos.from(allLotto);
        printer.printAllBuyingLottos(lottos.getValue());
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
}
