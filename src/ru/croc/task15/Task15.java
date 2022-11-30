package ru.croc.task15;

import ru.croc.task15.department.DepartamentTree;

import java.io.IOException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) throws IOException, NoSuchElementException, IllegalStateException {
        System.out.println("Введите имя файла с конфигурациями");
        Scanner s = new Scanner(System.in);
        String fileName = s.nextLine();
        DepartamentTree departamentTree = new DepartamentTree();
        departamentTree.readConfiguration(fileName);
        System.out.println(departamentTree.workTime(departamentTree.getRootParent()));


    }
}
