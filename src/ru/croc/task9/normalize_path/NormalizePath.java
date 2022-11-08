package ru.croc.task9.normalize_path;

public class NormalizePath {
    public String normalizePath(String path) {
        //возможно, я усложнил решение, можно попробовать через цикл
        int index = path.lastIndexOf("../");
        int index1 = path.lastIndexOf("./");
        if (index + index1 != -2) {
            if (index1 > index + 2) {
                return path.substring(index1);//можно нормализовать до вида ./мемы/котики
            } else {
                return path.substring(index);//можно нормализовать до вида ../мемы/котики
            }
        } else {
            return path;//никаких изменений не нужно
        }

    }
}
