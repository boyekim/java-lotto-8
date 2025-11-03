package lotto.domain;

import java.util.Comparator;
import java.util.List;
import lotto.domain.prizelotto.PrizeLotto;

public class Prizes {

    private final List<PrizeLotto> value;

    private Prizes(List<PrizeLotto> value) {
        this.value = value;
    }

    public static Prizes from(List<PrizeLotto> value) {
        return new Prizes(value);
    }

    public List<PrizeLotto> getValue() {
        return value;
    }

    public void sortByRank() {
        value.sort(Comparator.comparing(PrizeLotto::getRank).reversed());
    }
}
