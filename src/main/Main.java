package main;

import javax.swing.*;

public class Main extends JFrame {

    Main() {
        super("Tic Tac Toe");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        initComponents();

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    void initComponents() {
        var board = new Board();
        char[] arr = new char[]{'A', 'B', 'C'};
        for (int i = 3; i >= 1; i--) {
            for (char c : arr) {
                var cell = new Cell(c + "" + i);
                board.add(cell);
            }
        }
        add(board);
    }
}
