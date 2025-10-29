package lotto;

import lotto.application.LottoApplication;
import lotto.application.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoApplication lottoApplication = new LottoApplication(appConfig);
        lottoApplication.run();
    }
}
