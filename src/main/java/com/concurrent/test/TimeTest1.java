package com.concurrent.test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by LENOVO on 2017/6/25.
 */
public class TimeTest1 {
    public static void main(String[] args) {

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombling .....");
            }
        }, 1000);

        System.out.println("end " + new Date().getSeconds());
    }
}
