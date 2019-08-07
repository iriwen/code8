package com.h3c.stream;

import com.h3c.entity.Bot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecursionTest {

    public static void main(String[] args) {
        Bot top = new Bot("0", "-1");

        Bot botOneLevel1 = new Bot("1","0");
        Bot botOneLevel2 = new Bot("2", "0");

        Bot botOneLevel11 = new Bot("1-1","1");
        Bot botOneLevel12 = new Bot("1-2","1");

        Bot botOneLevel121 = new Bot("1-2-1","1-2");
        Bot botOneLevel122 = new Bot("1-2-2","1-2");
        Bot botOneLevel123 = new Bot("1-2-3","1-2");

        List<Bot> topLevelChildren = new ArrayList<>();
        topLevelChildren.add(botOneLevel1);
        topLevelChildren.add(botOneLevel2);
        top.setChildren(topLevelChildren);

        List<Bot> oneLevelChildren = new ArrayList<>();
        oneLevelChildren.add(botOneLevel11);
        oneLevelChildren.add(botOneLevel12);
        botOneLevel1.setChildren(oneLevelChildren);


        List<Bot> twoLevelChildren = new ArrayList<>();
        twoLevelChildren.add(botOneLevel121);
        twoLevelChildren.add(botOneLevel122);
        twoLevelChildren.add(botOneLevel123);
        botOneLevel12.setChildren(twoLevelChildren);


        RecursionTest test = new RecursionTest();

        List<List<Bot>> gather = new ArrayList<>();
        List<Bot> root = new ArrayList<>();
        root.add(top);

        List<Bot> bots = test.addChildren(gather, root);
        System.out.println(bots);
    }

    public List<Bot> addChildren(List<List<Bot>>  gather, List<Bot> botroot) {
        gather.add(botroot) ;
        List<Bot> sublist =  botroot.stream().filter(item->{
            return item.getChildren() != null;
        }).map(item->item.getChildren()).flatMap(list->list.stream()).collect(Collectors.toList());
        if(sublist == null||sublist.isEmpty()) {
            List<Bot>  result  = gather.stream().flatMap(list->list.stream()).collect(Collectors.toList());
            return result;
        } else {
           return  addChildren(gather,sublist);
        }
    }
}
