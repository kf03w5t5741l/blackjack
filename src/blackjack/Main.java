package blackjack;

import blackjack.ui.Greeter;
import blackjack.ui.RoundManager;
import blackjack.ui.PlayerGatherer;

public class Main {
    public static void main(String[] args) {
        Greeter.printWelcome();

        PlayerGatherer pg = new PlayerGatherer();
        pg.gather();

        RoundManager rm = new RoundManager(pg.getPlayers());
        rm.run();

        Greeter.printFarewell();
    }
}
