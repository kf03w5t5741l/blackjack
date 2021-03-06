package blackjack.domain;

public enum Suit {
    CLUBS("C"),
    DIAMONDS("D"),
    HEARTS("H"),
    SPADES("S");

    private String symbol;

    private Suit(String s) {
        this.symbol = s;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
