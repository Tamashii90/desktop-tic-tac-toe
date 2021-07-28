package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Cell extends JButton {
    Cell(String title, String name) {
        super(title);
        setFocusPainted(false);
        setFont(new Font("Courier", Font.BOLD, 40));
        setName("Button" + name);
        addActionListener(this::clickHandler);
    }

    public void clickHandler(ActionEvent e) {
        if (StatusPanel.getState() != StatusPanel.State.IN_PROGRESS &&
                StatusPanel.getState() != StatusPanel.State.NOT_STARTED) {
            return;
        }
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (Main.BUTTONS[i][j] == this) {
                    if (Main.ARRANGEMENT[i][j] == ' ') {
                        char symbol = Main.makeMove(i, j);
                        setText("" + symbol);
                        StatusPanel.handleState(symbol);
                    }
                    break;
                }
            }
        }
    }
}
