package blackjack;

import blackjack.ui.Greeter;
import blackjack.ui.RoundManager;
import blackjack.ui.PlayerManager;

public class Main {
    public static void main(String[] args) {
        Greeter.printWelcome();

        PlayerManager pm = new PlayerManager();
        pm.gather();

        RoundManager rm = new RoundManager(pm.getPlayers());
        rm.run();

        pm.printHighScores();

        Greeter.printFarewell();
    }
}
