package lotto.domain;

import java.util.Comparator;
import java.util.List;
import lotto.domain.prizelotto.Prize;

public class Prizes {

    private final List<Prize> value;

    private Prizes(List<Prize> value) {
        this.value = value;
    }

    public static Prizes from(List<Prize> value) {
        return new Prizes(value);
    }

    public List<Prize> getValue() {
        return value;
    }

    public void sortByRank() {
        value.sort(Comparator.comparing(Prize::getRank).reversed());
    }
}
