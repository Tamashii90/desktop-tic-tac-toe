//package main;
//
//import java.util.List;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Arrays;
//
//public class HardBot extends Player {
//    public final char BOT_SYMBOL;
//    char[][] BOARD = new char[3][3];
//    final List<Point> allCoords = new ArrayList<>();
//
//    void initialize() {
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                allCoords.add(new Point(i, j));
//            }
//        }
//    }
//
//    public HardBot(char symbol) {
//        this.BOT_SYMBOL = symbol;
//        initialize();
//    }
//
//    static char[][] deepCopy(char[][] arr) {
//        char[][] copy = new char[arr.length][];
//        for (int i = 0; i < copy.length; i++){
//            copy[i] = Arrays.copyOf(arr[i], arr[i].length);
//        }
//        return copy;
//    }
//
//    public void makeMove() {
//        System.out.println("Making move level \"hard\"");
//        int x;
//        int y;
//        BOARD = deepCopy(Main.ARRANGEMENT);
//        var chosenMove = minimax(BOT_SYMBOL);
//        x = ((Point) chosenMove.get("coords")).x;
//        y = ((Point) chosenMove.get("coords")).y;
//        try {
//            Main.enterCoords(x, y);
//        } catch (Exception e) {}
//    }
//
//    HashMap<String, Object> minimax(char currPlayer) {
//        var entry = new HashMap<String, Object>();
//        int score;
//        if (isWinner('X') || isWinner('O')) {
//            score = BOT_SYMBOL != currPlayer ? 10 : -10;
//            entry.put("score", score);
//            return entry;
//        }
//        if (getEmptySlots().size() == 0) {
//            score = 0;
//            entry.put("score", score);
//            return entry;
//        }
//
//        var emptySlots = getEmptySlots();
//        var listOfMoves = new ArrayList<HashMap<String, Object>>();
//        for (Point p : emptySlots) {
//            addPoint(p, currPlayer);
//            char newPlayer = currPlayer == 'X' ? 'O' : 'X';
//            var move = minimax(newPlayer);
//            move.put("coords", p);
//            listOfMoves.add(move);
//            removePoint(p, currPlayer);
//        }
//        return calcEntry(listOfMoves, currPlayer);
//    }
//    HashMap<String, Object> calcEntry(List<HashMap<String, Object>> entries, char currPlayer) {
//        if (BOT_SYMBOL == currPlayer) {
//            return entries.stream()
//                    .reduce(entries.get(0), (acc, el) ->
//                            ((int) acc.get("score")) >= ((int) el.get("score")) ? acc : el);
//        }
//        return entries.stream().reduce(entries.get(0), (acc, el) ->
//                ((int) acc.get("score")) <= ((int) el.get("score")) ? acc : el);
//    }
//
//    void addPoint(Point p, char symbol) {
//        BOARD[p.x][p.y] = symbol;
//    }
//
//    void removePoint(Point p, char symbol) {
//        BOARD[p.x][p.y] = ' ';
//    }
//
//    boolean isWinner(char symbol) {
//        return (BOARD[0][0] == symbol && BOARD[0][1] == symbol && BOARD[0][2] == symbol ||
//                BOARD[1][0] == symbol && BOARD[1][1] == symbol && BOARD[1][2] == symbol ||
//                BOARD[2][0] == symbol && BOARD[2][1] == symbol && BOARD[2][2] == symbol ||
//                BOARD[0][0] == symbol && BOARD[1][0] == symbol && BOARD[2][0] == symbol ||
//                BOARD[0][1] == symbol && BOARD[1][1] == symbol && BOARD[2][1] == symbol ||
//                BOARD[0][2] == symbol && BOARD[1][2] == symbol && BOARD[2][2] == symbol ||
//                BOARD[0][0] == symbol && BOARD[1][1] == symbol && BOARD[2][2] == symbol ||
//                BOARD[2][0] == symbol && BOARD[1][1] == symbol && BOARD[0][2] == symbol);
//    }
//
//    List<Point> getEmptySlots() {
//        List<Point> emptySlots = new ArrayList<>();
//        for (int i = 0; i <= 2; i++) {
//            for (int j = 0; j <=2; j++) {
//                if (BOARD[i][j] == ' ') {
//                    emptySlots.add(new Point(i, j));
//                }
//            }
//        }
//        return emptySlots;
//    }
//}
