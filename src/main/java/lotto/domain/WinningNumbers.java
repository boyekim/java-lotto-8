package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> mainNumbers;
    private final Integer bonusNumber;

    private WinningNumbers(List<Integer> mainNumbers, Integer bonusNumber) {
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers of(List<Integer> mainNumbers, Integer bonusNumber) {
        return new WinningNumbers(mainNumbers, bonusNumber);
    }
}
