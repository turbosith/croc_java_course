package ru.croc.task16;

import java.util.Comparator;

public class LogComparator implements Comparator<Log> {

    /**
     * Сравнение логов по дате
     *
     * @param firstLogObject  the first object to be compared.
     * @param secondLogObject the second object to be compared.
     * @return Сравнение логов по дате
     */
    @Override
    public int compare(Log firstLogObject, Log secondLogObject) {
        return Long.compare(firstLogObject.time(), secondLogObject.time());
    }


}
