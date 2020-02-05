package blackjack.ui;

import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import blackjack.domain.Player;

public class PlayerManager {
    private Scanner reader;
    private List<Player> players;

    public PlayerManager() {
        this.reader = new Scanner(System.in);
        this.players = new ArrayList<Player>();
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public void gather() {
        System.out.println("Please enter player names, or 'c' to continue,");
        String userInput = "";

        boolean duplicate = false;
        while (!userInput.equals("c") || this.players.isEmpty() || duplicate) {
            duplicate = false;

            System.out.print("Player " + (this.players.size() + 1) + ": ");
            userInput = reader.nextLine().trim();
            Player newPlayer = new Player(userInput);

            if (this.players.contains(newPlayer)) {
                duplicate = true;
            } else if (!userInput.equals("c")) {
                this.players.add(new Player(userInput));
            }
        }
    }

    public void printHighScores() {
        List<Player> highScores = new ArrayList<Player>();
        highScores.addAll(this.players);
        Collections.sort(highScores);

        System.out.println("\n======\nCLOSING BALANCES");
        for (int i = 0; i < highScores.size(); i++) {
            Player player = highScores.get(i);
            System.out.println((i + 1) + ". " + player.getName() + " (balance: "
                + player.getBalance() + ")");
        }
    }
}
