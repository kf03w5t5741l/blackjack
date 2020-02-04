package blackjack.domain;

public class Card {
    private Suit suit;
    private Face face;

    public Card(Suit suit, Face face) {
        this.suit = suit;
        this.face = face;
    }

    public int getValue() {
        return this.face.getValue();
    }

    @Override
    public String toString() {
        return this.suit.getSymbol() + this.face.getSymbol();
    }
}
