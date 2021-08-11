package main;

import static main.Main.*;

enum GameState {
    NOT_STARTED("Game is not started"),
    IN_PROGRESS("Game in progress"),
    X_WINS("X wins"),
    O_WINS("O wins"),
    Draw("Draw");

    String stateStr;

    GameState(String stateStr) {
        this.stateStr = stateStr;
    }
    void setGameState(GameState gameState) {
        Main.gameState = gameState;
        Main.statusPanel.statusLabel.setText(gameState.stateStr);
    }

    GameState getGameState() {
        return Main.gameState;
    }

    void handleGameState(String symbol) {
        GameState newGameState = GameState.IN_PROGRESS;
        if (Main.isWinner(symbol)) {
            newGameState = GameState.valueOf(symbol + "_WINS");
            board.disableCells();
        } else if (Main.board.getCountOf(" ") == 0) {
            newGameState = GameState.Draw;
            board.disableCells();
        }
        setGameState(newGameState);
    }
}

