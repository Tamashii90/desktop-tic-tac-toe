package main;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;

import static main.Main.*;

public class Cell extends JButton {
    int x;
    int y;

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
        setFocusPainted(false);
        setEnabled(false);
        setFont(new Font("Courier", Font.BOLD, 40));
        addActionListener(this::clickHandler);
    }

    boolean isEmpty() {
        return this.getText().equals(" ");
    }

    public void clickHandler(ActionEvent e) {
        if (gameState.getGameState() != GameState.IN_PROGRESS) {
            return;
        }

        var clickedBtn = (JButton) e.getSource();
        String symbol = currPlayer.symbol;
        if (clickedBtn == this && this.isEmpty()) {
            board.enterSymbolAt(this.x, this.y);
            gameState.handleGameState(symbol);
        }

        if (gameState == GameState.IN_PROGRESS) {
            currPlayer = currPlayer == playerX ? playerO : playerX;
            currPlayer.makeMove();
        }
    }
}
