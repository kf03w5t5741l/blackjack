package blackjack.domain;

public class Player extends Participant implements Comparable<Player> {
    private static final int defaultStartingBalance = 1000;

    private int balance;

    public Player(String name, int balance) {
        super(name);
        this.balance = balance;
    }

    public Player(String name) {
        this(name, Player.defaultStartingBalance);
    }

    public int getBalance() {
        return this.balance;
    }

    public boolean bet(int amount) {
        if (amount < 0) {
            return false;
        }

        if (amount <= this.balance) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void addToBalance(int amount) {
        this.balance += amount;
    }

    @Override
    public int compareTo(Player otherPlayer) {
        if (this.balance > otherPlayer.getBalance()) {
            return -1;
        } else if (this.balance < otherPlayer.getBalance()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return this.getName() + " (balance: " + this.balance + "): "
                + this.getHand() + " (value: " + this.handValue() + ")";
    }
}
