package lotto.application.lottodivider;

import java.util.Arrays;
import java.util.List;
import lotto.application.DivideStrategy;

public class LottoDivider implements DivideStrategy {

    private static final String DELIMITER = ",";

    @Override
    public List<String> divideByDelimiter(String input) {
        return Arrays.stream(input.split(DELIMITER)).toList();
    }
}
