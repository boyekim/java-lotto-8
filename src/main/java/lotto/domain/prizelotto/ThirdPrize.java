package lotto.domain.prizelotto;

public class ThirdPrize extends Prize {

    public ThirdPrize() {
        super(LottoPrize.THIRD_PRIZE);
    }

    @Override
    public boolean isSatisfyWinningRequirement(int mainMatchCount, boolean isBonusMatch) {
        return mainMatchCount == lottoPrize.getMatchCount();
    }

    @Override
    public int getRank() {
        return lottoPrize.getRank();
    }

    @Override
    public int getMatchCount() {
        return lottoPrize.getMatchCount();
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public String getPrizeMoneyToPrint() {
        return lottoPrize.getPrizeMoneyToPrint();
    }

    @Override
    public long calculateTotalPrize() {
        return count * lottoPrize.getPrizeMoney();
    }
}
