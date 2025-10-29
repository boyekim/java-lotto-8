package lotto.application;

public interface Printer {

    void print(String message);

    void printFormat(String format, String message);

    void printNewLine();

    void printPurchaseAmountRequest();

    void printPurchaseLottoAmount(long lottoAmount);
}
