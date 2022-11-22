package ru.croc.task12.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CommentsFilter implements BlackListFilter {
    /**
     * @param comments  list of comments; every comment
     *                  is a sequence of words, separated
     *                  by spaces, punctuation or line breaks
     * @param blackList list of words that should not
     *                  be present in a comment
     */
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        List<String> badComments = new ArrayList<>();//список плохих комментариев
        int asciiFrontChar = 0;//ASCII код предыдущего перед словом символа
        int asciiBackChar = 0;//ASCII последующего символа

        for (String comment : comments) {
            for (String blackWord : blackList) {
                //плохое слово без первого сивола(понадобиться для исключения плохих слов с заглавной буквы)
                String blackWordWithoutFirstSymbol = blackWord.substring(1);

                if (comment.contains(blackWordWithoutFirstSymbol)) {//проверка содержит ли комментарий плохое слово


                    int blackWordWithoutFirstSymbolIndex = comment.indexOf(blackWordWithoutFirstSymbol);
                    //проверка, можем ли мы получить предыдущий и последующий символы
                    if (blackWordWithoutFirstSymbolIndex != 1) {
                        asciiFrontChar = comment.charAt(blackWordWithoutFirstSymbolIndex - 2);
                    }
                    if (blackWordWithoutFirstSymbolIndex + blackWordWithoutFirstSymbol.length() != comment.length() + 1) {
                        asciiBackChar = comment.charAt(blackWordWithoutFirstSymbolIndex +
                                blackWordWithoutFirstSymbol.length());
                    }

                    //проверка, не содержится ли наше слово с другом и не начинается ли оно с заглавной буквы
                    if (!(isCharLetter(asciiFrontChar)) &
                            !(isCharLetter(asciiBackChar)) &
                            ((int) blackWord.charAt(0) !=
                                    comment.indexOf(blackWordWithoutFirstSymbolIndex) + 31)) {
                        badComments.add(comment);//добавление в список плохих комментариев
                    }
                }
            }
        }
        comments.removeAll(badComments);//удаление всех плохих комментариев
    }

    /**
     * Проверяет буква сивол или нет(работает на английском и русском языках)
     *
     * @param asciiChar ASCII код символа
     * @return буква это или нет
     */
    public boolean isCharLetter(int asciiChar) {
        return (asciiChar > 64 && asciiChar < 91) |
                (asciiChar > 96 && asciiChar < 123) |
                (asciiChar > 1039 && asciiChar < 1104);
    }
}



