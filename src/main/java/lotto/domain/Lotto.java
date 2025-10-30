package lotto.domain;

import java.util.List;
import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;

public class Lotto {

    private static final int NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplicatedNumber(numbers);
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        int compareSize = numbers.size();
        if (numbers.stream().distinct().count() != compareSize) {
            throw new LottoException(LottoErrorCode.DUPLICATED_NUMBER_NOT_ALLOWED);
        }
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new LottoException(LottoErrorCode.INVALID_LOTTO_NUMBER_COUNT, NUMBER_SIZE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
