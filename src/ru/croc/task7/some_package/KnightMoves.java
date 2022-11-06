package ru.croc.task7.some_package;

public class KnightMoves {
    public static boolean isMoveCorrect(ChessPosition start, ChessPosition end) {
        return Math.abs(end.getXCoordinate() - start.getXCoordinate()) == 1 && Math.abs(end.getYCoordinate() - start.getYCoordinate()) == 2
                || Math.abs(end.getXCoordinate() - start.getXCoordinate()) == 2 && Math.abs(end.getYCoordinate() - start.getYCoordinate()) == 1;
    }

    public static void moves(ChessPosition... positions) throws IllegalMoveException {
        for (int i = 0; i < positions.length - 1; i++) {
            ChessPosition start = positions[i];
            ChessPosition end = positions[i + 1];
            if (!isMoveCorrect(start, end)) {
                throw new IllegalMoveException(start, end);
            }
        }
        System.out.println("OK");
    }
}
