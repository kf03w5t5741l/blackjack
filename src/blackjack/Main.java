package blackjack;

import blackjack.logic.GameRound;
import blackjack.ui.Greeter;
import blackjack.ui.PlayerGatherer;
import blackjack.ui.GameUserInterface;

public class Main {
    public static void main(String[] args) {
        Greeter.printWelcome();

        PlayerGatherer pg = new PlayerGatherer();
        pg.gather();

        GameRound round = new GameRound(pg.getPlayers());
        GameUserInterface ui = new GameUserInterface(round);

        ui.run();

        Greeter.printFarewell();
    }
}
