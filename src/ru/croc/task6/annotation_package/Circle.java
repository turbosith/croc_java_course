package ru.croc.task6.annotation_package;

public class Circle extends Figure  {
    int x0;
    int y0;
    int r;

    public Circle(int x0, int y0, int r) {

        this.x0 = x0;
        this.y0 = y0;
        this.r = r;
    }

    public String toString() {
        return "C (<" + x0 + ">, " +
                "<" + y0 + ">)," +
                " <" + r + ">";
    }

    public boolean FindPoint(int x, int y) {
        if (Math.pow(x-x0,2) + Math.pow(y-y0,2)<Math.pow(r,2)) {
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
