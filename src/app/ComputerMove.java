package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComputerMove {

    private CombinationsChecker combinationsChecker = new CombinationsChecker();

    public Position makeComputerMove(char[][] board, int moveCount, char side) {
        if (moveCount <= 3) {
            return selectStartingMove(board, side);
        }
        return selectMinimumLossMove(board, side);
    }

    private Position selectMinimumLossMove(char[][] board, char side) {
        List<Position> freePositions = getFreePositions(board);
        List<Move> evaluatedMoves = new ArrayList<>();
        char[][] testBoard = copyBoard(board);
        for (Position position : freePositions) {
            testBoard[position.getX()][position.getY()] = side;
            if (combinationsChecker.isWinningMove(testBoard)) {
                board[position.getX()][position.getY()] = side;
                return position;
            }
            // if not winning move evaluate move with next human move variants
            char humanSide = getHumanSide(side);
            Move move = new Move();
            move.setPosition(position);
            move.setScore(0);
            List<Position> freePositionsForHuman = getFreePositions(testBoard);
            for (Position nexHumanPosition : freePositionsForHuman) {
                testBoard[nexHumanPosition.getX()][nexHumanPosition.getY()] = humanSide;
                if (combinationsChecker.isWinningMove(testBoard)) {
                    move.setScore(-1);
                }
                testBoard[nexHumanPosition.getX()][nexHumanPosition.getY()] = 0;
            }
            evaluatedMoves.add(move);
            testBoard[position.getX()][position.getY()] = 0;
        }
        Move goodMove = evaluatedMoves
                .stream()
                .sorted(Comparator.comparingInt(Move::getScore).reversed())
                .findFirst()
                .orElse(null);
        Position newPosition = goodMove.getPosition();
        board[newPosition.getX()][newPosition.getY()] = side;
        return newPosition;
    }

    private char getHumanSide(char side) {
        if (side == 'x') {
            return 'o';
        }
        return 'x';
    }

    private char[][] copyBoard(char[][] board) {
        char[][] copy = Arrays.stream(board)
                .map(char[]::clone)
                .toArray(char[][]::new);
        return copy;
    }

    private List<Position> getFreePositions(char[][] board) {
        List<Position> freePositions = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == 0) {
                    freePositions.add(new Position(row, col));
                }
            }
        }
        return freePositions;
    }

    private Position selectStartingMove(char[][] board, char side) {
        Position middle = getBoardMiddle(board);
        if (board[middle.getX()][middle.getY()] == 0) {
            board[middle.getX()][middle.getY()] = side;
            return middle;
        } else {
            List<Position> corners = getBoardCorners(board);
            Position freeCorner = corners
                    .stream()
                    .filter(p -> board[p.getX()][p.getY()] == 0)
                    .findFirst()
                    .orElse(null);
            board[freeCorner.getX()][freeCorner.getY()] = side;
            return freeCorner;
        }
    }

    private Position getBoardMiddle(char[][] board) {
        int middle = (board.length - 1) / 2;
        return new Position(middle, middle);
    }

    private List<Position> getBoardCorners(char[][] board) {
        List<Position> corners = new ArrayList<>();
        Position positionLU = new Position(0, 0);
        Position positionRU = new Position(0, board.length - 1);
        Position positionLB = new Position(board.length - 1, 0);
        Position positionRB = new Position(board.length - 1, board.length - 1);
        corners.addAll(Arrays.asList(positionLU, positionRB, positionLB, positionRU));
        return corners;
    }
}
