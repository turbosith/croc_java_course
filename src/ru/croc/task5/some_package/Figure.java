package ru.croc.task5.some_package;

public class Figure {
    int[] coordinates;
    public  Figure(int... coordinates) {
        this.coordinates=coordinates;
    }

    public int[] getCoordinates() {
        return coordinates;
    }
    public String toString(){
        return "Figure";
    }
}
