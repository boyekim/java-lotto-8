package lotto.application.lottodivider;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoDividerTest {

    @Test
    @DisplayName("구분자 , 기준으로 문자열 파싱을 확인한다.")
    void divideByDelimiter() {
        // given
        LottoDivider lottoDivider = new LottoDivider();
        String input = "1,2,3";

        // when
        List<String> result = lottoDivider.divideByDelimiter(input);

        // then
        assertThat(result).containsExactly("1", "2", "3");
    }
}
