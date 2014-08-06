package uk.co.ed;

public class GameEngine {

    private GameEngine() {}

    public static GameEngine instance() {
        return new GameEngine();
    }

    public Winner whoIsTheWinnerGiven(String board) {
        if(board.startsWith("xxx")) {
            return Winner.X;
        }
        if(board.startsWith("ooo")) {
            return Winner.O;
        }

        return Winner.NOT_EXIST;
    }
}
