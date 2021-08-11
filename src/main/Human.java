package main;

public class Human extends Player {

    Human(String symbol) {
        super(symbol);
        this.isHuman = true;
    }

    void makeMove() {
        // Do nothing.
        // It will be handled by Cell.clickHandler
    }
}
