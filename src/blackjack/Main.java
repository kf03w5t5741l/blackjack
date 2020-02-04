package blackjack;

import java.util.List;

import blackjack.domain.Player;
import blackjack.logic.GameRound;
import blackjack.ui.Greeter;
import blackjack.ui.PlayerGatherer;
import blackjack.ui.GameUserInterface;

public class Main {
    public static void main(String[] args) {
        Greeter.printWelcome();

        List<Player> players = PlayerGatherer.gather();
        GameRound round = new GameRound(players);
        GameUserInterface ui = new GameUserInterface(round);

        ui.run();

        Greeter.printFarewell();
    }
}
