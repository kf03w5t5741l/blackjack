package blackjack.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Card {
    private static final Card[] ACE_ARRAY = {
            new Card(Suit.SPADES, Face.ACE),
            new Card(Suit.HEARTS, Face.ACE),
            new Card(Suit.CLUBS, Face.ACE),
            new Card(Suit.DIAMONDS, Face.ACE)
    };
    public final Set ACES = new HashSet(Arrays.asList(ACE_ARRAY));

    private Suit suit;
    private Face face;

    public Card(Suit suit, Face face) {
        this.suit = suit;
        this.face = face;
    }

    public int getValue() {
        return this.face.getValue();
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

        if (this.face == otherCard.getFace()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.face.hashCode();
    }

    @Override
    public String toString() {
        return this.suit.getSymbol() + this.face.getSymbol();
    }
}
