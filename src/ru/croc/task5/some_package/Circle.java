package ru.croc.task5.some_package;

public class Circle extends Figure{
    int x0;
    int y0;
    int r;

    public Circle(int... coordinates) {
        super(coordinates);
        this.x0=coordinates[0];
        this.y0=coordinates[1];
        this.r=coordinates[2];
    }
    public String toString(){
        return  "C (<" + x0 + ">, " +
                "<" + y0 + ">)," +
                " <" + r + ">";
    }
}
