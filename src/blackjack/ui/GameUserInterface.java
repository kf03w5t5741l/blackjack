package blackjack.ui;

import java.util.Scanner;

import blackjack.logic.GameRound;
import blackjack.domain.Card;
import blackjack.domain.Player;

public class GameUserInterface {
    private Scanner reader;
    private GameRound round;

    public GameUserInterface(GameRound round) {
        this.reader = new Scanner(System.in);
        this.round = round;
    }

    public void run() {
        System.out.println("\n======\nLET'S PLAY");
        System.out.println("Instructions: 'h' to hit (new card), 's' to stand,"
                + " 'q' to quit.");

        for (Player player : this.round.getPlayers()) {
            while (player.isPlaying()) {
                player.incrementTurns();
                System.out.println("\n======");
                System.out.println(player.getName() + " - turn " +
                        player.getTurns());
                System.out.println("Hand: " + player.getHand());
                System.out.println("Value: " + player.getHandValue());

                String userCommand = "";
                while (!this.parseCommand(userCommand, player)) {
                    userCommand = this.getUserCommand();
                }

                if (player.isDead()) {
                    System.out.println(player.getName() + " has lost."
                            + " (Hand value: " + player.getHandValue()
                            + " > 21)");
                    player.setPlaying(false);
                }
            }
        }
    }

    private String getUserCommand() {
       System.out.print("Action: ");
       String userInput = this.reader.next().trim();
       return userInput;
    }

    private boolean parseCommand(String userCommand, Player player) {
        switch (userCommand) {
            case "q":
                System.exit(0);
            case "s":
                System.out.println(player.getName() + " stands. Hand: "
                        + player.getHand() + " (value: "
                        + player.getHandValue() + ")");
                player.setPlaying(false);
                return true;
            case "h":
                Card drawnCard = player.draw(this.round.getDeck());
                System.out.println(player.getName() + " drew "
                        + drawnCard);
                System.out.println("New hand: " + player.getHand()
                        + " (value: " + player.getHandValue() + ")");
                return true;
            default:
                break;
        }
        return false;
    }


}