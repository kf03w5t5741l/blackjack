package blackjack.domain;

import java.util.List;
import java.util.ArrayList;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
    }

    public void draw(Deck deck) {
        Card drawnCard = deck.draw();
        this.hand.add(drawnCard);
    }

    public List<Card> getHand() {
        return this.hand;
    }

    public int getHandValue() {
        int handValue = 0;
        for (Card card : hand) {
            handValue += card.getValue();
        }
        return handValue;
    }
}
