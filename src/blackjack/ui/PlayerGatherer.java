package blackjack.ui;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import blackjack.domain.Player;

public class PlayerGatherer {
    private Scanner reader;
    private List<Player> players;

    public PlayerGatherer() {
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

    public void clear() {
        this.players.clear();
    }

}
