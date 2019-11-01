package com.h3c.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Apple {
    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer num;

    public Apple(Integer id, String name, BigDecimal money, Integer num) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
    }


    public Apple(String name, BigDecimal money, Integer num) {
        this.name = name;
        this.money = money;
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }


    public static void main(String[] args) {
        Apple a = new Apple("a", new BigDecimal(233), 22);
        Apple b = new Apple(11, "b", new BigDecimal(1233), 23);
        Apple c = new Apple(12, "c", new BigDecimal(123), 33);

        List<Apple> apples = new ArrayList<>();
        apples.add(a);
        apples.add(b);
        apples.add(c);
        List<Apple> collect = apples.stream().filter(item -> item.getId() == null).collect(Collectors.toList());

        collect.forEach(item -> item.setId(66));
        for (Apple apple : apples) {
            System.out.println(apple.getId());
        }
    }

}
