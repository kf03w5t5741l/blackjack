package blackjack.logic;

import java.util.List;

import blackjack.domain.Deck;
import blackjack.domain.Card;
import blackjack.domain.Player;

public class GameRound {
    private Deck deck;
    private List<Player> players;
    private Player house;

    public GameRound(List<Player> players) {
        this.deck = new Deck();
        this.deck.shuffle();
        this.players = players;
        this.house = new Player("The House");

        for (Player player : this.players) {
            player.draw(this.deck);
            player.draw(this.deck);
        }
    }

    public void playHouseTurn() {
        this.house.draw(this.deck);
        this.house.draw(this.deck);

        System.out.println(this.house);

        while (this.house.handValue() < 17) {
            Card drawnCard = this.house.draw(this.deck);
            System.out.println(this.house.getName() + " drew " + drawnCard);
            System.out.println(this.house);
        }
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public Player getHouse() {
        return this.house;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public boolean hasWon(Player player) {
        if (!player.isDead()
                && (this.house.isDead()
                || player.handValue() > this.house.handValue())) {
            return true;
        } else {
            return false;
        }
    }
}
