package lotto.domain.prizelotto;

public class FourthPrize extends PrizeLotto {

    public FourthPrize() {
        super(Prize.FOURTH_PRIZE);
    }

    @Override
    public boolean isSatisfyWinningRequirement(int mainMatchCount, boolean isBonusMatch) {
        return mainMatchCount == prize.getMatchCount();
    }
}
