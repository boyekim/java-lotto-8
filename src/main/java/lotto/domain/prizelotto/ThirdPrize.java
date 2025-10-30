package lotto.domain.prizelotto;

public class ThirdPrize extends PrizeLotto {

    public ThirdPrize() {
        super(Prize.THIRD_PRIZE);
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
