package lotto;

import lotto.application.ScenarioApplication;
import lotto.application.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        ScenarioApplication scenarioApplication = appConfig.scenarioApplication();
        scenarioApplication.run();
    }
}
