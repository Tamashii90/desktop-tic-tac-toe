package main;

abstract class Player {
    boolean isHuman;
    String symbol;

    Player(String symbol) {
        this.symbol = symbol;
    }

    abstract void makeMove();
}
