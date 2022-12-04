package ru.croc.task16;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadLogs {


    /**
     * Рекурсионное прохождение по файлам директории и поддиректорий, проверка типа файлов
     *
     * @param path - путь к директории с файлами
     */
    public void readFilesFromDirectory(Path path) throws IOException {
        File finalLogFile = new File("Task16/logs/final_log.log");
        BufferedWriter writer = new BufferedWriter(new FileWriter(finalLogFile, true));
        File directory = new File(path.toUri()); //path указывает на директорию
        File[] folderEntries = directory.listFiles();
        assert folderEntries != null;
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                readFilesFromDirectory(entry.toPath());
            } else {
                if (entry.isFile() && ((entry.getName().endsWith(".log")) |
                        (entry.getName().endsWith(".trace")) | (entry.getName().endsWith(".LOG")))) {

                    try (Scanner s = new Scanner(new FileReader(entry))) {
                        while (s.hasNextLine()) {
                            String scan = s.nextLine();

                            writer.append(scan).append(" ");//запись лога в буфер, чтобы не тратить оперативную память


                        }
                    }


                }

            }

        }
        writer.close();//закрывание буфера

    }


    /**
     * Считывание логов из буфера
     *
     * @return - список логов
     * @throws FileNotFoundException - ошибка не нахождения файла
     */
    public List<Log> readLogs() throws FileNotFoundException {
        List<Log> logList = new ArrayList<>();
        File logFile = new File("Task16/logs/final_log.log");

        try (Scanner s = new Scanner(new FileReader(logFile))) {

            String scan = s.nextLine();
            String[] logParts = scan.split(" ");
            for (int i = 0; i < logParts.length - 1; i++) {
                Log log = new Log(Long.parseLong(logParts[i]), logParts[i + 1]);
                logList.add(log);
                i += 1;
            }


        }
        PrintWriter writer = new PrintWriter(logFile);//очистка буфера
        writer.print("");
        writer.close();

        return logList;
    }

}
