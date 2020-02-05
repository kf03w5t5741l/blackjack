package blackjack;

import blackjack.ui.Greeter;
import blackjack.ui.RoundManager;
import blackjack.ui.PlayerManager;

public class Main {
    public static void main(String[] args) {
        Greeter.printWelcome();

        PlayerManager pg = new PlayerManager();
        pg.gather();

        RoundManager rm = new RoundManager(pg.getPlayers());
        rm.run();

        pg.printHighScores();

        Greeter.printFarewell();
    }
}
