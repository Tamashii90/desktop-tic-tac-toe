package main;

import java.util.Arrays;
import java.util.Random;

import static main.Main.*;

public class MediumBot extends AIPlayer {

    MediumBot(String symbol) {
        super(symbol);
        this.playerType = PlayerMode.MEDIUM;
    }

    public void actualMakeMove() {
        int x;
        int y;
        Cell chosenCell = trySmartMove();
        if (chosenCell != null) {
            System.out.println("smart move!");
        }
        if (chosenCell == null) {
            do {
                x = new Random().nextInt(3);
                y = new Random().nextInt(3);
            } while (!Main.board.cells[x][y].isEmpty());
            chosenCell = Main.board.cells[x][y];
        }
        chosenCell.doClick();
    }

    Cell trySmartMove() {
        Cell p = tryWinMove();
        return p != null ? p : tryBlockWinMove();
    }

    Cell tryWinMove() {
        Cell p;
        if (currPlayer.symbol.equals("X")) {
            p = smartMove("X");
        } else {
            p = smartMove("O");
        }
        return p;
    }

    Cell tryBlockWinMove() {
        Cell p;
        if (currPlayer.symbol.equals("X")) {
            p = smartMove("O");
        } else {
            p = smartMove("X");
        }
        return p;
    }

    Cell smartMove(String symbol) {
        Cell[] emptyCells;
        if (board.getCountOf(symbol) < 2) {
            return null;
        }

        emptyCells = board.getEmptyCells();
        return Arrays.stream(emptyCells)
                .filter(cell -> cell.isPotentialWinner(symbol))
                .findFirst()
                .orElse(null);
    }
}
