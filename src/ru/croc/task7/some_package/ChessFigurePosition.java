package ru.croc.task7.some_package;

public class ChessFigurePosition {
    private int xCoordinate;
    private int yCoordinate;
    private static String letterFields="abcdefgh";

    public int getyCoordinate() {
        return yCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }
    public void setPosition(int x,int y){
        this.xCoordinate=x;
        this.yCoordinate=y;
    }
}
