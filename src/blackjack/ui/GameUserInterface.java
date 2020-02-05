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
        this.printInstructions();

        for (Player player : this.round.getPlayers()) {
            this.playTurn(player);
        }

        this.playHouseTurn();
        this.printWinners();
    }

    private void playTurn(Player player) {
        System.out.println("\n======");
        while (player.isPlaying()) {
            player.incrementTurns();
            System.out.println("Turn " + player.getTurns() + " - " + player);

            String userCommand = "";
            while (!this.parseCommand(userCommand, player)) {
                userCommand = this.getUserCommand();
            }

            this.checkDead(player);
        }
    }

    private void playHouseTurn() {
        Player house = this.round.getHouse();

        System.out.println("\n======\nHOUSE TURN");
        System.out.println(house);

        while (house.handValue() < 17) {
            Card drawnCard = house.draw(this.round.getDeck());
            System.out.println(house.getName() + " drew " + drawnCard);
            System.out.println(house);
        }

        this.checkDead(house);
    }

    private void checkDead(Player player) {
        if (player.isDead()) {
            System.out.println(player.getName() + " is bust."
                    + " (Hand value: " + player.handValue()
                    + " > 21)");
            player.setPlaying(false);
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
                        + player.handValue() + ")");
                player.setPlaying(false);
                return true;
            case "h":
                Card drawnCard = player.draw(this.round.getDeck());
                System.out.println(player.getName() + " drew "
                        + drawnCard);
                System.out.println("New hand: " + player.getHand()
                        + " (value: " + player.handValue() + ")");
                return true;
            default:
                break;
        }
        return false;
    }

    private void printWinners() {
        System.out.println("\n======\nWINNERS");

        for (Player player : this.round.getPlayers()) {
            Player house = this.round.getHouse();
            Player winner = (this.round.hasWon(player)) ? player : house;

            System.out.println(house.getName() + " v. " + player.getName()
                    + ": "+ winner.getName() + " wins.");
        }
    }

    private void printInstructions() {
        System.out.println("\n======\nLET'S PLAY");
        System.out.println("Instructions: 'h' to hit (new card), 's' to stand,"
                + " 'q' to quit.");
    }
}
