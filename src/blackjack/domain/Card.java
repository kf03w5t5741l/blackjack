package blackjack.domain;

import java.util.Objects;

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

    public Suit getSuit() {
        return this.suit;
    }

    public Face getFace() {
        return this.face;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        }

        if (this.getClass() != otherObject.getClass()) {
            return false;
        }

        Card otherCard = (Card)otherObject;

        if (this.suit == otherCard.getSuit()
                && this.face == otherCard.getFace()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.suit.hashCode(), this.face.hashCode());
    }

    @Override
    public String toString() {
        return this.face.getSymbol() + this.suit.getSymbol();
    }
}
