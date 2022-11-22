package ru.croc.task12;

import ru.croc.task12.filter.CommentsFilter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task12 {
    public static void main(String[] args) {
        List<String> comments = new ArrayList<>();
        comments.add("The devil was very angry");
        comments.add("Я чертил график, а потом пошел его сдавать");
        comments.add("Черт был очень злой");
        comments.add("I like deviled eggs");
        comments.add("Goog comment, without bad words");
        Set<String> blackList = new HashSet<>();
        blackList.add("devil");
        blackList.add("черт");
        CommentsFilter commentsFilter = new CommentsFilter();
        commentsFilter.filterComments(comments, blackList);
        for (String comment : comments) {
            System.out.println(comment);
        }
    }
}
