package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    @DisplayName("로또 배열을 통한 도메인 생성을 확인한다.")
    void from() {
        // given
        Lotto lottoA = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lottoB = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        // when
        Lottos lottos = Lottos.from(List.of(lottoA, lottoB));

        // then
        assertThat(lottos.getValue())
                .hasSize(2)
                .extracting(Lotto::getNumbers)
                .containsExactly(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(7, 8, 9, 10, 11, 12)
                );
    }
}
