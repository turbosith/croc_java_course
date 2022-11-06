package ru.croc.task6.annotation_package;

public class Rectangle extends Figure {
    int x1;
    int y1;
    int x2;
    int y2;

    public Rectangle(int x1, int y1, int x2, int y2) {

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public String toString() {
        return "R (<" + x1 + ">," +
                " <" + y1 + ">)," +
                " (<" + x2 + ">, " +
                "<" + y2 + ">)";
    }

    public boolean FindPoint(int x, int y) {
        if (x > x1 && y > y1 && x < x2 && x < y2) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void move(int dx, int dy) {
        x1 = dx;
        x2 = dy;
    }
}
