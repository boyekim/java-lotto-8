package lotto.application;

import java.util.List;
import lotto.domain.Lotto;

public interface Printer {

    void print(String message);

    void printFormat(String format, String message);

    void printNewLine();

    void printPurchaseAmountRequest();

    void printPurchaseLottoAmount(long lottoAmount);

    void printAllBuyingLottos(List<Lotto> value);
}
