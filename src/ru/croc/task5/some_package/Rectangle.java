package ru.croc.task5.some_package;

public class Rectangle extends Figure{
    int x1;
    int y1;
    int x2;
    int y2;

    public Rectangle(int... coordinates) {
        super(coordinates);
        this.x1=coordinates[0];
        this.y1=coordinates[1];
        this.x2=coordinates[2];
        this.y2=coordinates[3];
    }
    public String toString(){
        return "R (<" + x1 + ">," +
                " <" + y1 + ">)," +
                " (<" + x2 + ">, " +
                "<" + y2 + ">)";
    }

}
