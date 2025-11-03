package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.prizelotto.FifthPrize;
import lotto.domain.prizelotto.FirstPrize;
import lotto.domain.prizelotto.FourthPrize;
import lotto.domain.prizelotto.Prize;
import lotto.domain.prizelotto.SecondPrize;
import lotto.domain.prizelotto.ThirdPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizesTest {

    @Test
    @DisplayName("rank값을 기준으로 내림차순 정렬을 확인한다.")
    void sortingLottoByRank() {
        // given
        Prize firstPrize = new FirstPrize();
        Prize secondPrize = new SecondPrize();
        Prize thirdPrize = new ThirdPrize();
        Prize fourthPrize = new FourthPrize();
        Prize fifthPrize = new FifthPrize();
        List<Prize> lottos = List.of(firstPrize, secondPrize, thirdPrize, fourthPrize, fifthPrize);
        Prizes prizes = Prizes.from(new ArrayList<>(lottos));

        // when
        prizes.sortByRank();

        // then
        assertThat(prizes.getValue())
                .containsExactly(
                        fifthPrize,
                        fourthPrize,
                        thirdPrize,
                        secondPrize,
                        firstPrize
                );
    }
}
