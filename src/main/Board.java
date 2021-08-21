package main;

import javax.swing.JPanel;
import java.awt.*;
import java.util.Arrays;

public class Board extends JPanel {
    final Cell[][] cells = new Cell[3][3];

    Board() {
        super();
        setLayout(new GridLayout(3, 3));
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                var cell = new Cell(i, j);
                cell.setText(" ");
                cells[i][j] = cell;
                this.add(cell);
            }
        }
    }

    Cell[] getEmptyCells() {
        return Arrays.stream(cells)
                .flatMap(Arrays::stream)
                .filter(Cell::isEmpty)
                .toArray(Cell[]::new);
    }

    long getCountOf(String symbol) {
        return Arrays.stream(this.cells)
                .flatMap(Arrays::stream)
                .filter(el -> el.getSymbol().equals(symbol))
                .count();
    }

    void resetArrangement() {
        Arrays.stream(this.cells)
                .flatMap(Arrays::stream)
                .forEach(btn -> {
                    btn.setEnabled(false);
                    btn.setText(" ");
                    btn.setSymbol(" ");
                    btn.setBackground(null);
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
                .forEach(btn -> {
                    btn.setBackground(Color.WHITE);
                    btn.setEnabled(true);
                });
    }
}
