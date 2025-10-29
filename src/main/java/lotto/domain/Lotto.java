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
        if (numbers.size() != NUMBER_SIZE) {
            throw new LottoException(LottoErrorCode.INVALID_LOTTO_NUMBER_COUNT, NUMBER_SIZE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
