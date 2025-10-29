package lotto.domain;

import java.util.List;
import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;

public class WinningNumbers {

    private static final int NUMBER_SIZE = 6;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    private final List<Integer> mainNumbers;
    private final Integer bonusNumber;

    private WinningNumbers(List<Integer> mainNumbers, Integer bonusNumber) {
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers mainNumbersFrom(List<String> mainNumbers) {
        List<Integer> parsedMainNumbers = parsingMainNumbers(mainNumbers);
        validateMainNumbersCount(parsedMainNumbers);
        validateDuplicated(parsedMainNumbers);
        validateAllNumberRange(parsedMainNumbers);
        return new WinningNumbers(parsedMainNumbers, null);
    }

    public WinningNumbers bonusNumberFrom(String bonusNumber) {
        Integer parsedBonusNumber = parsingBonusNumber(bonusNumber);
        validateFirstNumber(parsedBonusNumber);
        validateRangeOfNumber(parsedBonusNumber);
        return new WinningNumbers(mainNumbers, parsedBonusNumber);
    }

    private static void validateAllNumberRange(List<Integer> parsedMainNumbers) {
        for (Integer parsedMainNumber : parsedMainNumbers) {
            validateRangeOfNumber(parsedMainNumber);
        }
    }

    private static void validateRangeOfNumber(Integer parsedBonusNumber) {
        if (parsedBonusNumber < START_NUMBER || parsedBonusNumber > END_NUMBER) {
            throw new LottoException(LottoErrorCode.INVALID_NUMBER_RANGE);
        }
    }

    private void validateFirstNumber(Integer parsedBonusNumber) {
        if (mainNumbers.contains(parsedBonusNumber)) {
            throw new LottoException(LottoErrorCode.DUPLICATED_NUMBER_NOT_ALLOWED);
        }
    }

    private static void validateMainNumbersCount(List<Integer> parsedMainNumbers) {
        if (parsedMainNumbers.size() != NUMBER_SIZE) {
            throw new LottoException(LottoErrorCode.INVALID_LOTTO_NUMBER_COUNT, NUMBER_SIZE);
        }
    }

    private static void validateDuplicated(List<Integer> parsedMainNumbers) {
        if (parsedMainNumbers.size() != parsedMainNumbers.stream().distinct().count()) {
            throw new LottoException(LottoErrorCode.DUPLICATED_NUMBER_NOT_ALLOWED);
        }
    }

    private static List<Integer> parsingMainNumbers(List<String> numbers) {
        try {
            return numbers.stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new LottoException(LottoErrorCode.INVALID_NUMBER_FORMAT);
        }
    }

    private static Integer parsingBonusNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new LottoException(LottoErrorCode.INVALID_NUMBER_FORMAT);
        }
    }

    public List<Integer> getMainNumbers() {
        return mainNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
