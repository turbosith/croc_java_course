package ru.croc.task2.some_package;

public class MemoryClass {
    private double bytesNumber;
    String[] dataTypesArray = {"B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};//массив типов данных

    public MemoryClass(double bytesNum) {//конструктор класса, получает количество байт и записывает в атрибут
        bytesNumber = bytesNum;
    }

    public void format() {//метод, форматирующий и выводящий на экран заданный размер в байтах в человекочитаемом виде
        int numberDivisions = 0;//количество делений на 1024
        while (bytesNumber / 1024 >= 1) {//проверяем, сколько раз число делится на 1024
            numberDivisions += 1;
            bytesNumber /= 1024;
        }
        System.out.println(String.format("%.1f", bytesNumber) + " " + dataTypesArray[numberDivisions]);//сопоставляем тип данных из массива


    }
}
