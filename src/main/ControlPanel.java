package main;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import static main.Main.*;

public class ControlPanel extends JPanel {

    private JButton startResetBtn;
    JButton btnPlayerX;
    JButton btnPlayerO;

    ControlPanel() {
        btnPlayerX = new JButton(PlayerMode.HUMAN.displayStr);
        btnPlayerO = new JButton(PlayerMode.HUMAN.displayStr);
        startResetBtn = new JButton("Start");

        btnPlayerX.addActionListener(this::choosePlayer);
        btnPlayerO.addActionListener(this::choosePlayer);
        startResetBtn.addActionListener(this::startResetHandler);

        setLayout(new GridLayout(1, 3));
        setMaximumSize(new Dimension(400, 20));
        add(btnPlayerX);
        add(startResetBtn);
        add(btnPlayerO);
    }

    void choosePlayer(ActionEvent e) {
        var button = (JButton) e.getSource();
        var currValue = PlayerMode.parseMode(button.getText());
        button.setText(currValue.getNextMode().displayStr);
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
        playerX = instantiatePlayer(btnPlayerX.getText(), "X");
        playerO = instantiatePlayer(btnPlayerO.getText(), "O");
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

    Player instantiatePlayer(String playerType, String symbol) {
        PlayerMode mode = PlayerMode.parseMode(playerType);
        return mode.instantiate(symbol);
    }
}
