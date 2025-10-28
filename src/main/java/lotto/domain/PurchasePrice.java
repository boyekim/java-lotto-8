package lotto.domain;

public class PurchasePrice {

    private static final int DIVISOR_UNIT = 1000;

    private Long value;

    private PurchasePrice(Long value) {
        this.value = value;
    }

    public static PurchasePrice from(String input) {
        Long price = validateAndParse(input);
        validateIsDivisible(price);
        return new PurchasePrice(price);
    }

    private static void validateIsDivisible(Long price) {
        if (price % DIVISOR_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 %s로 나누어져야 합니다.");
        }
    }

    private static Long validateAndParse(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자가 입력되어야 합니다.");
        }
    }
}
