package main;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
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
        boolean isWinnerByCol;

        if (matchingSymbolsList.size() < 3) {
            return false;
        }

        // Checking diagonally
        if (matchingSymbolsList.stream().filter(el -> el.x == el.y).count() == 3 ||
                matchingSymbolsList.stream().filter(el -> 2 - el.x == el.y).count() == 3) {
            return true;
        }

        isWinnerByRow = matchingSymbolsList.stream()
                .skip(1)
                .allMatch(cell -> matchingSymbolsList.get(0).x == cell.x);
        if (isWinnerByRow) {
            return true;
        }

        isWinnerByCol = matchingSymbolsList.stream()
                .skip(1)
                .allMatch(cell -> matchingSymbolsList.get(0).y == cell.y);

        return isWinnerByCol;
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
