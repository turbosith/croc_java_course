package ru.croc.task6.some_package;

public class Circle extends Figure implements Movable {
    int x0;
    int y0;
    int r;

    public Circle(int... coordinates) {
        super(coordinates);
        this.x0 = coordinates[0];
        this.y0 = coordinates[1];
        this.r = coordinates[2];
    }

    public String toString() {
        return "C (<" + x0 + ">, " +
                "<" + y0 + ">)," +
                " <" + r + ">";
    }

    public boolean FindPoint(int x, int y) {
        if (x0 == x && y0 == y) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void move(int dx, int dy) {
        x0 = dx;
        y0 = dy;
    }
}
