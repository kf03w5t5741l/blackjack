package blackjack.ui;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import blackjack.logic.GameRound;
import blackjack.domain.Card;
import blackjack.domain.Player;

public class TextUserInterface {
    private Scanner reader;
    private GameRound round;

    public TextUserInterface(GameRound round) {
        this.reader = new Scanner(System.in);
        this.round = round;
    }

    public void run() {
        this.printWelcome();

        for (Player activePlayer : this.round.getPlayers()) {
            while (activePlayer.isPlaying()) {
                activePlayer.incrementTurns();
                System.out.println("\n======");
                System.out.println(activePlayer.getName() + " - turn " +
                        activePlayer.getTurns());
                System.out.println("Hand: " + activePlayer.getHand());
                System.out.println("Value: " + activePlayer.getHandValue());

                String userCommand = "";
                while (!this.parseCommand(userCommand, activePlayer)) {
                    userCommand = this.getUserCommand();
                }

                if (activePlayer.isDead()) {
                    System.out.println(activePlayer.getName() + " has lost."
                            + " (Hand value: " + activePlayer.getHandValue()
                            + " > 21)");
                    activePlayer.setPlaying(false);
                }
            }
        }

        this.printFarewell();
    }

    private String getUserCommand() {
       System.out.print("Action: ");
       String userInput = this.reader.next().trim();
       return userInput;
    }

    private boolean parseCommand(String userAction, Player activePlayer) {
        switch (userAction) {
            case "q":
                System.exit(0);
            case "s":
                System.out.println(activePlayer.getName() + " stands. Hand: "
                        + activePlayer.getHand() + " (value: "
                        + activePlayer.getHandValue() + ")");
                activePlayer.setPlaying(false);
                return true;
            case "h":
                Card drawnCard = activePlayer.draw(this.round.getDeck());
                System.out.println(activePlayer.getName() + " drew "
                        + drawnCard);
                System.out.println("New hand: " + activePlayer.getHand()
                        + " (value: " + activePlayer.getHandValue() + ")");
                return true;
            default:
                break;
        }
        return false;
    }

    private void printWelcome() {
        System.out.println("Welcome to blackjack9000_improved_moneymaker.net");
        System.out.println("(We are totally legit, pinky promise...)");
        System.out.println("");
        System.out.println("Instructions: 'h' to hit (new card), 's' to stand,"
                + " 'q' to quit.");
    }

    private void printFarewell() {
        System.out.println("Thanks for playing!");
    }
}
