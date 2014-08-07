package uk.co.ed;

public class GameEngine {

    private GameEngine() {}

    public static GameEngine instance() {
        return new GameEngine();
    }

    public Winner whoIsTheWinnerGiven(String board) {
        if(isThereAWinnerGivenStartOfARow(board, 0)) {
            return getWinnerGiven(board, 0);
        }
        if(isThereAWinnerGivenStartOfARow(board, 3)) {
            return getWinnerGiven(board, 3);
        }
        if(isThereAWinnerGivenStartOfARow(board, 6)) {
            return getWinnerGiven(board, 6);
        }
        if(isThereAWinnerInColumnGiven(board, 0)) {
            return getWinnerGiven(board, 0);
        }
        if(isThereAWinnerInColumnGiven(board, 1)) {
            return getWinnerGiven(board, 1);
        }
        if(isThereAWinnerInColumnGiven(board, 2)) {
            return getWinnerGiven(board, 2);
        }
        if(isThereAWinnerDiagonallyFromLeft(board)) {
            return getWinnerGiven(board, 0);
        }

        return Winner.NOT_EXIST;
    }

    private boolean isThereAWinnerDiagonallyFromLeft(String board) {
        return board.charAt(0) == board.charAt(4) && board.charAt(0) == board.charAt(8) &&
                board.charAt(0) != '.';
    }

    private boolean isThereAWinnerInColumnGiven(String board, int columnIndex) {
        return board.charAt(columnIndex) == board.charAt(columnIndex+3) && board.charAt(columnIndex) == board.charAt(columnIndex+6) &&
                board.charAt(columnIndex) != '.';
    }

    private boolean isThereAWinnerGivenStartOfARow(String board, int rowStart) {
        return board.charAt(rowStart) == board.charAt(rowStart+1) && board.charAt(rowStart) == board.charAt(rowStart+2) &&
                board.charAt(rowStart) != '.';
    }

    private Winner getWinnerGiven(String board, int secondRowStartIndex) {
        return Winner.valueOf(String.valueOf(board.charAt(secondRowStartIndex)).toUpperCase());
    }
}
