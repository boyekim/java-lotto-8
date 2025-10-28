package lotto.application.lottoreader;

import camp.nextstep.edu.missionutils.Console;
import lotto.application.Reader;

public class LottoReader implements Reader {
    @Override
    public String read() {
        return Console.readLine();
    }
}
