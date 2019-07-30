package com.h3c.stream1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuxiaodong on 2018/12/27.
 */
public class TestCount {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        int num = getCountNum(list);
        System.out.println("replica is :" + num);
    }

    public static int getCountNum(List<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i : list) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int num = 0;
        for(Map.Entry  entry : map.entrySet()){
            if(Integer.parseInt(entry.getValue().toString())>=2){
                num++;
            }
        }
        return num;
    }

}
