package blackjack;

import java.util.List;

import blackjack.domain.Player;
import blackjack.logic.GameRound;
import blackjack.ui.PlayerGatherer;
import blackjack.ui.TextUserInterface;

public class Main {
    public static void main(String[] args) {
        TextUserInterface.printWelcome();

        List<Player> players = PlayerGatherer.gather();

        GameRound round = new GameRound(players);
        TextUserInterface ui = new TextUserInterface(round);

        ui.run();

        TextUserInterface.printFarewell();
    }
}
