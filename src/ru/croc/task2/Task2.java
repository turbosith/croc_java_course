package ru.croc.task2;

import ru.croc.task2.some_package.MemoryClass;

import java.util.Scanner;
import java.lang.String;

public class Task2 {


    public static void main(String[] args) {
        boolean flag = true;
        System.out.println("Если хотите завершить работу, то введите 0  в командной строке");
        while (flag == true) {
            System.out.println("Введите количество байт: ");
            Scanner s = new Scanner(System.in);
            double bytesNum = s.nextDouble();
            MemoryClass size = new MemoryClass(bytesNum);//создание объекта Memory
            if (bytesNum > 0) {
                size.format();//форматированный вывод
            } else if (bytesNum == 0) {//завершение работы
                flag = false;
            } else {
                System.out.println("Количество байт должно быть больше нуля");//проверка
            }
        }

    }

}