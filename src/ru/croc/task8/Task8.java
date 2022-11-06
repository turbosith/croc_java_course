package ru.croc.task8;

import ru.croc.task7.some_package.IllegalMoveException;
import ru.croc.task8.read_package.ReadWords;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Task8 {
    public static void main(String[] args) throws IllegalMoveException, IOException {
        ReadWords readWords=new ReadWords("input.txt");
        System.out.println(readWords.wordsNumber());
    }
}
