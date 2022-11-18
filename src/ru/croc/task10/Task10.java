package ru.croc.task10;

import ru.croc.task10.password.FindPassword;

public class Task10 {
    public static volatile String hash;
    public static volatile String password;//volatile, чтобы сделать потокобезопасное решение


    public static void main(String[] args) {
        int threadsCounter = Integer.parseInt(args[0]);//
        hash = args[1];
        Thread[] threads = new Thread[threadsCounter];//создание потоков
        for (int i = 1; i <= threadsCounter; ++i) {
            threads[i - 1] = new Thread(new FindPassword(i,threadsCounter, 7));
            threads[i - 1].start();//начало работы
        }
        try {
            for (int i = 0; i < threadsCounter; ++i) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Пароль: " + password);
    }
}