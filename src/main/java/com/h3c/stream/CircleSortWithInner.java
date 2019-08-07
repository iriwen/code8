package com.h3c.stream;

import com.h3c.entity.Circle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CircleSortWithInner {

    public static void main(String[] args) {
        CircleSortWithInner();
    }

    public static void CircleSortWithInner() {
        Circle circle1 = new Circle("hello3", 3);
        Circle circle2 = new Circle("hello1", 1);
        Circle circle3 = new Circle("hello4", 4);
        Circle circle4 = new Circle("hello2", 2);
        List<Circle> cirList = new ArrayList();

        cirList.add(circle1);
        cirList.add(circle2);
        cirList.add(circle3);
        cirList.add(circle4);

        Circle[] circles = {circle1, circle2, circle3, circle4};
        for (Circle circle : circles) {
            System.out.println(circle.getName());
        }
        Arrays.sort(circles, new Comparator<Circle>() {

            public int compare(Circle o1, Circle o2) {
                if (o1.getNum() > o2.getNum()) {
                    return 1;
                } else if (o1.getNum() < o2.getNum()) {
                    return -1;
                } else {
                    return -1;
                }
            }
        });
        System.out.println("after sort------ ");

        for (Circle circle : circles) {
            System.out.println(circle.getName());
        }

        //按提交时间降序--stream写法
        List<Circle> circleList = new LinkedList<>();//根据参数查询符合的实体列表

        //circleList = circleList.stream().sorted(Comparator.comparing(Company::getCreateTime).reversed()).collect(Collectors.toList());//根据创建时间倒排

        //按num 属性值 降序
        Collections.sort(cirList, (a, b) -> b.getNum().compareTo(a.getNum()));

    }
}
