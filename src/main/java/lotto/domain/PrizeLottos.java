package lotto.domain;

import java.util.Comparator;
import java.util.List;
import lotto.domain.prizelotto.PrizeLotto;

public class PrizeLottos {

    private final List<PrizeLotto> value;

    private PrizeLottos(List<PrizeLotto> value) {
        this.value = value;
    }

    public static PrizeLottos from(List<PrizeLotto> value) {
        return new PrizeLottos(value);
    }

    public List<PrizeLotto> getValue() {
        return value;
    }

    public void sortByRank() {
        value.sort(Comparator.comparing(PrizeLotto::getRank).reversed());
    }
}
