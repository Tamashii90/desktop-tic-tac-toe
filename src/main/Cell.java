package main;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    Cell(String title) {
        super(title);
        setFont(new Font("Courier", Font.BOLD, 38));
        setName("Button" + title);
    }
}
