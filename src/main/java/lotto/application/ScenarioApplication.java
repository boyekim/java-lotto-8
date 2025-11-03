package lotto.application;

import lotto.domain.dto.LottoPurchaseDto;
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
        LottoPurchaseDto lottoPurchaseDto = purchaseApplication.run();
        LottoComparisonRequest lottoComparisonRequest = lottoApplication.run(lottoPurchaseDto);
        resultApplication.run(lottoComparisonRequest, lottoPurchaseDto.purchasePrice());
    }
}
