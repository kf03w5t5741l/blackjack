package blackjack.logic;

import java.util.List;
import java.util.ArrayList;

import blackjack.domain.Deck;
import blackjack.domain.Player;

public class GameRound {
    private Deck deck;
    private List<Player> players;

    public GameRound(List<Player> players) {
        this.deck = new Deck();
        this.deck.shuffle();
        this.players = players;

        for (Player player : this.players) {
            player.draw(this.deck);
            player.draw(this.deck);
        }
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public Deck getDeck() {
        return this.deck;
    }
}
