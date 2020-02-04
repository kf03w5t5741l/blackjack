package blackjack;

import blackjack.domain.*;

public class Main {
    public static void main(String[] args) {
        Deck myDeck = new Deck();
        myDeck.shuffle();

        System.out.println(myDeck);
        System.out.println(myDeck.getSize());
    }
}
