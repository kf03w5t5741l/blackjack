package blackjack.ui;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import blackjack.domain.Deck;
import blackjack.domain.Card;

public class TextUserInterface {
    private Scanner reader;
    private Deck deck;

    public TextUserInterface(Deck deck) {
        this.reader = new Scanner(System.in);
        this.deck = deck;
    }

    public void run() {
        this.printWelcome();

        String userAction = "";
        while (!this.parseCommand(userAction)) {
            userAction = this.getUserAction();
        }

        this.printFarewell();
    }

    private String getUserAction() {
       System.out.print("Action: ");
       String userInput = this.reader.next().trim();
       return userInput;
    }

    private boolean parseCommand(String userAction) {
        switch (userAction) {
            case "q":
                System.exit(0);
            case "c":
                System.out.println(deck.draw());
                return true;
            default:
                break;
        }
        return false;
    }

    private void printWelcome() {
        System.out.println("Welcome to Blackjack9000_improved_moneymaker.net");
        System.out.println("(We are totally legit, pinky promise...)");
    }

    private void printFarewell() {
        System.out.println("Thanks for playing!");
    }
}
