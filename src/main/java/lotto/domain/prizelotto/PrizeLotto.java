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

    public abstract int getRank();

    public abstract int getMatchCount();

    public abstract int getCount();

    public abstract String getPrizeMoneyToPrint();

    public abstract long calculateTotalPrize();
}
