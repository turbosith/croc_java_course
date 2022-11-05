package ru.croc.task5.annotation_package;

public class Circle extends Figure {
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
}
