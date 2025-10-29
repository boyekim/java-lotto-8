package lotto.application.randomnumbersgenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.application.NumberGenerator;

public class RandomNumbersGenerator implements NumberGenerator {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT = 6;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT);
    }
}
