package ru.croc.task2.some_package;

public class MemoryClass {
    private double bytesNumber;

    public MemoryClass(double bytesNum) {//конструктор класса, получает количество байт и записывает в атрибут
        bytesNumber = bytesNum;
    }

    public void format() {//метод, форматирующий и выводящий на экран заданный размер в байтах в человекочитаемом виде
        if (bytesNumber < 1024) {
            System.out.println(String.format("%.1f", bytesNumber) + " B");
        } else if (bytesNumber < 1048576) {
            System.out.println(String.format("%.1f", bytesNumber / 1024) + " KB");
        } else if (bytesNumber < 1073741824) {
            System.out.println( String.format("%.1f", bytesNumber / 1048576) + " MB");
        } else if (bytesNumber < 1099511627776L) {
            System.out.println( String.format("%.1f", bytesNumber / 1073741824) + " GB");
        } else {
            System.out.println( String.format("%.1f", bytesNumber / 1099511627776L) + " TB");
        }

    }
}
