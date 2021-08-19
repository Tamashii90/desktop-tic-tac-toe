package main;

import java.util.*;

public class HardBot extends AIPlayer {
    HardBot(String symbol) {
        super(symbol);
        this.playerType = PlayerMode.HARD;
    }

    void actualMakeMove() {
        var chosenMove = minimax(this.symbol);
        var chosenCell = (Cell) chosenMove.get("cell");
        chosenCell.doClick();
    }

    HashMap<String, Object> minimax(String currSymbol) {
        var entry = new HashMap<String, Object>();
        int score;

        if (Main.isWinner("X", true) || Main.isWinner("O", true)) {
            // NOT sign because it's checking whether the symbol from
            // PREVIOUS iteration is a winner
            score = !this.symbol.equals(currSymbol) ? 10 : -10;
            entry.put("score", score);
            return entry;
        }
        if (Main.board.getCountOf(" ") == 0) {
            score = 0;
            entry.put("score", score);
            return entry;
        }

        var emptyCells = Main.board.getEmptyCells();
        var listOfMoves = new ArrayList<HashMap<String, Object>>();
        for (Cell cell : emptyCells) {
            cell.setSymbol(currSymbol);
            String newSymbol = currSymbol.equals("X") ? "O" : "X";
            var move = minimax(newSymbol);
            move.put("cell", cell);
            listOfMoves.add(move);
            cell.setSymbol(" ");
        }
        return calcEntry(listOfMoves, currSymbol);
    }
    HashMap<String, Object> calcEntry(List<HashMap<String, Object>> entries, String currPlayer) {
        if (this.symbol.equals(currPlayer)) {
            return entries.stream()
                    .max(Comparator.comparing(map -> (int) map.get("score")))
                    .get();
        }
        return entries.stream()
                .min(Comparator.comparing(map -> (int) map.get("score")))
                .get();
    }
}
