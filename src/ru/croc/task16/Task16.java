package ru.croc.task16;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task16 {
    public static void main(String[] args) throws FileNotFoundException {
        ReadLogs readLogs = new ReadLogs();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Путь к папке с логами: ");
        String pathText = scanner.nextLine();
        List<Log> logs = readLogs.readLogs(Path.of(pathText)); // /Users/79165/Desktop/croc/java-school-2022-croc/src/ru/croc/task16/logs
        Collections.sort(logs, new LogComparator());
        for (Log log : logs) {
            System.out.println(log.getTime() + " " + log.getMessage());
        }

    }
}
