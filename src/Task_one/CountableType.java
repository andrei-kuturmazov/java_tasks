package Task_one;

public enum CountableType {
    COUNTABLE("четным"),
    UNCOUNTABLE("нечетным");

    private String type;

    CountableType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    /**
     * Determinate number's parity type.
     */
    public static CountableType getParityType(int input) {
        return input % 2 == 0 ? CountableType.COUNTABLE : CountableType.UNCOUNTABLE;
    }
}
