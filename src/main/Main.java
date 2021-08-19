package main;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {

    static GameState gameState = GameState.NOT_STARTED;
    static Player playerX;
    static Player playerO;
    static Player currPlayer;

    static Board board = new Board();
    static StatusPanel statusPanel = new StatusPanel();
    static ControlPanel controlPanel = new ControlPanel();

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


    static boolean isWinner(String symbol, boolean isSimulation) {
        // isSimulation is used to check whether the AI is calling isWinner for
        // decision-making (e.g. minimax algorithm) or whether it's being called
        // to actually check the winner between turns
        boolean isWinner = false;
        List<Cell> winningBtns = new ArrayList<>();
        if (board.getCountOf(symbol) < 3) {
            return false;
        }

        if (board.cells[0][0].getSymbol().equals(symbol)
                && board.cells[1][1].getSymbol().equals(symbol)
                && board.cells[2][2].getSymbol().equals(symbol)) {
            isWinner = true;
            winningBtns = List.of(board.cells[0][0], board.cells[1][1], board.cells[2][2]);
        } else if (board.cells[0][2].getSymbol().equals(symbol)
                && board.cells[1][1].getSymbol().equals(symbol)
                && board.cells[2][0].getSymbol().equals(symbol)) {
            isWinner = true;
            winningBtns = List.of(board.cells[0][2], board.cells[1][1], board.cells[2][0]);
        }

        if (!isWinner) {
            for (int i = 0, j = 0; i < 3; i++, j++) {
                if (board.cells[i][j].getSymbol().equals(symbol)
                        && board.cells[i][(j + 1) % 3].getSymbol().equals(symbol)
                        && board.cells[i][(j + 2) % 3].getSymbol().equals(symbol)) {
                    isWinner = true;
                    winningBtns = List.of(board.cells[i][j], board.cells[i][(j + 1) % 3],
                            board.cells[i][(j + 2) % 3]);
                    break;
                } else if (board.cells[i][j].getSymbol().equals(symbol)
                        && board.cells[(i + 1) % 3][j].getSymbol().equals(symbol)
                        && board.cells[(i + 2) % 3][j].getSymbol().equals(symbol)) {
                    isWinner = true;
                    winningBtns = List.of(board.cells[i][j], board.cells[(i + 1) % 3][j],
                            board.cells[(i + 2) % 3][j]);
                    break;
                }
            }
        }

        if (!isSimulation) {
            winningBtns.forEach(btn -> btn.setBackground(Color.DARK_GRAY));
        }
        return isWinner;
    }

    public static void main(String[] args) {
        new Main();
    }

    void initComponents() {
        add(controlPanel);
        add(board);
        add(statusPanel);
    }
}
