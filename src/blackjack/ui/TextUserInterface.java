package blackjack.ui;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import blackjack.domain.Deck;
import blackjack.domain.Card;
import blackjack.domain.Player;

public class TextUserInterface {
    private Scanner reader;
    private Deck deck;
    private List<Player> players;
    private List<Player> retiredPlayers;
    private List<Player> deadPlayers;

    public TextUserInterface(Deck deck) {
        this.reader = new Scanner(System.in);
        this.deck = deck;
        this.players = new ArrayList<Player>();
        this.retiredPlayers = new ArrayList<Player>();
        this.deadPlayers = new ArrayList<Player>();
    }

    public void run() {
        this.printWelcome();
        this.addPlayers();
        this.dealFirstCards();

        for (Player activePlayer : players) {
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
                    this.deadPlayers.add(activePlayer);
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
                System.out.println(activePlayer.getName() + " stands. "
                        + "(Hand value: " + activePlayer.getHandValue() + ")");
                activePlayer.setPlaying(false);
                return true;
            case "h":
                Card drawnCard = activePlayer.draw(this.deck);
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

    private void addPlayers() {
        this.players.add(new Player("kf03w5t5741l"));
    }

    private void dealFirstCards() {
        for (Player player : this.players) {
            player.draw(this.deck);
            player.draw(this.deck);
        }
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
