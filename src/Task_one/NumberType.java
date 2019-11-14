package Task_one;

public enum NumberType {
    SIMPLE("простым"),
    CONSTRUCT("составным");

    private String type;

    NumberType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    /**
     * Determinate number's type (simple or not).
     */
    public static NumberType determineNumberType(int input) {
        int absoluteValue = Math.abs(input);
        for (int index = 2; index < absoluteValue; index++) {
            if (absoluteValue % index == 0) {
                return NumberType.CONSTRUCT;
            }
        }
        return NumberType.SIMPLE;
    }
}
