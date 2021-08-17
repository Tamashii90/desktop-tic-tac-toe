package main;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.Arrays;

public class Board extends JPanel {
    final Cell[][] cells = new Cell[3][3];

    Board() {
        super();
        setLayout(new GridLayout(3, 3));
        char[] arr = new char[]{'A', 'B', 'C'};
        for (int i = 3; i >= 1; i--) {
            for (int j = 0; j <= 2; j++) {
                var cell = new Cell(i - 1, j);
                cell.setName("Button" + arr[j] + i);
                cell.setText(" ");
                cells[i - 1][j] = cell;
                this.add(cell);
            }
        }
    }

    void enterSymbolAt(int r, int c) {
        var foundCell = cells[r][c];
        String symbol = String.valueOf(Main.currPlayer.symbol);
        foundCell.setText(symbol);
    }

    long getCountOf(String symbol) {
        return Arrays.stream(this.cells)
                .flatMap(Arrays::stream)
                .filter(el -> el.equals(symbol))
                .count();
    }

    void resetArrangement() {
        Arrays.stream(this.cells)
                .flatMap(Arrays::stream)
                .forEach(btn -> {
                    btn.setEnabled(false);
                    btn.setText(" ");
                });
    }

    void disableCells() {
        Arrays.stream(this.cells)
                .flatMap(Arrays::stream)
                .forEach(btn -> btn.setEnabled(false));
    }

    void enableCells() {
        Arrays.stream(this.cells)
                .flatMap(Arrays::stream)
                .forEach(btn -> btn.setEnabled(true));
    }
}
