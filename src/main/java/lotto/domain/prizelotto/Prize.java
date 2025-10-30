package lotto.domain.prizelotto;

import java.text.NumberFormat;

public enum Prize {
    FIRST_PRIZE(2000000000, 6, 1),
    SECOND_PRIZE(30000000, 5, 2),
    THIRD_PRIZE(1500000, 5, 3),
    FOURTH_PRIZE(50000, 4, 4),
    FIFTH_PRIZE(5000, 3, 5),
    ;

    private final long prizeMoney;
    private final int matchCount;
    private final int rank;

    Prize(long prizeMoney, int matchCount, int rank) {
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
        this.rank = rank;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrizeMoneyToPrint() {
        NumberFormat nf = NumberFormat.getInstance();
        return nf.format(prizeMoney);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getRank() {
        return rank;
    }
}
