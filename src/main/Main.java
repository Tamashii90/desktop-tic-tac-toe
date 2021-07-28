package main;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Main extends JFrame {

    static final char[][] ARRANGEMENT = new char[][]{
            {' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}
    };
    static final JButton[][] BUTTONS = new JButton[3][3];
    static StatusPanel.State state = StatusPanel.State.NOT_STARTED;

    Main() {
        super("Tic Tac Toe");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        initComponents();

        setVisible(true);
    }

    static void resetArrangement() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                ARRANGEMENT[i][j] = ' ';
                BUTTONS[i][j].setText(" ");
            }
        }
    }

    static char makeMove(int r, int c) {
        int xCount = 0;
        int oCount = 0;

        for (char[] row : ARRANGEMENT) {
           for (char symbol : row) {
               if (symbol == 'X') {
                   xCount++;
               } else if (symbol == 'O') {
                   oCount++;
               }
           }
        }
        ARRANGEMENT[r][c] = oCount < xCount ? 'O' : 'X';
        return ARRANGEMENT[r][c];
    }

    static boolean isWinner(char symbol) {
        return (ARRANGEMENT[0][0] == symbol && ARRANGEMENT[0][1] == symbol && ARRANGEMENT[0][2] == symbol ||
                ARRANGEMENT[1][0] == symbol && ARRANGEMENT[1][1] == symbol && ARRANGEMENT[1][2] == symbol ||
                ARRANGEMENT[2][0] == symbol && ARRANGEMENT[2][1] == symbol && ARRANGEMENT[2][2] == symbol ||
                ARRANGEMENT[0][0] == symbol && ARRANGEMENT[1][0] == symbol && ARRANGEMENT[2][0] == symbol ||
                ARRANGEMENT[0][1] == symbol && ARRANGEMENT[1][1] == symbol && ARRANGEMENT[2][1] == symbol ||
                ARRANGEMENT[0][2] == symbol && ARRANGEMENT[1][2] == symbol && ARRANGEMENT[2][2] == symbol ||
                ARRANGEMENT[0][0] == symbol && ARRANGEMENT[1][1] == symbol && ARRANGEMENT[2][2] == symbol ||
                ARRANGEMENT[2][0] == symbol && ARRANGEMENT[1][1] == symbol && ARRANGEMENT[0][2] == symbol);
    }

    static int getCountOf(char symbol) {
        int count = 0;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (ARRANGEMENT[i][j] == symbol) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new Main();
    }

    void initComponents() {
        char[] arr = new char[]{'A', 'B', 'C'};
        var board = new Board();
        var statusPanel = new StatusPanel();
        for (int i = 3; i >= 1; i--) {
            for (int j = 0; j <= 2; j++) {
                var cell = new Cell(" ", "" + arr[j] + i);
                BUTTONS[i - 1][j] = cell;
                board.add(cell);
            }
        }
        add(board);
        add(statusPanel);
    }
}
