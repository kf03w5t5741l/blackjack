package blackjack.ui;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import blackjack.domain.Player;

public class PlayerGatherer {
    public static List<Player> gather() {
        Scanner reader = new Scanner(System.in);
        List<Player> players = new ArrayList<Player>();

        System.out.println("Please enter player names, or 'c' to continue,");
        String userInput = "";

        boolean duplicate = false;
        while (!userInput.equals("c") || players.isEmpty() || duplicate) {
            duplicate = false;

            System.out.print("Player " + (players.size() + 1) + ": ");
            userInput = reader.nextLine().trim();
            Player newPlayer = new Player(userInput);

            if (players.contains(newPlayer)) {
                duplicate = true;
            } else if (!userInput.equals("c")) {
                players.add(new Player(userInput));
            }
        }
        return players;
    }

}
