package blackjack;

import java.util.List;
import java.util.ArrayList;

import blackjack.domain.Player;
import blackjack.logic.GameRound;
import blackjack.ui.TextUserInterface;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("kf03w5t5741l"));

        GameRound round = new GameRound(players);
        TextUserInterface ui = new TextUserInterface(round);

        ui.run();
    }
}
