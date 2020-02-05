package blackjack.logic;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import blackjack.domain.Deck;
import blackjack.domain.Participant;
import blackjack.domain.Player;

public class GameRound {
    private Deck deck;
    private List<Player> players;
    private Participant house;
    private Map<Player, Integer> bets;

    public GameRound(List<Player> players) {
        this.deck = new Deck();
        this.deck.shuffle();
        this.players = players;
        this.house = new Participant("The House");

        for (Player player : this.players) {
            player.prepareForNewRound();
            player.draw(this.deck, 2);
        }

        this.house.prepareForNewRound();
        this.house.draw(this.deck, 2);

        this.bets = new HashMap<Player, Integer>();
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public Participant getHouse() {
        return this.house;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public int getBet(Player player) {
        if (this.bets.containsKey(player) && this.bets.get(player) != null) {
            return this.bets.get(player);
        } else {
            return 0;
        }
    }

    public boolean addBet(Player player, int amount) {
        if (player.bet(amount)) {
            this.bets.put(player, amount);
            return true;
        } else {
            return false;
        }
    }

    public void processBetResults() {
        for (Player player : this.players) {
            if (this.hasWon(player)) {
                int winnings = this.getBet(player) * 2;
                player.addToBalance(winnings);
            }
        }
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
