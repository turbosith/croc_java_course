package ru.croc.task6.annotation;

abstract class Figure implements Movable{
    int[] coordinates;
    public int[] getCoordinates() {
        return coordinates;
    }

    public String toString() {
        return "Figure";
    }

    public boolean findPoint(int x, int y) {
        return false;
    }


}
