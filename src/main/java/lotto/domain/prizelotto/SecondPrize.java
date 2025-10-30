package lotto.domain.prizelotto;

public class SecondPrize extends PrizeLotto {

    public SecondPrize() {
        super(Prize.SECOND_PRIZE);
    }

    @Override
    public boolean isSatisfyWinningRequirement(int mainMatchCount, boolean isBonusMatch) {
        return mainMatchCount == prize.getMatchCount() && isBonusMatch;
    }
}
