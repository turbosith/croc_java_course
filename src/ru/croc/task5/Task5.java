package ru.croc.task5;

import ru.croc.task5.annotation.Annotations;
import ru.croc.task5.annotation.Circle;
import ru.croc.task5.annotation.Rectangle;

public class Task5 {
    public static void main(String[] args) {
        Circle circle1 = new Circle(2, 2, 2);
        Rectangle rectangle = new Rectangle(3, 1, 1, 3);
        System.out.println(circle1);
        Annotations annotations = new Annotations(circle1, "Turbo");
        System.out.println(annotations);
        Annotations annotations1 = new Annotations(rectangle, "CROC");
        System.out.println(annotations1);
    }
}
