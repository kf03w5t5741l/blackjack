package blackjack.domain;

public enum Face {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10, "B"),
    QUEEN(10, "V"),
    KING(10, "H"),
    ACE(11, "A");

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
