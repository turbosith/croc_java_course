package ru.croc.task7.some_package;

public class IllegalMoveException extends Exception {
    public final ChessPosition start;
    public final ChessPosition end;

    public IllegalMoveException(ChessPosition start, ChessPosition end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Конь не может так ходить: " + start + " -> " + end;
    }
}
