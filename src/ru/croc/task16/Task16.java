package ru.croc.task16;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;


public class Task16 {
    public static void main(String[] args) throws IOException {
        ReadLogs readLogs = new ReadLogs();
        String pathText = args[0];//ввод пути из консоли
        readLogs.readFilesFromDirectory(Path.of(pathText));
        List<Log> logs = readLogs.readLogs(); // /Users/79165/Desktop/croc/java-school-2022-croc/src/ru/croc/task16/logs
        logs.sort(new LogComparator());
        for (Log log : logs) { //вывод времени и сообщений логов
            System.out.println(log.time() + " " + log.message());
        }

    }
}
