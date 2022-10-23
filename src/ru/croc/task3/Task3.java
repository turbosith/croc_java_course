package ru.croc.task3;

import java.util.Scanner;
import java.lang.String;

public class Task3 {
    static void swap(String[] array, int positionFirst, int positionSecond) {//метод, который меняет элементы массива местами
        String save = array[positionFirst];
        array[positionFirst] = array[positionSecond];
        array[positionSecond] = save;
    }

    public static void main(String[] args) {

        System.out.println("Введите массив");
        Scanner s = new Scanner(System.in);
        String arrayInput = s.nextLine();
        String[] array = arrayInput.split(" ");//разделение массива на числа, с помощью разделителя-пробела
        int max = 0;//инициализация переменных максимума, минимума и их индексов
        int maxIndex = 0;
        int min = 13132323;
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {//алгоритм нахождения максимума и минимума
            int number = Integer.parseInt(array[i]);
            if (number > max) {
                max = number;
                maxIndex = i;
            }
            if (number < min) {
                min = number;
                minIndex = i;
            }
        }
        int lastElement = array.length - 1;
        System.out.println("макс " + max + " in " + maxIndex + "min " + min + " in " + minIndex + " " + lastElement);
        swap(array, maxIndex, array.length - 1);//изменение массива согласно условиям задания
        if (minIndex == lastElement) {//поменяем индекс миинимума при возможной перестановке
            minIndex = maxIndex;
        }
        swap(array, minIndex, 0);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}