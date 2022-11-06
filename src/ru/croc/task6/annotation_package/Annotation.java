package ru.croc.task6.annotation_package;

public class Annotation {
    Figure figure;
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public Figure getFigure() {
        return figure;
    }

    public Annotation(Figure figure, String name) {//конструктор, в котором задаётся объект класса Figure и его имя
        this.figure = figure;
        this.name = name;
    }

    public String toString() {//переопределение метода, добавление имени в конец
        return figure.toString() + ": <" + name + ">";
    }

}
