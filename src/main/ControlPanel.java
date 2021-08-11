package main;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.List;

import static main.Main.*;

public class ControlPanel extends JPanel {

    private JButton startResetBtn;
    private JButton btnPlayer1;
    private JButton btnPlayer2;

    ControlPanel() {
        btnPlayer1 = new JButton("Human");
        btnPlayer2 = new JButton("Human");
        startResetBtn = new JButton("Start");

        btnPlayer1.setName("ButtonPlayer1");
        btnPlayer2.setName("ButtonPlayer2");
        startResetBtn.setName("ButtonStartReset");

        btnPlayer1.addActionListener(this::choosePlayerHandler);
        btnPlayer2.addActionListener(this::choosePlayerHandler);
        startResetBtn.addActionListener(this::startResetHandler);

        setLayout(new GridLayout(1, 3));
        setMaximumSize(new Dimension(400, 20));
        add(btnPlayer1);
        add(startResetBtn);
        add(btnPlayer2);
    }

    void choosePlayerHandler(ActionEvent e) {
        var possibleChoices = List.of("Human", "Robot");
        var button = ((JButton) e.getSource());
        var currValue = button.getText();
        var newIdx = (possibleChoices.indexOf(currValue) + 1) % possibleChoices.size();
        button.setText(possibleChoices.get(newIdx));
    }

    void startResetHandler(ActionEvent e) {
        var state = gameState.getGameState();
        if (state != GameState.NOT_STARTED){
            resetGame();
        } else {
            startGame();
        }
    }

    void startGame() {
        gameState.setGameState(GameState.IN_PROGRESS);
        playerX = btnPlayer1.getText().equals("Human") ? new Human("X") : new EasyBot("X");
        playerO = btnPlayer2.getText().equals("Human") ? new Human("O") : new EasyBot("O");
        currPlayer = playerX;
        startResetBtn.setText("Reset");
        btnPlayer1.setEnabled(false);
        btnPlayer2.setEnabled(false);
        board.enableCells();
        // Initiate the game (in case playerX is AI)
        playerX.makeMove();
    }

    void resetGame() {
        gameState.setGameState(GameState.NOT_STARTED);
        startResetBtn.setText("Start");
        btnPlayer1.setEnabled(true);
        btnPlayer2.setEnabled(true);
        board.resetArrangement();
    }
}
