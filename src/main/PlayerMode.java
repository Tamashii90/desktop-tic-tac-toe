package main;

public enum PlayerMode {
    HUMAN("Human"),
    EASY("AI - Easy"),
    MEDIUM("AI - Medium"),
    HARD("AI - Hard");

    String displayStr;

    PlayerMode(String str) {
        displayStr = str;
    }

    static PlayerMode parseMode(String str) {
        switch (str) {
            case "Human":
                return HUMAN;
            case "AI - Easy":
                return EASY;
            case "AI - Medium":
                return MEDIUM;
            default:
                return HARD;
        }
    }

    Player instantiate(String symbol) {
        switch (this) {
            case HUMAN:
                return new Human(symbol);
            case EASY:
                return new EasyBot(symbol);
            case MEDIUM:
                return new MediumBot(symbol);
            default:
                return new HardBot(symbol);
        }
    }

    PlayerMode getNextMode() {
        int currentOrdinal = this.ordinal();
        var possibleValues = PlayerMode.values();
        return possibleValues[(currentOrdinal + 1) % possibleValues.length];
    }
}
