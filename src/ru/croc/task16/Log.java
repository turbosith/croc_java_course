package ru.croc.task16;

public class Log {
    private final long time;
    private final String message;


    public long getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    public Log(long time, String message) {
        this.time = time;
        this.message = message;
    }
}
