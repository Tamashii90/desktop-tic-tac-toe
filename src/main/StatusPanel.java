package main;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class StatusPanel extends JPanel {
    JLabel statusLabel;

    StatusPanel() {
        super();
        setMaximumSize(new Dimension(400, 20));
        setBorder(new EmptyBorder(8, 8, 8, 8));
        setLayout(new BorderLayout());
        statusLabel = new JLabel(Main.gameState.stateStr);
        statusLabel.setName("LabelStatus");

        add(statusLabel, BorderLayout.WEST);
    }
}
