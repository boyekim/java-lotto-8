package lotto.application;

import lotto.domain.LottoAmount;
import lotto.domain.PurchasePrice;
import lotto.domain.dto.LottoPurchaseDto;

public class PurchaseApplication {
    private final Printer printer;
    private final Reader reader;

    public PurchaseApplication(Printer printer, Reader reader) {
        this.printer = printer;
        this.reader = reader;
    }

    public LottoPurchaseDto run() {
        PurchasePrice purchasePrice = readPurchasePrice();
        LottoAmount lottoAmount = LottoAmount.from(purchasePrice.getValue());
        printer.printPurchaseLottoAmount(lottoAmount.getValue());
        return LottoPurchaseDto.of(lottoAmount, purchasePrice);
    }

    private PurchasePrice readPurchasePrice() {
        printer.printPurchaseAmountRequest();
        try {
            return PurchasePrice.from(reader.read());
        } catch (IllegalArgumentException e) {
            printer.print(e.getMessage());
            return readPurchasePrice();
        }
    }
}
