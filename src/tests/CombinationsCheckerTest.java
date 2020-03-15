//package tests;
//
//import app.CombinationsChecker;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CombinationsCheckerTest {
//
//	private CombinationsChecker checker;
//
//	@BeforeEach
//	void setUp() throws Exception {
//		checker = new CombinationsChecker();
//	}
//
//	@Test
//	void expectVictoryByColumn1() {
//		char[][] grid = { { 'x', 'y', 'y' }, { 'x', 0, 'x' }, { 'x', 'x', 0 } };
//		assertEquals("Winner is: x", checker.whoIsTheWinner(grid, 'x'));
//	}
//
//	@Test
//	void expectVictoryByColumn2() {
//		char[][] grid = { { 'y', 'x', 'y' }, { 0, 'x', 'x' }, { 'x', 'x', 0 } };
//		assertEquals("Winner is: x", checker.whoIsTheWinner(grid, 'x'));
//	}
//
//	@Test
//	void expectVictoryByColumn3() {
//		char[][] grid = { { 'y', 'y', 'x' }, { 'x', 0, 'x' }, { 'x', 0, 'x' } };
//		assertEquals("Winner is: x", checker.whoIsTheWinner(grid, 'x'));
//	}
//
//	@Test
//	void dontExpectVictoryByColumnOfZeroes() {
//		char[][] grid = { { 'y', 'y', 0 }, { 'x', 'x', 0 }, { 'x', 'x', 0 } };
//		assertEquals("Next turn", checker.whoIsTheWinner(grid, 'x'));
//	}
//
//	@Test
//	void expectVictoryByRow1() {
//		char[][] grid = { { 'y', 'y', 'y' }, { 'y', 'x', 'y' }, { 'y', 'x', 'x' } };
//		assertEquals("Winner is: y", checker.whoIsTheWinner(grid, 'y'));
//	}
//
//	@Test
//	void expectVictoryByRow2() {
//		char[][] grid = { { 'y', 'x', 'y' }, { 'y', 'y', 'y' }, { 'y', 'x', 'y' } };
//		assertEquals("Winner is: y", checker.whoIsTheWinner(grid, 'y'));
//	}
//
//	@Test
//	void expectVictoryByRow3() {
//		char[][] grid = { { 'y', 'x', 'y' }, { 'y', 'x', 'x' }, { 'y', 'y', 'y' } };
//		assertEquals("Winner is: y", checker.whoIsTheWinner(grid, 'y'));
//	}
//
//	@Test
//	void dontExpectVictoryByRowOfZeroes() {
//		char[][] grid = { { 'y', 'x', 'y' }, { 'y', 'x', 'x' }, { 0, 0, 0 } };
//		assertEquals("Next turn", checker.whoIsTheWinner(grid, 'y'));
//	}
//
//	@Test
//	void expectVictoryByLeftRightDiagonal() {
//		char[][] grid = { { 'x', 'x', 'y' }, { 'y', 'x', 'x' }, { 'y', 'y', 'x' } };
//		assertEquals("Winner is: x", checker.whoIsTheWinner(grid, 'x'));
//	}
//
//	@Test
//	void dontExpectVictoryByLeftRightDiagonalOfZeroes() {
//		char[][] grid = { { 0, 'x', 'y' }, { 'y', 0, 'x' }, { 'y', 'y', 0 } };
//		assertEquals("Next turn", checker.whoIsTheWinner(grid, 'x'));
//	}
//
//	@Test
//	void dontExpectVictoryByRightLeftDiagonalOfZeroes() {
//		char[][] grid = { { 0, 'x', 0 }, { 'y', 0, 'x' }, { 0, 'y', 'y' } };
//		assertEquals("Next turn", checker.whoIsTheWinner(grid, 'x'));
//	}
//
//	@Test
//	void expectVictoryByRightLeftDiagonal() {
//		char[][] grid = { { 'x', 'x', 'y' }, { 'y', 'y', 'x' }, { 'y', 'y', 'x' } };
//		assertEquals("Winner is: y", checker.whoIsTheWinner(grid, 'y'));
//	}
//
//	@Test
//	void expectDraw() {
//		char[][] grid = { { 'x', 'x', 'y' }, { 'y', 'x', 'x' }, { 'x', 'y', 'y' } };
//		assertEquals("It's a draw!", checker.whoIsTheWinner(grid, 'x'));
//	}
//
//	@Test
//	void expectNexTurnMessage() {
//		char[][] grid = { { 'x', 'x', 'y' }, { 'y', 'x', 'x' }, { 'x', 'y', 0 } };
//		assertEquals("Next turn", checker.whoIsTheWinner(grid, 'x'));
//	}
//
//	@Test
//	void expectNoVictoryOnZerosCombinations() {
//		char[][] grid = { { 0, 0, 0 }, { 0, 'x', 0 }, { 0, 0, 0 } };
//		assertEquals("Next turn", checker.whoIsTheWinner(grid, 'x'));
//	}
//
//}
