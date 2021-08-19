package main;

enum GameState {
    NOT_STARTED,
    IN_PROGRESS,
    X_WINS,
    O_WINS,
    Draw;

    public String toString() {
        String playerType = Main.currPlayer.playerType == PlayerMode.HUMAN ? "Human" : "AI";
        String symbol = Main.currPlayer.symbol;
        switch (this) {
            case Draw:
                return "Draw";
            case NOT_STARTED:
                return "Game is not started";
            case O_WINS:
            case X_WINS:
                return String.format("%s Player(%s) wins", playerType, symbol);
            default:
                return String.format("The turn of %s Player(%s)", playerType, symbol);
        }
    }

    void setGameState(GameState gameState) {
        Main.gameState = gameState;
    }

    GameState getGameState() {
        return Main.gameState;
    }

    void processTurn(String symbol) {
        GameState newGameState = Main.gameState;

        if (Main.isWinner(symbol, false)) {
            newGameState = GameState.valueOf(symbol + "_WINS");
            Main.board.disableCells();
        } else if (Main.board.getCountOf(" ") == 0) {
            newGameState = GameState.Draw;
            Main.board.disableCells();
        }

        setGameState(newGameState);
        Main.statusPanel.setStatusText(newGameState.toString());
    }
}

