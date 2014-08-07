package uk.co.ed;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class GameEngineShould {

    @Test
    public void find_a_no_winner_for_empty_board() {
        final String board = ".........";

        Winner winner = gameEngine().whoIsTheWinnerGiven(board);

        assertThat(winner, is(equalTo(Winner.NOT_EXIST)));
    }

    private GameEngine gameEngine() {
        return GameEngine.instance();
    }

    @Test
    public void find_X_as_winner_in_first_row() {
        final String board = "xxx.ooo..";

        Winner winner = gameEngine().whoIsTheWinnerGiven(board);

        assertThat(winner, is(equalTo(Winner.X)));
    }

    @Test
    public void find_O_as_winner_in_a_first_row() {
        final String board = "ooo.xxxx.";

        Winner winner = gameEngine().whoIsTheWinnerGiven(board);

        assertThat(winner, is(equalTo(Winner.O)));
    }

    @Test
    public void find_winner_in_second_row() {
        final String board = "oo.xxxo..";

        Winner winner = gameEngine().whoIsTheWinnerGiven(board);

        assertThat(winner, is(equalTo(Winner.X)));
    }

    @Test
    public void find_winner_in_third_row() {
        final String board = "..xx.xooo";

        Winner winner = gameEngine().whoIsTheWinnerGiven(board);

        assertThat(winner, is(equalTo(Winner.O)));
    }

    @Test
    public void find_winner_in_first_column() {
        final String board = "x..xo.xoo";

        Winner winner = gameEngine().whoIsTheWinnerGiven(board);

        assertThat(winner, is(equalTo(Winner.X)));
    }
}
