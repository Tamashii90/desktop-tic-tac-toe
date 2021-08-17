package main;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static main.Main.*;

public class EasyBot extends AIPlayer {

    EasyBot(String symbol) {
        super(symbol);
    }

    public void actualMakeMove() {
        int x,y;
        Cell chosenCell;
        do {
            x = new Random().nextInt(3);
            y = new Random().nextInt(3);
            chosenCell = board.cells[x][y];
        } while (!chosenCell.isEmpty());
        chosenCell.doClick();
    }
}
