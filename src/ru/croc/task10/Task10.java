package ru.croc.task10;

import ru.croc.task10.password.FindPassword;

public class Task10 {

    public static volatile String password;//volatile, чтобы сделать потокобезопасное решение


    public static void main(String[] args) {
        int threadsCounter = Integer.parseInt(args[0]);//


        System.out.println("Пароль: " + password);
    }
}