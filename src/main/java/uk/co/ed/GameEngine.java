package uk.co.ed;

public class GameEngine {

    private GameEngine() {}

    public static GameEngine instance() {
        return new GameEngine();
    }

    public Winner whoIsTheWinnerGiven(String board) {
        if(board.charAt(0) == board.charAt(1) && board.charAt(0) == board.charAt(2) &&
                board.charAt(0) != '.') {
            return Winner.valueOf(String.valueOf(board.charAt(0)).toUpperCase());
        }

        return Winner.NOT_EXIST;
    }
}
