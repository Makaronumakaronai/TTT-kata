package uk.co.ed;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class GameEngineShould {

    private GameEngine gameEngine() {
        return GameEngine.instance();
    }

    @Test
    public void find_a_no_winner_for_empty_board() {
        verifyThatForGivenBoardWinnerIs(".........", Winner.NOT_EXIST);
    }

    private void verifyThatForGivenBoardWinnerIs(String board, Winner notExist) {
        Winner winner = gameEngine().whoIsTheWinnerGiven(board);
        assertThat(winner, is(equalTo(notExist)));
    }

    @Test
    public void find_X_as_winner_in_first_row() {
        verifyThatForGivenBoardWinnerIs("xxx.ooo..", Winner.X);
    }

    @Test
    public void find_O_as_winner_in_a_first_row() {
        verifyThatForGivenBoardWinnerIs("ooo.xxxx.", Winner.O);
    }

    @Test
    public void find_winner_in_second_row() {
        verifyThatForGivenBoardWinnerIs("oo.xxxo..", Winner.X);
    }

    @Test
    public void find_winner_in_third_row() {
        verifyThatForGivenBoardWinnerIs("..xx.xooo", Winner.O);
    }

    @Test
    public void find_winner_in_first_column() {
        verifyThatForGivenBoardWinnerIs("x..xo.xoo", Winner.X);
    }

    @Test
    public void find_winner_in_second_column() {
        verifyThatForGivenBoardWinnerIs(".xo.xo.xo", Winner.X);
    }

    @Test
    public void find_winner_in_third_column() {
        verifyThatForGivenBoardWinnerIs("..xoox.ox", Winner.X);
    }

    @Test
    public void find_winner_diagonally_from_left() {
        verifyThatForGivenBoardWinnerIs("x.oox.o.x", Winner.X);
    }

    @Test
    public void find_winner_diagonally_from_right() {
        verifyThatForGivenBoardWinnerIs("o.xoxox..", Winner.X);
    }

    @Test
    public void x_should_be_picked_up_first_WHEN_x_winner_in_second_row_and_o_in_first() {
        verifyThatForGivenBoardWinnerIs("oooxxx...", Winner.X);
    }

    @Test
    public void x_should_be_picked_up_first_WHEN_x_winner_in_last_column_and_o_in_first() {
        verifyThatForGivenBoardWinnerIs("o.xo.xo.x", Winner.X);
    }
}
