package lotto.domain.prizelotto;

public class FirstPrize extends PrizeLotto {

    public FirstPrize() {
        super(Prize.FIRST_PRIZE);
    }

    @Override
    public boolean isSatisfyWinningRequirement(int mainMatchCount, boolean isBonusMatch) {
        return mainMatchCount == prize.getMatchCount();
    }
}
