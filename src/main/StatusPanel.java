package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StatusPanel extends JPanel {
    private static JLabel statusLabel;

    StatusPanel() {
        super();
        setMaximumSize(new Dimension(400, 20));
        setBorder(new EmptyBorder(8, 8, 8, 8));
        setLayout(new BorderLayout());
        statusLabel = new JLabel(Main.state.stateStr);
        statusLabel.setName("LabelStatus");
        var resetBtn = new JButton("Reset");
        resetBtn.setName("ButtonReset");
        resetBtn.addActionListener(this::resetHandler);

        add(statusLabel, BorderLayout.WEST);
        add(resetBtn, BorderLayout.EAST);
    }

    static void setState(State state) {
        Main.state = state;
        statusLabel.setText(state.stateStr);
    }

    static State getState() {
        return Main.state;
    }

    static void handleState(char symbol) {
        State newState = State.IN_PROGRESS;
        if (Main.isWinner(symbol)) {
            newState = State.valueOf(symbol + "_WINS");
        } else if (Main.getCountOf(' ') == 0) {
            newState = State.Draw;
        }
        setState(newState);
    }

    void resetHandler(ActionEvent e) {
        Main.resetArrangement();
        setState(State.NOT_STARTED);
    }

    enum State {

        NOT_STARTED("Game is not started"),
        IN_PROGRESS("Game in progress"),
        X_WINS("X wins"),
        O_WINS("O wins"),
        Draw("Draw");

        String stateStr;

        State(String stateStr) {
            this.stateStr = stateStr;
        }
    }
}
