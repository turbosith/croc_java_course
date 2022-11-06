package ru.croc.task6.annotation_package;

abstract class Figure implements Movable{
    int[] coordinates;
    public int[] getCoordinates() {
        return coordinates;
    }

    public String toString() {
        return "Figure";
    }

    public boolean FindPoint(int x, int y) {
        return false;
    }


}
