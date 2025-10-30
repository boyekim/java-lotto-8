package lotto.application;

import lotto.domain.dto.LottoAmountRequest;
import lotto.domain.dto.LottoComparisonRequest;

public class ScenarioApplication {

    private final PurchaseApplication purchaseApplication;
    private final LottoApplication lottoApplication;
    private final ResultApplication resultApplication;

    public ScenarioApplication(PurchaseApplication purchaseApplication,
                               LottoApplication lottoApplication,
                               ResultApplication resultApplication) {
        this.purchaseApplication = purchaseApplication;
        this.lottoApplication = lottoApplication;
        this.resultApplication = resultApplication;
    }

    public void run() {
        LottoAmountRequest lottoAmountRequest = purchaseApplication.run();
        LottoComparisonRequest lottoComparisonRequest = lottoApplication.run(lottoAmountRequest);
        resultApplication.run(lottoComparisonRequest);
    }
}
