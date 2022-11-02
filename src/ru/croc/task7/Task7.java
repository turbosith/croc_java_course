package ru.croc.task7;

import ru.croc.task7.some_package.ChessPosition;
import ru.croc.task7.some_package.IllegalMoveException;
import ru.croc.task7.some_package.KnightMoves;

public class Task7 {
    public static void main(String[] args) throws IllegalMoveException {
        ChessPosition c1 = new ChessPosition(2, 0);
        System.out.println(c1);
        //ChessPosition c2=new ChessPosition(-1,0);
        //System.out.println(c2);
        ChessPosition c3 = c1.parse("g8");
        ChessPosition c4 = c1.parse("e7");
        ChessPosition c5 = c1.parse("e6");
        ChessPosition c6 = c1.parse("c8");
        System.out.println(c3);
        KnightMoves knightMoves = new KnightMoves();
        ChessPosition[] positionsArray1 = {c3, c4, c6};
        ChessPosition[] positionsArray = {c3, c4, c5};
        knightMoves.moves(positionsArray1);
        knightMoves.moves(positionsArray);

    }

}
