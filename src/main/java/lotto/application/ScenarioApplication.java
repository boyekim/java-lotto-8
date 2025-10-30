package lotto.application;

import lotto.domain.dto.LottoAmountRequest;
import lotto.domain.dto.LottoComparisonRequest;

public class ScenarioApplication {

    private final PurchaseApplication purchaseApplication;
    private final LottoApplication lottoApplication;

    public ScenarioApplication(PurchaseApplication purchaseApplication, LottoApplication lottoApplication) {
        this.purchaseApplication = purchaseApplication;
        this.lottoApplication = lottoApplication;
    }

    public void run() {
        LottoAmountRequest lottoAmountRequest = purchaseApplication.run();
        LottoComparisonRequest lottoComparisonRequest = lottoApplication.run(lottoAmountRequest);
    }
}
