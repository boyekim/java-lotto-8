package lotto.application;

import lotto.domain.dto.LottoPurchaseDto;
import lotto.domain.dto.LottoComparisonDto;

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
        LottoComparisonDto lottoComparisonDto = lottoApplication.run(lottoPurchaseDto);
        resultApplication.run(lottoComparisonDto, lottoPurchaseDto.purchasePrice());
    }
}
