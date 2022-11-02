package ru.croc.task6.some_package;

public class Rectangle extends Figure implements Movable {
    int x1;
    int y1;
    int x2;
    int y2;

    public Rectangle(int... coordinates) {
        super(coordinates);
        this.x1 = coordinates[0];
        this.y1 = coordinates[1];
        this.x2 = coordinates[2];
        this.y2 = coordinates[3];
    }

    public String toString() {
        return "R (<" + x1 + ">," +
                " <" + y1 + ">)," +
                " (<" + x2 + ">, " +
                "<" + y2 + ">)";
    }

    public boolean FindPoint(int x, int y) {
        if ((x1 == x && y1 == y) | (x2 == x && y2 == y)) {
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
