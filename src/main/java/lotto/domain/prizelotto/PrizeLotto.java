package lotto.domain.prizelotto;

public abstract class PrizeLotto {

    protected final Prize prize;

    protected PrizeLotto(Prize prize) {
        this.prize = prize;
    }

    int count;

    public void upCount() {
        count++;
    }

    public abstract boolean isSatisfyWinningRequirement(int mainMatchCount, boolean isBonusMatch);

    public int getRank() {
        return prize.getRank();
    }

    public int getCount() {
        return count;
    }

    public int getMatchCount() {
        return prize.getMatchCount();
    }

    public long getPrizeMoney() {
        return prize.getPrizeMoney();
    }

    public String getPrizeMoneyToPrint() {
        return prize.getPrizeMoneyToPrint();
    }
}
