package lotto.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> value;

    private Lottos(List<Lotto> value) {
        this.value = value;
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> getValue() {
        return value;
    }
}
