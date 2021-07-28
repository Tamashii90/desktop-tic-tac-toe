package main;

import javax.swing.JPanel;
import java.awt.GridLayout;

public class Board extends JPanel {
    Board() {
        super();
        setLayout(new GridLayout(3, 3));
    }
}
