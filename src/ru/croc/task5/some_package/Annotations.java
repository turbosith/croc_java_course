package ru.croc.task5.some_package;

public class Annotations {
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

    public Annotations(Figure figure,String name){//конструктор, в котором задаётся объект класса Figure и его имя
        this.figure=figure;
        this.name=name;
    }
    public String toString(){//переопределение метода, добавление имени в конец
        return figure.toString()+": <" + name + ">";
    }

}
