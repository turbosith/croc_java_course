package ru.croc.task9;


import ru.croc.task9.normalize_path.NormalizePath;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args)  {
        System.out.println("Введите путь");
        Scanner s = new Scanner(System.in);
        String path = s.nextLine();
        NormalizePath newPath = new NormalizePath();
        System.out.println(newPath.normalizePath(path));
    }

}
