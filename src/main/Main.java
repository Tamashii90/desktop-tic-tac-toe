package main;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main extends JFrame {

    static GameState gameState = GameState.NOT_STARTED;
    static Player playerX;
    static Player playerO;
    static Player currPlayer;

    static Board board = new Board();
    static StatusPanel statusPanel = new StatusPanel();
    static ControlPanel controlPanel = new ControlPanel();
    static MenuGame menuGame = new MenuGame("Game");


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



    static boolean isWinner(String symbol) {
        if (board.getCountOf(symbol) < 3) {
            return false;
        }

        if (board.cells[0][0].equals(symbol)
                && board.cells[1][1].equals(symbol)
                && board.cells[2][2].equals(symbol)) {
            return true;
        }
        if (board.cells[0][2].equals(symbol)
                && board.cells[1][1].equals(symbol)
                && board.cells[2][0].equals(symbol)) {
            return true;
        }

        for (int i = 0, j = 0; i < 3; i++, j++) {
            if (board.cells[i][j].equals(symbol)
                    && board.cells[i][(j + 1) % 3].equals(symbol)
                    && board.cells[i][(j + 2) % 3].equals(symbol)) {
                return true;
            }
            if (board.cells[i][j].equals(symbol)
                    && board.cells[(i + 1) % 3][j].equals(symbol)
                    && board.cells[(i + 2) % 3][j].equals(symbol)) {
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        new Main();
    }

    void initComponents() {
        JMenuBar menuBar = new JMenuBar();
        menuGame.setMnemonic(KeyEvent.VK_G);
        menuBar.add(menuGame);

        setJMenuBar(menuBar);
        add(controlPanel);
        add(board);
        add(statusPanel);
    }
}
