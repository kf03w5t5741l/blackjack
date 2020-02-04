package blackjack.domain;

public enum Face {
    TWEE(2),
    DRIE(3),
    VIER(4),
    VIJF(5),
    ZES(6),
    ZEVEN(7),
    ACHT(8),
    NEGEN(9),
    TIEN(10),
    BOER(10, "B"),
    VROUW(10, "V"),
    HEER(10, "H"),
    AAS(11, "A");

    private int value;
    private String symbol;

    private Face(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    private Face(int value) {
        this(value, String.valueOf(value));
    }

    public int getValue() {
        return this.value;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
