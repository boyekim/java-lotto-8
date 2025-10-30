package lotto.domain.prizelotto;

public class FifthPrize extends PrizeLotto {

    public FifthPrize() {
        super(Prize.FIFTH_PRIZE);
    }

    @Override
    public boolean isSatisfyWinningRequirement(int mainMatchCount, boolean isBonusMatch) {
        return mainMatchCount == prize.getMatchCount();
    }
}
