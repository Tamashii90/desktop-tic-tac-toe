package main;

import java.util.Timer;
import java.util.TimerTask;

abstract class AIPlayer extends Player {

    AIPlayer(String symbol) {
        super(symbol);
    }

    @Override
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

    abstract void actualMakeMove();
}
