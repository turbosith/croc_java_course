package ru.croc.task16;

import java.util.Comparator;

public class LogComparator implements Comparator<Log> {

    /**
     * Сравнение логов по дате
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return Сравнение логов по дате
     */
    @Override
    public int compare(Log o1, Log o2) {
        return Long.compare(o1.time(), o2.time());
    }


}
