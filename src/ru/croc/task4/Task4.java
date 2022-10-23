package ru.croc.task3;

import java.util.Scanner;
import java.lang.String;

public class Task4 {


    public static void main(String[] args) {
        String text = "/*\n"
                + "* My first ever program in Java!\n"
                + "*/\n"
                + "\n"
                + "/* main method */\n"
                +"public static void main(String[] args/* we put command line\n"
                +"arguments here*/) {\n"
                +"// this line prints my first greeting to the screen\n"
                +" System.out.println(\"Hi!\"); // :)\n"
                +"}\n"
                +"} // the end\n"
                +"// to be continued...\n";
        text.replace(text[0],"")
    }


}