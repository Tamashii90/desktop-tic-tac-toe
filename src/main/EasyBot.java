package main;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static main.Main.*;

public class EasyBot extends Player {

    EasyBot(String symbol) {
        super(symbol);
        this.isHuman = false;
    }

    public void makeMove() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
           @Override
           public void run() {
               actualMakeMove();
           }
       };
        timer.schedule(timerTask, 300);
    }

    public void actualMakeMove() {
        int x = new Random().nextInt(3);
        int y = new Random().nextInt(3);

        var chosenCell = board.cells[x][y];

        if (chosenCell.isEmpty()) {
            chosenCell.doClick();
        } else {
            // Try again for new random values
            actualMakeMove();
        }
    }
}
