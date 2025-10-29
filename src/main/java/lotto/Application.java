package lotto;

import lotto.application.PurchaseApplication;
import lotto.application.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        PurchaseApplication purchaseApplication = new PurchaseApplication(appConfig);
        purchaseApplication.run();
    }
}
