package blackjack.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private static List<Card> generateNewDeck() {
        List<Card> newDeck = new ArrayList<Card>();
        for (Suit suit : Suit.values()) {
            for (Face face : Face.values()) {
                newDeck.add(new Card(suit, face));
            }
        }
        return newDeck;
    }

    private Random random;
    private List<Card> cards;

    public Deck() {
        this.random = new Random();
        this.cards = Deck.generateNewDeck();
    }

    public Card draw() {
        if (this.cards.isEmpty()) {
            return null;
        }

        Card drawnCard = this.cards.get(0);
        this.cards.remove(0);
        return drawnCard;
    }

    public void shuffle() {
        List<Card> shuffledDeck = new ArrayList<Card>();
        while (this.cards.size() > 0) {
            int whichCard = random.nextInt(this.cards.size());
            shuffledDeck.add(this.cards.get(whichCard));
            this.cards.remove(whichCard);
        }
        this.cards = shuffledDeck;
    }

    public int getSize() {
        return this.cards.size();
    }

    @Override
    public String toString() {
        return this.cards.toString();
    }
}
