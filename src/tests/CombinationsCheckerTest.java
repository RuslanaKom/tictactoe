package tests;

import app.CombinationsChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CombinationsCheckerTest {

    private CombinationsChecker checker;

    @BeforeEach
    void setUp() throws Exception {
        checker = new CombinationsChecker();
    }

    @Test
    void expectVictoryByColumn1() {
        char[][] grid = { { 'x', 'o', 'o' }, { 'x', 0, 'x' }, { 'x', 'x', 0 } };
        assertEquals("Winner is: x", checker.whoIsTheWinner(grid, 'x'));
    }

    @Test
    void expectVictoryByColumn2() {
        char[][] grid = { { 'o', 'x', 'o' }, { 0, 'x', 'x' }, { 'x', 'x', 0 } };
        assertEquals("Winner is: x", checker.whoIsTheWinner(grid, 'x'));
    }

    @Test
    void expectVictoryByColumn3() {
        char[][] grid = { { 'o', 'o', 'x' }, { 'x', 0, 'x' }, { 'x', 0, 'x' } };
        assertEquals("Winner is: x", checker.whoIsTheWinner(grid, 'x'));
    }

    @Test
    void dontExpectVictoryByColumnOfZeroes() {
        char[][] grid = { { 'o', 'o', 0 }, { 'x', 'x', 0 }, { 'x', 'x', 0 } };
        assertEquals("Next turn", checker.whoIsTheWinner(grid, 'x'));
    }

    @Test
    void expectVictoryByRow1() {
        char[][] grid = { { 'o', 'o', 'o' }, { 'o', 'x', 'o' }, { 'o', 'x', 'x' } };
        assertEquals("Winner is: o", checker.whoIsTheWinner(grid, 'o'));
    }

    @Test
    void expectVictoryByRow2() {
        char[][] grid = { { 'o', 'x', 'o' }, { 'o', 'o', 'o' }, { 'o', 'x', 'o' } };
        assertEquals("Winner is: o", checker.whoIsTheWinner(grid, 'o'));
    }

    @Test
    void expectVictoryByRow3() {
        char[][] grid = { { 'o', 'x', 'o' }, { 'o', 'x', 'x' }, { 'o', 'o', 'o' } };
        assertEquals("Winner is: o", checker.whoIsTheWinner(grid, 'o'));
    }

    @Test
    void dontExpectVictoryByRowOfZeroes() {
        char[][] grid = { { 'o', 'x', 'o' }, { 'o', 'x', 'x' }, { 0, 0, 0 } };
        assertEquals("Next turn", checker.whoIsTheWinner(grid, 'o'));
    }

    @Test
    void expectVictoryByLeftRightDiagonal() {
        char[][] grid = { { 'x', 'x', 'o' }, { 'o', 'x', 'x' }, { 'o', 'o', 'x' } };
        assertEquals("Winner is: x", checker.whoIsTheWinner(grid, 'x'));
    }

    @Test
    void dontExpectVictoryByLeftRightDiagonalOfZeroes() {
        char[][] grid = { { 0, 'x', 'o' }, { 'o', 0, 'x' }, { 'o', 'o', 0 } };
        assertEquals("Next turn", checker.whoIsTheWinner(grid, 'x'));
    }

    @Test
    void dontExpectVictoryByRightLeftDiagonalOfZeroes() {
        char[][] grid = { { 0, 'x', 0 }, { 'o', 0, 'x' }, { 0, 'o', 'o' } };
        assertEquals("Next turn", checker.whoIsTheWinner(grid, 'x'));
    }

    @Test
    void expectVictoryByRightLeftDiagonal() {
        char[][] grid = { { 'x', 'x', 'o' }, { 'o', 'o', 'x' }, { 'o', 'o', 'x' } };
        assertEquals("Winner is: o", checker.whoIsTheWinner(grid, 'o'));
    }

    @Test
    void expectDraw() {
        char[][] grid = { { 'x', 'x', 'o' }, { 'o', 'x', 'x' }, { 'x', 'o', 'o' } };
        assertEquals("It's a draw!", checker.whoIsTheWinner(grid, 'x'));
    }

    @Test
    void expectNexTurnMessage() {
        char[][] grid = { { 'x', 'x', 'o' }, { 'o', 'x', 'x' }, { 'x', 'o', 0 } };
        assertEquals("Next turn", checker.whoIsTheWinner(grid, 'x'));
    }

    @Test
    void expectNoVictoryOnZerosCombinations() {
        char[][] grid = { { 0, 0, 0 }, { 0, 'x', 0 }, { 0, 0, 0 } };
        assertEquals("Next turn", checker.whoIsTheWinner(grid, 'x'));
    }

}
