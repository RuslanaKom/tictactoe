package app;

import java.util.HashSet;
import java.util.Set;

public class CombinationsChecker {

	public String whoIsTheWinner(char[][] grid, char side) {
		if (checkHorizontals(grid) || checkVerticals(grid) || checkDiagonals(grid)) {
			return "Winner is: " + side;
		} else if (boardIsFilled(grid)) {
			return "It's a draw!";
		}
		return "Next turn";
	}

	public boolean isWinningMove(char[][] grid) {
		if (checkHorizontals(grid) || checkVerticals(grid) || checkDiagonals(grid)) {
			return true;
		}
			return false;
	}

	private boolean checkDiagonals(char[][] grid) {
		return checkDiagonalLeftToRight(grid) || checkDiagonalRightToLeft(grid);
	}

	private boolean checkHorizontals(char[][] grid) {
		Set<Character> uniqueChars = new HashSet<Character>();
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				uniqueChars.add(grid[row][col]);
			}
			if (uniqueChars.size() == 1 && uniqueChars.iterator().next() != 0) {
				return true;
			}
			uniqueChars.clear();
		}
		return false;
	}

	private boolean checkVerticals(char[][] grid) {
		Set<Character> uniqueChars = new HashSet<Character>();
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid.length; col++) {
				uniqueChars.add(grid[col][row]);
			}
			if (uniqueChars.size() == 1 && uniqueChars.iterator().next() != 0) {
				return true;
			}
			uniqueChars.clear();
		}
		return false;
	}

	private boolean checkDiagonalLeftToRight(char[][] grid) {
		Set<Character> uniqueChars = new HashSet<Character>();
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid.length; col++) {
				if (row == col) {
					uniqueChars.add(grid[row][col]);
					break;
				}
			}
		}
		return uniqueChars.size() == 1 && uniqueChars.iterator().next() != 0;
	}

	private boolean checkDiagonalRightToLeft(char[][] grid) {
		Set<Character> uniqueChars = new HashSet<Character>();
		int row = grid.length - 1;
		for (int col = 0; col < grid.length; col++) {
			uniqueChars.add(grid[row][col]);
			row--;
		}
		if (uniqueChars.size() > 1) {
			uniqueChars.clear();
		}
		return uniqueChars.size() == 1 && uniqueChars.iterator().next() != 0;
	}

	private boolean boardIsFilled(char[][] grid) {
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid.length; col++) {
				if (grid[row][col] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
