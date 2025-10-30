package lotto.domain.prizelotto;

public class FirstPrize extends PrizeLotto {

    public FirstPrize() {
        super(Prize.FIRST_PRIZE);
    }

    @Override
    public boolean isSatisfyWinningRequirement(int mainMatchCount, boolean isBonusMatch) {
        return mainMatchCount == prize.getMatchCount();
    }

    @Override
    public int getRank() {
        return prize.getRank();
    }

    @Override
    public int getMatchCount() {
        return prize.getMatchCount();
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public String getPrizeMoneyToPrint() {
        return prize.getPrizeMoneyToPrint();
    }

    @Override
    public long calculateTotalPrize() {
        return count * prize.getPrizeMoney();
    }
}
