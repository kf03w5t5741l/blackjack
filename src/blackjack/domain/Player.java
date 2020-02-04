package blackjack.domain;

import java.util.List;
import java.util.ArrayList;

public class Player {
    private String name;
    private List<Card> hand;
    private boolean playing;
    private int turns;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.playing = true;
        this.turns = 0;
    }

    public Card draw(Deck deck) {
        Card drawnCard = deck.draw();
        this.hand.add(drawnCard);
        return drawnCard;
    }

    public void setPlaying(boolean status) {
        this.playing = status;
    }

    public boolean isPlaying() {
        return this.playing;
    }

    public boolean isDead() {
        return this.getHandValue() > 21;
    }

    public String getName() {
        return this.name;
    }

    public List<Card> getHand() {
        return this.hand;
    }

    public int getHandValue() {
        int handValue = 0;
        for (Card card : hand) {
            handValue += card.getValue();
        }

        for (Object ace : Card.ACES) {
            if (this.hand.contains(ace) && handValue > 21) {
                handValue -= 10;
            }
        }

        return handValue;
    }

    public void incrementTurns() {
        this.turns++;
    }

    public int getTurns() {
        return this.turns;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.hand + " (value: " + this.getHandValue()
                + ")";
    }
}
