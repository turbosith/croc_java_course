package ru.croc.task12;

import java.util.List;
import java.util.Set;

public class CommentsFilter implements BlackListFilter{

    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        for (int i=0; i< comments.size(); i++){\
            while(blackList.hasNext()){
                String element =(String) iterator.next();
            }
            if comments.indexOf(i).equals(blackList)
        }
    }
}


