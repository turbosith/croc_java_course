package ru.croc.task7.some_package;


public class ChessPosition {
    private int xCoordinate;
    private int yCoordinate;
    private static String LETTERS = "abcdefgh";

    public int getYCoordinate() {
        return yCoordinate;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        if (yCoordinate < 0 | yCoordinate > 7) {
            throw new IllegalArgumentException("Координаты должны находится в пределе от 0 до 7");
        }
        this.yCoordinate = yCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        if (xCoordinate < 0 | xCoordinate > 7) {
            throw new IllegalArgumentException("Координаты должны находится в пределе от 0 до 7");
        }
        this.xCoordinate = xCoordinate;
    }

    public void setPosition(int x, int y) {
        if (x < 0 | y < 0 | x > 7 | y > 7) {
            throw new IllegalArgumentException("Координаты должны находится в пределе от 0 до 7");
        }
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public ChessPosition(int x, int y) {
        if (x < 0 | y < 0 | x > 7 | y > 7) {
            throw new IllegalArgumentException("Координаты должны находится в пределе от 0 до 7");
        }
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public String toString() {
        return "<" + LETTERS.charAt(xCoordinate) + "><" + (yCoordinate+1) + ">";
    }

    public static ChessPosition parse(String position) {
        if (position.length() != 2) {
            throw new IllegalArgumentException("Ошибочная позиция: '" + position + "'. Должная состоять из двух символов");
        } else {
            String LetterPosition = String.valueOf(position.charAt(0));
            if (LETTERS.contains(LetterPosition)) {
                ChessPosition chessPosition = new ChessPosition(LETTERS.indexOf(position.charAt(0)), (position.charAt(1) - '0') - 1);
                return chessPosition;
            } else {
                throw new IllegalArgumentException("Буква должна быть от a до h");
            }
        }
    }

}
