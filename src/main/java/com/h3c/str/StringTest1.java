package com.h3c.str;

import java.util.stream.Stream;

/**
 * created by yuxiaodong01 on 2019/10/29.
 */
public class StringTest1 {
    public static void main(String[] args) {
        String a = "1,2,3,4";
        String[] strings = a.split(",");
        Stream.of(strings).forEach(item -> {
            System.out.println(item);
        });
        Integer w = 3;
        System.out.println(3 == w);
    }
}
