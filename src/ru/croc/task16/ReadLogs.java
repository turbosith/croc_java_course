package ru.croc.task16;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

import java.util.List;


public class ReadLogs {


    private final List<Log> arrayLog = new ArrayList<>();

    private final List<BufferedReader> readers = new ArrayList<>();


    /**
     * Рекурсионное прохождение по файлам директории и поддиректорий, проверка типа файлов
     *
     * @param path - путь к директории с файлами
     */
    public void readFilesFromDirectory(Path path) throws IOException {


        File directory = new File(path.toUri()); //path указывает на директорию
        File[] folderEntries = directory.listFiles();
        assert folderEntries != null;
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                readFilesFromDirectory(entry.toPath());
            } else {
                if (entry.isFile() && ((entry.getName().endsWith(".log")) |
                        (entry.getName().endsWith(".trace")) | (entry.getName().endsWith(".LOG")))) {

                    firstBypass(entry);//записываем первичные данные файла


                }

            }

        }


    }


    /**
     * Вывод логов в отсортированном порядке
     *
     * @throws IOException - ошибка ввода вывода
     */
    public void outLogs() throws IOException {
        long maxTime = 1969778144951L;//максимальное время, для инициализации минимума


        LogComparator logComparator = new LogComparator();

        int indexMinLog = 0;//индекс самого раннего лога
        boolean flag = true;
        while (flag) {
            Log minLog = new Log(maxTime, "dfds");//инициализация лога, для нахождения минимального
            flag = false;
            for (int j = 0; j < arrayLog.size(); j++) {
                if (arrayLog.get(j) != null) {
                    flag = true;
                    if (arrayLog.get(j) != null && logComparator.compare(arrayLog.get(j), minLog) < 0) {

                        minLog = arrayLog.get(j);
                        indexMinLog = j;


                    }
                }

            }
            if (minLog.time() != maxTime) {
                System.out.println(minLog.time() + " " + minLog.message());
                arrayLog.set(indexMinLog, readLog(readers.get(indexMinLog)));
            }
        }


    }

    /**
     * Считывание лога
     *
     * @param bufferedReader - ридер, из которого мы должны получить следующую строку
     * @return - считанный лог
     */
    Log readLog(BufferedReader bufferedReader) throws IOException {
        String scan = bufferedReader.readLine();
        if (scan != null) {
            String[] logParts = scan.split(" ");

            return new Log(Long.parseLong(logParts[0]), logParts[1]);
        }
        return null;


    }

    /**
     * Первое прохождение по файлу, запись первой строки в массив и запись ридера
     *
     * @param file - файл, который нужно записать
     */
    private void firstBypass(File file) throws IOException {

        String line;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        if ((line = bufferedReader.readLine()) != null) {


            String[] logParts = line.split(" ");
            Log log = new Log(Long.parseLong(logParts[0]), logParts[1]);
            arrayLog.add(log);
            readers.add(bufferedReader);

        }
    }


}
