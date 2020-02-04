package blackjack;

import java.util.List;
import java.util.ArrayList;

import blackjack.domain.Player;
import blackjack.logic.GameRound;
import blackjack.ui.PlayerGatherer;
import blackjack.ui.TextUserInterface;

public class Main {
    public static void main(String[] args) {
        TextUserInterface.printWelcome();

        PlayerGatherer pg = new PlayerGatherer();
        List<Player> players = pg.gather();

        GameRound round = new GameRound(players);
        TextUserInterface ui = new TextUserInterface(round);

        ui.run();

        TextUserInterface.printFarewell();
    }
}
