package ru.croc.task8.read_package;

import ru.croc.task7.some_package.IllegalMoveException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReadWords {
    String fileName;

    /**
     *Создаёт новый {@code ReadWords}
     * @param fileName - имя файла, количество слов которого надо посчитать
     */
    public ReadWords(String fileName){//конструктор, задающий имя файла
    this.fileName=fileName;
}
public int wordsNumber() throws IllegalMoveException, IOException {//метод подсчета слов в файле
    try (Reader r = new InputStreamReader(
            new FileInputStream(fileName), "UTF-8")) {
        int c;
        int counter=0;
        char previous=' ';
        while ((c = r.read()) != -1){
           if((previous==' '|previous=='\n')&&(char)c!=' '&&c!=13){
               counter+=1;
           }
            previous=(char)c;
        }
        return counter;
    }


}

}
