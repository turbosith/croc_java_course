package ru.croc.task4;


import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {

    static String removeСomments(String textWithComments) {
        StringBuilder answer = new StringBuilder();//непотокобезопасная последовательность символов
        Pattern textPattern = Pattern.compile("(/\\*([\\S\\s]+?)\\*/)|(//.*)");//шаблон комментариев
        Matcher textMatcher = textPattern.matcher(textWithComments);//создаем  объект класса Matcher, чтобы иискать по шаблону
        while (textMatcher.find()) {
            textMatcher.appendReplacement(answer, "");//удаление комментариев
        }
        textMatcher.appendTail(answer);
        return String.valueOf(answer);

    }

    public static void main(String[] args) {
        String text = "/*\n"
                + "* My first ever program in Java!\n"
                + "*/\n"
                + "\n"
                + "/* main method */\n"
                + "public static void main(String[] args/* we put command line\n"
                + "arguments here*/) {\n"
                + "// this line prints my first greeting to the screen\n"
                + " System.out.println(\"Hi!\"); // :)\n"
                + "}\n"
                + "} // the end\n"
                + "// to be continued...\n";
        System.out.println(removeСomments(text));
    }

}