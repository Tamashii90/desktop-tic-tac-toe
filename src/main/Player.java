package main;

abstract class Player {
    PlayerMode playerType;
    String symbol;

    Player(String symbol) {
        this.symbol = symbol;
    }

    abstract void makeMove();
}
