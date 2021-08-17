package main;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import static main.Main.*;
import static main.GameState.*;

public class Cell extends JButton {
    int x;
    int y;
    String symbol = " ";

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
        setFocusPainted(false);
        setEnabled(false);
        setFont(new Font("Courier", Font.BOLD, 40));
        addActionListener(this::clickHandler);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    boolean isEmpty() {
        return this.symbol.equals(" ");
    }

    boolean isPotentialWinner(String symbol) {
        int x = this.x;
        int y = this.y;

        if (board.cells[x][(y + 1) % 3].getSymbol().equals(symbol)
                && board.cells[x][(y + 2) % 3].getSymbol().equals(symbol)) {
            return true;
        }

        if (board.cells[(x + 1) % 3][y].getSymbol().equals(symbol)
                && board.cells[(x + 2) % 3][y].getSymbol().equals(symbol)) {
            return true;
        }

        if (board.cells[(x + 1) % 3][(y + 1) % 3].getSymbol().equals(symbol)
                && board.cells[(x + 2) % 3][(y + 2) % 3].getSymbol().equals(symbol)) {
            return true;
        }

        return board.cells[(x + 1) % 3][(y + 2) % 3].getSymbol().equals(symbol)
                && board.cells[(x + 2) % 3][(y + 1) % 3].getSymbol().equals(symbol);
    }

    public void clickHandler(ActionEvent e) {
        var clickedBtn = (JButton) e.getSource();

        if (gameState.getGameState() != IN_PROGRESS || clickedBtn != this || !this.isEmpty()) {
            return;
        }
        this.setSymbol(currPlayer.symbol);
        this.setText(currPlayer.symbol);
        gameState.processTurn(currPlayer.symbol);

        if (gameState == IN_PROGRESS) {
            currPlayer = currPlayer == playerX ? playerO : playerX;
            statusPanel.setStatusText(gameState.toString());
            currPlayer.makeMove();
        }
    }
}
