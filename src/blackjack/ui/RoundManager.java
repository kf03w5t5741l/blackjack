package blackjack.ui;

import java.util.Scanner;
import java.util.List;

import blackjack.domain.Player;
import blackjack.logic.GameRound;

public class RoundManager {
    private Scanner reader;
    private List<Player> players;

    public RoundManager(List<Player> players) {
        this.reader = new Scanner(System.in);
        this.players = players;
    }

    public void run() {
        while (true) {
            this.startRound();

            if (!this.asktoKeepPlaying()) {
                break;
            }
        }
    }

    private void startRound() {
        GameRound round = new GameRound(this.players);
        RoundUserInterface ui = new RoundUserInterface(round);

        ui.run();
    }

    private boolean asktoKeepPlaying() {
        String keepPlaying = "";
        while (!keepPlaying.equals("y") && !keepPlaying.equals("n")) {
            System.out.print("Play another round (y/n)? ");
            keepPlaying = reader.nextLine().trim();
        }

        if (keepPlaying.equals("y")) {
            return true;
        } else {
            return false;
        }
    }
}
