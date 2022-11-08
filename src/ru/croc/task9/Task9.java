package ru.croc.task9;


import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        System.out.println("Введите путь");
        Scanner s = new Scanner(System.in);
        String path = s.nextLine();
        int index=path. lastIndexOf("../");
        String newPath=path.substring(index);
        System.out.println(newPath);
    }

}
