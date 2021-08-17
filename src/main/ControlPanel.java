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
    JButton btnPlayerX;
    JButton btnPlayerO;

    ControlPanel() {
        btnPlayerX = new JButton("Human");
        btnPlayerO = new JButton("Human");
        startResetBtn = new JButton("Start");

        btnPlayerX.setName("ButtonPlayer1");
        btnPlayerO.setName("ButtonPlayer2");
        startResetBtn.setName("ButtonStartReset");

        btnPlayerX.addActionListener(this::choosePlayerHandler);
        btnPlayerO.addActionListener(this::choosePlayerHandler);
        startResetBtn.addActionListener(this::startResetHandler);

        setLayout(new GridLayout(1, 3));
        setMaximumSize(new Dimension(400, 20));
        add(btnPlayerX);
        add(startResetBtn);
        add(btnPlayerO);
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
        playerX = btnPlayerX.getText().equals("Human") ? new Human("X") : new MediumBot("X");
        playerO = btnPlayerO.getText().equals("Human") ? new Human("O") : new MediumBot("O");
        currPlayer = playerX;

        gameState.setGameState(GameState.IN_PROGRESS);
        statusPanel.setStatusText(gameState.toString());
        startResetBtn.setText("Reset");
        btnPlayerX.setEnabled(false);
        btnPlayerO.setEnabled(false);
        board.enableCells();
        // Initiate the game (in case playerX is AI)
        playerX.makeMove();
    }

    void resetGame() {
        gameState.setGameState(GameState.NOT_STARTED);
        statusPanel.setStatusText(gameState.toString());
        startResetBtn.setText("Start");
        btnPlayerX.setEnabled(true);
        btnPlayerO.setEnabled(true);
        board.resetArrangement();
    }
}
