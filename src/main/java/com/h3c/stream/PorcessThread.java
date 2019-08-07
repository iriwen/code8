package com.h3c.stream;

public class PorcessThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread :" + Thread.currentThread().getName());
        //Thread.sleep(10000);
        new Thread(() ->
        {
            for (; ; ) {
                System.out.println("thread 1 :" + Thread.currentThread().getName());
            }

        }).start();

        new Thread(() ->
        {
            for (; ; ) {
                System.out.println("thread 2 :" + Thread.currentThread().getName());
            }

        }).start();
    }
}
