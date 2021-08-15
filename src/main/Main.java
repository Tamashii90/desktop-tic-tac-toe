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
        var matchingSymbolsList = Arrays.stream(board.cells)
                .flatMap(Arrays::stream)
                .filter(el -> el.getText().equals(symbol))
                .collect(Collectors.toList());
        boolean isWinnerByRow;
        boolean isWinnerByCol = false;

        if (matchingSymbolsList.size() < 3) {
            return false;
        }

        // Checking diagonally
        if (matchingSymbolsList.stream().filter(el -> el.x == el.y).count() == 3 ||
                matchingSymbolsList.stream().filter(el -> 2 - el.x == el.y).count() == 3) {
            return true;
        }

        for (var matchingSymbol : matchingSymbolsList) {
            isWinnerByRow = matchingSymbolsList.stream()
                    .filter(cell -> matchingSymbol.x == cell.x)
                    .count() == 3;
            if (isWinnerByRow) {
                return true;
            }

            isWinnerByCol = matchingSymbolsList.stream()
                    .filter(cell -> matchingSymbol.y == cell.y)
                    .count() == 3;
        }
        return isWinnerByCol;
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
