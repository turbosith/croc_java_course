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
                //делаем все буквы строчными, чтобы затронуть плохие слова с заглавной буквы
                String CommentLowerCase=comment.toLowerCase();
                int blackWordIndex=CommentLowerCase.indexOf(blackWord);//индекс плохого слова
                if (blackWordIndex!=-1) {//проверка содержит ли комментарий плохое слово
                    //проверка, можем ли мы получить предыдущий и последующий символы
                    if (blackWordIndex != 0) {
                        asciiFrontChar = CommentLowerCase.charAt(blackWordIndex - 1);
                    }
                    if (blackWordIndex + blackWord.length() != CommentLowerCase.length() ) {
                        asciiBackChar = CommentLowerCase.charAt(blackWordIndex +
                                blackWord.length());
                    }
                    if (!(isCharLetter(asciiFrontChar)) & //проверка, не содержится ли наше слово в другом
                            !(isCharLetter(asciiBackChar)))
                    {
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
        return (asciiChar > 96 && asciiChar < 123) |
                (asciiChar > 1039 && asciiChar < 1104);
    }
}



