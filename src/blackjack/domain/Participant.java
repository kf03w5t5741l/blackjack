package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Participant {
    private String name;
    private List<Card> hand;
    private boolean playing;
    private int turns;

    public Participant(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.playing = true;
        this.turns = 0;
    }


    public Card draw(Deck deck) {
        Card drawnCard = deck.draw();
        if (drawnCard != null) {
            this.hand.add(drawnCard);
        }
        return drawnCard;
    }

    public List<Card> draw(Deck deck, int amount) {
        List<Card> drawnCards = new ArrayList();
        for (int i = 0; i < amount; i++) {
            Card drawnCard = this.draw(deck);

            if (drawnCard == null) {
                return null;
            }

            drawnCards.add(drawnCard);
        }
        return drawnCards;
    }

    public void setPlaying(boolean status) {
        this.playing = status;
    }

    public boolean isPlaying() {
        return this.playing;
    }

    public boolean isDead() {
        return this.handValue() > 21;
    }

    public String getName() {
        return this.name;
    }

    public List<Card> getHand() {
        return this.hand;
    }

    public int handValue() {
        int handValue = 0;
        for (Card card : hand) {
            handValue += card.getValue();
        }

        for (Card ace : Card.getAces()) {
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

    public void prepareForNewRound() {
        this.setPlaying(true);
        this.hand.clear();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        }

        if (this.getClass() != otherObject.getClass()) {
            return false;
        }

        Player otherPlayer = (Player) otherObject;

        if (this.name.equals(otherPlayer.getName())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return this.name + ": " + this.hand + " (value: " + this.handValue()
                + ")";
    }
}
