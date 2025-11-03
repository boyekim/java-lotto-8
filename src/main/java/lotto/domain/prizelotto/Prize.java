package lotto.domain.prizelotto;

public abstract class Prize {

    protected final LottoPrize lottoPrize;

    protected Prize(LottoPrize lottoPrize) {
        this.lottoPrize = lottoPrize;
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
