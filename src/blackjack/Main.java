package blackjack;

import blackjack.domain.Deck;
import blackjack.ui.TextUserInterface;

public class Main {
    public static void main(String[] args) {
        Deck myDeck = new Deck();
        TextUserInterface ui = new TextUserInterface(myDeck);

        myDeck.shuffle();

        System.out.println(myDeck);
        System.out.println(myDeck.getSize());

        ui.run();
    }
}
