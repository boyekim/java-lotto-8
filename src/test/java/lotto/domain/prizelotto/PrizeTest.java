package lotto.domain.prizelotto;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PrizeTest {

    @ParameterizedTest
    @DisplayName("각 로또의 당첨 조건을 확인한다.")
    @MethodSource("providePrizeLotto")
    void satisfyWinningRequirement(int mainMatchCount, boolean isBonusMatch, Prize prize) {
        boolean isSatisfyPrizeRule = prize.isSatisfyWinningRequirement(mainMatchCount, isBonusMatch);
        Assertions.assertThat(isSatisfyPrizeRule).isTrue();
    }

    private static Stream<Arguments> providePrizeLotto() {
        return Stream.of(
                Arguments.of(6, false, new FirstPrize()),
                Arguments.of(5, true, new SecondPrize()),
                Arguments.of(5, false, new ThirdPrize()),
                Arguments.of(4, false, new FourthPrize()),
                Arguments.of(3, false, new FifthPrize())
        );
    }
}
