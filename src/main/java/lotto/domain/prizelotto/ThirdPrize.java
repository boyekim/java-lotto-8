package lotto.domain.prizelotto;

public class ThirdPrize extends PrizeLotto {

    public ThirdPrize() {
        super(Prize.THIRD_PRIZE);
    }

    @Override
    public boolean isSatisfyWinningRequirement(int mainMatchCount, boolean isBonusMatch) {
        return mainMatchCount == prize.getMatchCount();
    }
}
