package main;

public class Human extends Player {

    Human(String symbol) {
        super(symbol);
        this.playerType = PlayerMode.HUMAN;
    }

    void makeMove() {
        // Do nothing.
        // It will be handled by Cell.clickHandler
    }
}
