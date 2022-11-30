package ru.croc.task16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ReadLogs {

    public List<File> readFilesFromDirectory(Path path) {
        File dir = new File(path.toUri()); //path указывает на директорию
        List<File> lst = new ArrayList<>();
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            if (file.isFile() && ((file.getName().endsWith(".log")) ||
                    (file.getName().endsWith(".trace")))) {
                lst.add(file);
            }
        }
        return lst;
    }

    public List<Log> readLogs(Path path) throws FileNotFoundException {
        List<Log> logList = new ArrayList<>();
        List<File> lst = readFilesFromDirectory(path);
        for (File file : lst) {
            try (Scanner s = new Scanner(new FileReader(file))) {
                while (s.hasNextLine()) {
                    String scan = s.nextLine();
                    String[] logParts = scan.split(" ");
                    Log log = new Log(Long.parseLong(logParts[0]), logParts[1]);
                    logList.add(log);
                }
            }
        }
        return logList;
    }

}
