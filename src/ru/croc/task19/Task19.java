package ru.croc.task19;


public class Task19 {


    public static void main(String[] args) {

        Window wind = new Window();

        while (true) {
            for (int i = 1; i < 7; i++) {
                wind.loadImage("task19/static/img" + i + ".png");
                wind.drawIcon();
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}