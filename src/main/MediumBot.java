//package main;
//
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static main.Main.*;
//
//public class MediumBot extends AIPlayer {
//
//    MediumBot(String symbol) {
//        super(symbol);
//    }
//
//    public void actualMakeMove() {
//        int x;
//        int y;
//        Cell chosenCell = trySmartMove();
//        if (chosenCell != null) {
//            System.out.println("smart move!");
//        }
//        if (chosenCell == null) {
//            do {
//                x = new Random().nextInt(3);
//                y = new Random().nextInt(3);
//            } while (!Main.board.cells[x][y].isEmpty());
//            chosenCell = Main.board.cells[x][y];
//        }
//        chosenCell.doClick();
//    }
//
//    Cell trySmartMove() {
//        Cell p = tryWinMove();
//        return p != null ? p : tryBlockWinMove();
//    }
//
//    Cell tryWinMove() {
//        Cell p;
//        if (currPlayer.symbol.equals("X")) {
//            p = smartMove("X");
//        } else {
//            p = smartMove("O");
//        }
//        return p;
//    }
//
//    Cell tryBlockWinMove() {
//        Cell p;
//        if (currPlayer.symbol.equals("X")) {
//            p = smartMove("O");
//        } else {
//            p = smartMove("X");
//        }
//        return p;
//    }
//
//    Cell smartMove(String symbol) {
//
//    }
//}
