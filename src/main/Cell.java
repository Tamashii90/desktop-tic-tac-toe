package main;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;

import static main.Main.*;
import static main.GameState.*;

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

    public boolean equals(Object obj) {
        return this.getText().equals(obj);
    }

    boolean isEmpty() {
        return this.getText().equals(" ");
    }

    public void clickHandler(ActionEvent e) {
        var clickedBtn = (JButton) e.getSource();

        if (gameState.getGameState() != IN_PROGRESS || clickedBtn != this || !this.isEmpty()) {
            return;
        }
        board.enterSymbolAt(this.x, this.y);
        gameState.handleGameState(currPlayer.symbol);

        if (gameState == IN_PROGRESS) {
            currPlayer = currPlayer == playerX ? playerO : playerX;
            statusPanel.setStatusText(gameState.toString());
            currPlayer.makeMove();
        }
    }
}
