package ru.croc.task15;

import ru.croc.task15.department.OrganizationDepartment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) throws IOException, NoSuchElementException,IllegalStateException {
        OrganizationDepartment parent;

    try (
    Scanner s = new Scanner(new FileReader("configuration.txt"))) {
        while (s.hasNextLine()){
            String scan=s.nextLine();
            String[] communications = scan.split(",");
            //if()
            //films.put(scan.charAt(0)-'0',scan.substring(2));}
    }


}}}
