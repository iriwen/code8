package com.h3c.jdk8;

import com.h3c.entity.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * created by yuxiaodong01 on 2019/11/07.
 */
public class ListToMapSort {

    public static void main(String[] args) {

        Integer[] sors = new Integer[]{4, 3, 2, 1};
        Apple a = new Apple(3, "sdsd");
        Apple b = new Apple(1, "sdsd");
        Apple c = new Apple(2, "sdsd");
        Apple d = new Apple(4, "sdsd");
        List<Apple> apples = new ArrayList<>();

        apples.add(a);
        apples.add(b);
        apples.add(c);
        apples.add(d);

        List<Integer> ids = apples.stream().map(item -> item.getId()).collect(Collectors.toList());

        Map<Integer, Apple> map = apples.stream().collect(Collectors.toMap(item -> item.getId(), item -> item, (h, j) -> h));

        List<Apple> sss = new ArrayList<>();

        for (Integer in : ids) {
            Apple apple = map.get(in);
            sss.add(apple);
        }
        System.out.println(sss);
    }
}
