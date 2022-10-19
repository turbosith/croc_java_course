package ru.croc.task1;

import java.util.Scanner;
import java.lang.String;
import java.text.DecimalFormat;

public class Task1 {
    static class Point {//класс точки
        double x;
        double y;


        public static double CalculateLength(Point pointFirst, Point pointSecond) {// функция подсчета длинны стороны треугольника по координатам двух точек

            return Math.sqrt((pointSecond.x - pointFirst.x) *//реализую возведение в степень не с помощью Math.pow(), так как это наиболее оптимальная, с точки зрения скорости исполнения, реализация
                    (pointSecond.x - pointFirst.x) +
                    (pointSecond.y - pointFirst.y) *
                            (pointSecond.y - pointFirst.y));
        }

        public static boolean СheckСoordinate(double a, double b, double c) {//реализовал проверку на существование треугольника по его координатам
            if ((a + b > c) &&
                    (a + c > b) &&
                    (c + b > a)) {
                return true;
            } else {
                return false;
            }
        }

        public static void main(String[] args) {
            Point vertexA = new Point();
            Point vertexB = new Point();
            Point vertexC = new Point();
            boolean flag = true;//флаг выхода из цикла. Пользователь будет вводить значения, пока не введет корректные
            while (flag == true) {
                System.out.println("Введите координату х вершины №1: ");//ввод координат
                Scanner s = new Scanner(System.in);
                vertexA.x = s.nextDouble();
                System.out.println("Введите координату y вершины №1: ");
                vertexA.y = s.nextDouble();
                System.out.println("Введите координату х вершины №2: ");
                vertexB.x = s.nextDouble();
                System.out.println("Введите координату y вершины №2: ");
                vertexB.y = s.nextDouble();
                System.out.println("Введите координату х вершины №3: ");
                vertexC.x = s.nextDouble();
                System.out.println("Введите координату y вершины №3: ");
                vertexC.y = s.nextDouble();

                double triangleSquare;
                double a = CalculateLength(vertexA, vertexB);//подсчет длин сторон

                double b = CalculateLength(vertexC, vertexB);
                double c = CalculateLength(vertexC, vertexA);
                if (СheckСoordinate(a, b, c) != false) {// проверка на корректность
                    double halfMeter = (a + b + c) / 2;// вычисление площади по формуле Герона
                    triangleSquare = Math.sqrt(halfMeter *
                            (halfMeter - a) *
                            (halfMeter - b) *
                            (halfMeter - c));
                    DecimalFormat decimalFormat = new DecimalFormat("#.###");//реализация округления результата, возможно, я не правильно работал с double
                    String result = decimalFormat.format(triangleSquare);//у меня получался длинный остаток, я выбрал decimalFormat, так как он не оставляет нули
                    System.out.println("Площадь треугольника: " + result);//с помощью # задается шаблон формата
                    flag = false;
                } else {
                    System.out.println("Данный треугольник не существует, попробуйте ещё раз");
                }
            }
        }
    }


}