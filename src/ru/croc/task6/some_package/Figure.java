package ru.croc.task6.some_package;

public class Figure {
    int[] coordinates;

    public Figure(int... coordinates) {
        this.coordinates = coordinates;
    }

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
